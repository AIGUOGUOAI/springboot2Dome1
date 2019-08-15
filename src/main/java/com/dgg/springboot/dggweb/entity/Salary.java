package com.dgg.springboot.dggweb.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 薪资
 */
@Data
@Entity
@Table(name = "t_salary")
public class Salary {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "salary")
	private Double salary;

	@Column(name = "carNum")
	private String carNum;
}
