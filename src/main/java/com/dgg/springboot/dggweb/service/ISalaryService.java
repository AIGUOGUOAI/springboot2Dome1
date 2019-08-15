package com.dgg.springboot.dggweb.service;

public interface ISalaryService {
	int transfer(String fromCard, String toCard,double money) throws Exception;
}
