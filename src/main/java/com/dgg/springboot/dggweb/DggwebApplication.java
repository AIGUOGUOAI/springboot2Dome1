package com.dgg.springboot.dggweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = "com.dgg.springboot.dggweb.dao")
public class DggwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DggwebApplication.class, args);
	}

}
