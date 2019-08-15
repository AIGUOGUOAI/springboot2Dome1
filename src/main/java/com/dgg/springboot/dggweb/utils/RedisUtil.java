package com.dgg.springboot.dggweb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil<T> {

	@Autowired
	private RedisTemplate<String,T> redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public void  setForValue(String key ,T obj){
		redisTemplate.opsForValue().set(key,obj);
	}

	public T getKey(String key ){
		return redisTemplate.opsForValue().get(key);
	}
}
