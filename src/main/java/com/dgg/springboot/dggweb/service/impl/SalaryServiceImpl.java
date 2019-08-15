package com.dgg.springboot.dggweb.service.impl;

import com.dgg.springboot.dggweb.dao.SalaryMapper;
import com.dgg.springboot.dggweb.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * spring事物：
 *
 * 	1、开启注解事物
 * 	2、数据库操作失败的时候在service处理层抛出异常即可回滚事物
 * 	3、@Transaction注解的默认配置是propagation = Propagation.REQUIRED,rollbackFor = Exception.class
 * 		注：Propagation取值说明：
 * 				REQUIRED:(默认配置)在有transaction状态下执行；如果没有transaction则创建新的transaction。
 * 				SUPPORIS:如果当前有transaction，则在当前transaction下执行；如果没有transaction则在无transaction下执行。
 * 				MANDATORY:必须在有transaction状态下执行，如果当前没有transaction则抛出IllegalTransactionStateException异常。
 * 				REQUIRES_NEW:创建新的transaction并执行，如果当前已有transaction，则将当前transaction挂起。
 * 				NOT_SUPPORTED:在无transaction状态下执行，如果当前已有transaction则将当前事物挂起。
 * 				NEVER:在无transaction状态下执行，如果当前已有transaction则抛出IllegalTransactionStateException异常。
 * 				NESTED:如果当前存在事物，则嵌套在当前事物内执行；如果当前没有事物则执行与REQUIRED类似操作。
 *
 */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
@Service
public class SalaryServiceImpl implements ISalaryService {

	@Autowired
	private SalaryMapper salaryMapper;

	@Override
	public int transfer(String fromCard, String toCard,double money) throws Exception {

		int outResult = salaryMapper.transOut(fromCard,money);
		if(outResult < 1){
			throw new Exception("转出失败");
		}

		int inResult = salaryMapper.transIn(toCard,money);
		if(inResult < 1){
			throw new Exception("转入失败");
		}

		return 1;
	}
}
