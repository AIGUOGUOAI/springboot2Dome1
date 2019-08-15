package com.dgg.springboot.dggweb.service;

import com.dgg.springboot.dggweb.entity.User;

import java.util.List;

public interface IMongodbService {
	void insert(User user);
	List<Object> select(String key,String content);
}
