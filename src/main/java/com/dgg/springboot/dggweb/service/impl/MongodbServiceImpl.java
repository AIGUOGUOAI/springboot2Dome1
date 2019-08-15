package com.dgg.springboot.dggweb.service.impl;

import com.dgg.springboot.dggweb.entity.User;
import com.dgg.springboot.dggweb.service.IMongodbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongodbServiceImpl implements IMongodbService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void insert(User user) {
		mongoTemplate.insert(user,"user");
	}

	@Override
	public List<Object> select(String key,String content) {
		Query query = new Query(Criteria.where(key).is(content));
		return mongoTemplate.find(query,Object.class,"user");
	}
}
