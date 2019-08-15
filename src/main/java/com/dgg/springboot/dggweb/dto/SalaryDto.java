package com.dgg.springboot.dggweb.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 薪资
 */
@ApiModel(value = "薪资")
@Data
public class SalaryDto {

	@ApiModelProperty(dataType = "Integer",value = "id",example = "1")
	private Integer id;

	@ApiModelProperty(dataType = "String",value = "userName",example = "乔峰")
	private String userName;

	@ApiModelProperty(dataType = "double",value = "salary",example = "1000")
	private Double salary;

	@ApiModelProperty(dataType = "String",value = "carNum",example = "1")
	private String carNum;
}
