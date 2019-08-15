package com.dgg.springboot.dggweb.service;

import com.dgg.springboot.dggweb.entity.User;
import com.dgg.springboot.dggweb.utils.PageData;

import java.util.List;

public interface IUserService {
	List<User> selectUser(User user);

	int insertUser(User user);

	PageData<User> selectUserPage(String content, Integer pageNo, Integer pageSize);

	List<User> selectUserByContent(String content);

	Integer deleteUser(Integer userId);

	Integer updateUser(User user);
}
