package com.dgg.springboot.dggweb.dao;

import com.dgg.springboot.dggweb.base.BaseMapper;
import com.dgg.springboot.dggweb.entity.Salary;
import org.apache.ibatis.annotations.Param;

public interface SalaryMapper extends BaseMapper<Salary> {

	int transOut(@Param("fromCard") String fromCard,@Param("money") double money);

	int transIn(@Param("toCard")String toCard,@Param("money") double money);
}
