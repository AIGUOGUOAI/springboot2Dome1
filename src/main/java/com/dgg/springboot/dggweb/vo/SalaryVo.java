package com.dgg.springboot.dggweb.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 薪资
 */
@Data
public class SalaryVo {
	private Integer id;
	private String userName;
	private Double salary;
	private String carNum;
}
