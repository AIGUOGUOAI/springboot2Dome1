package com.dgg.springboot.dggweb.dao;

import com.dgg.springboot.dggweb.base.BaseMapper;
import com.dgg.springboot.dggweb.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
	List<User> selectUser(@Param("entity") User user);

	List<User> selectUserByContent(@Param("content") String content);
}
