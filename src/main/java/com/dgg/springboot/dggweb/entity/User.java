package com.dgg.springboot.dggweb.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 4463434511396806236L;
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "province_id")
    private Integer provinceId;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "job_position")
    private String jobPosition;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "latest_login_time")
    private LocalDateTime latestLoginTime;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;
}