package com.dgg.springboot.dggweb.controller;


import com.dgg.springboot.dggweb.entity.User;
import com.dgg.springboot.dggweb.service.IMongodbService;
import com.dgg.springboot.dggweb.utils.ResultUtil;
import com.dgg.springboot.dggweb.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "MongoDB")
@RestController
@RequestMapping("/mongodb")
public class MongoDBController {

	@Autowired
	private IMongodbService mongodbService;

	@ApiOperation(value = "插入用户",notes = "插入")
	@PostMapping("/insert")
	public ResultUtil insert(@RequestBody User user){
		mongodbService.insert(user);
		return ResultUtil.success();
	}


	@ApiOperation(value = "查询用户",notes = "查询")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query",name = "key",value = "查询内容key",required = false,dataType = "String"),
			@ApiImplicitParam(paramType = "query",name = "content",value = "查询内容",required = false,dataType = "String")
	})
	@GetMapping("/select")
	public ResultUtil select(@RequestParam(name = "key",required = false) String key,@RequestParam(name = "content",required = false) String content){
		List<Object> userList = mongodbService.select(key,content);
		return ResultUtil.success(userList);
	}

}
