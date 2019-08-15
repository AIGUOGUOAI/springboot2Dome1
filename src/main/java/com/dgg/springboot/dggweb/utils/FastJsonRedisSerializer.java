package com.dgg.springboot.dggweb.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

	private static final Charset DEFULT_CHARSET = Charset.forName("UTF-8");

	private Class<T> clazz;

	public FastJsonRedisSerializer(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	/**
	 * 序列化的时候是按照属性的字母来的排序的
	 * @param t
	 * @return
	 * @throws SerializationException
	 */
	@Override
	public byte[] serialize(T t) throws SerializationException {
		if(null == t){
			return new byte[0];
		}else{
			System.out.println("自定义序列化成功");
			return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFULT_CHARSET);
		}
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if(null == bytes || bytes.length == 0){
			return null;
		}else{
			System.out.println("自定义反序列化成功");
			return JSON.parseObject(new String(bytes,DEFULT_CHARSET),clazz);
		}
	}
}
