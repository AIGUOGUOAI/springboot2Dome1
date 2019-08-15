package com.dgg.springboot.dggweb.vo;

import com.dgg.springboot.dggweb.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class UserVo {
	private Integer userId;

	private String userName;

	private String phone;

	private String realName;

	private Integer provinceId;

	private Integer cityId;

	private String jobPosition;

	private String companyName;

	private String latestLoginTime;

	private String createTime;

	private String updateTime;

	public static UserVo entity2vo(User user){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		UserVo userVo = new UserVo();
		userVo.setUserId(user.getUserId());
		userVo.setUserName(user.getUserName());
		userVo.setRealName(user.getRealName());
		userVo.setPhone(user.getPhone());
		userVo.setCompanyName(user.getCompanyName());
		userVo.setJobPosition(user.getJobPosition());
		userVo.setCityId(user.getCityId());
		userVo.setProvinceId(user.getProvinceId());
		userVo.setCreateTime(user.getCreateTime().format(dateTimeFormatter));
		userVo.setUpdateTime(user.getUpdateTime().format(dateTimeFormatter));
		userVo.setLatestLoginTime(user.getLatestLoginTime().format(dateTimeFormatter));
		return userVo;
	}

	public static List<UserVo> entity2vo(List<User> users){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		List<UserVo> userVoList = new ArrayList<>();
		users.stream().forEach(user -> {
			UserVo userVo = new UserVo();
			userVo.setUserId(user.getUserId());
			userVo.setUserName(user.getUserName());
			userVo.setRealName(user.getRealName());
			userVo.setPhone(user.getPhone());
			userVo.setCompanyName(user.getCompanyName());
			userVo.setJobPosition(user.getJobPosition());
			userVo.setCityId(user.getCityId());
			userVo.setProvinceId(user.getProvinceId());
			userVo.setCreateTime(user.getCreateTime().format(dateTimeFormatter));
			userVo.setUpdateTime(user.getUpdateTime().format(dateTimeFormatter));
			userVo.setLatestLoginTime(user.getLatestLoginTime().format(dateTimeFormatter));
			userVoList.add(userVo);
		});
		return userVoList;
	}
}
