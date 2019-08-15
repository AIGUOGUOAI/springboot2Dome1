package com.dgg.springboot.dggweb.controller;

import com.dgg.springboot.dggweb.service.ISalaryService;
import com.dgg.springboot.dggweb.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "转账测试")
@RestController
@RequestMapping("/salary")
public class SalaryController {

	@Autowired
	private ISalaryService salaryService;

	@ApiOperation(value = "一对一转账",notes = "卡号必填")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query",dataType = "String",name = "fromCard",value = "转出方卡号",required = true),
			@ApiImplicitParam(paramType = "query",dataType = "String",name = "toCard",value = "转入方卡号",required = true),
			@ApiImplicitParam(paramType = "query",dataType = "Double",name = "money",value = "转账金额",required = true)
	})
	@PutMapping("/transfer")
	public ResultUtil transfer(@RequestParam(name = "fromCard",required = true)String fromCard,
							   @RequestParam(name = "toCard",required = true)String toCard,
							   @RequestParam(name = "money",required = true)Double money) {
		int	result = 0;
		try {
			result = salaryService.transfer(fromCard,toCard,money);
			if(result > 0){
				return ResultUtil.success();
			}else{
				return ResultUtil.failed();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.failed();
		}

	}

}
