package com.dgg.springboot.dggweb.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.dgg.springboot.dggweb.utils.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisCfg {

	@Bean
	public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
		//使用fastjson序列化
		FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);

		// fastjson在2017年3月爆出了在1.2.24以及之前版本存在远程代码执行高危安全漏洞。
		// 所以要使用ParserConfig.getGlobalInstance().addAccept("com.xiaolyuh.");指定序列化白名单
		ParserConfig.getGlobalInstance().addAccept("com.dgg.springboot.dggweb.entity.");

		//value使用fastJsonRedisSerializer序列化
		redisTemplate.setValueSerializer(fastJsonRedisSerializer);
		redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
		//key使用fastJsonRedisSerializer序列化
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());

		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return  redisTemplate;
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
		return stringRedisTemplate;
	}

}
