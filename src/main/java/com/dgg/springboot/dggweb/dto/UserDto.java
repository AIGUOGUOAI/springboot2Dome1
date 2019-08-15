package com.dgg.springboot.dggweb.dto;

import com.dgg.springboot.dggweb.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ApiModel(value = "用户对象模型")
@Data
public class UserDto {

	@ApiModelProperty(value = "userId",dataType = "Integer",example = "1")
	private Integer userId;

	@ApiModelProperty(value = "userName",dataType = "String",example = "qf")
	private String userName;

	@ApiModelProperty(value = "phone",dataType = "String",example = "66668888")
	private String phone;

	@ApiModelProperty(value = "realName",dataType = "String",example = "乔峰")
	private String realName;

	@ApiModelProperty(value = "provinceId",dataType = "Integer",example = "1")
	private Integer provinceId;

	@ApiModelProperty(value = "cityId",dataType = "Integer",example = "1")
	private Integer cityId;

	@ApiModelProperty(value = "jobPosition",dataType = "String",example = "丐帮帮主")
	private String jobPosition;

	@ApiModelProperty(value = "companyName",dataType = "String",example = "丐帮")
	private String companyName;

	@ApiModelProperty(value = "latestLoginTime",dataType = "String",example = "2019-07-23 12:12:12")
	private String latestLoginTime;

	@ApiModelProperty(value = "createTime",dataType = "String",example = "2019-07-23 12:12:12")
	private String createTime;

	@ApiModelProperty(value = "updateTime",dataType = "String",example = "2019-07-23 12:12:12")
	private String updateTime;


	public static User dto2entity(UserDto userDto){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTime  = LocalDateTime.now();
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setUserName(userDto.getUserName());
		user.setPhone(userDto.getPhone());
		user.setRealName(userDto.getRealName());
		user.setProvinceId(userDto.getProvinceId());
		user.setCityId(userDto.getCityId());
		user.setJobPosition(userDto.getJobPosition());
		user.setCompanyName(userDto.getCompanyName());
		user.setLatestLoginTime(userDto.getLatestLoginTime() == null ? localDateTime : LocalDateTime.parse(userDto.getLatestLoginTime(),dateTimeFormatter));
		user.setCreateTime(userDto.getCreateTime() == null ? localDateTime : LocalDateTime.parse(userDto.getCreateTime(),dateTimeFormatter));
		user.setUpdateTime(userDto.getUpdateTime() == null ? localDateTime : LocalDateTime.parse(userDto.getUpdateTime(),dateTimeFormatter));
		return user;
	}


}
