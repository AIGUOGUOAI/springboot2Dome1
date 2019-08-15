package com.dgg.springboot.dggweb.controller;

import com.dgg.springboot.dggweb.dto.UserDto;
import com.dgg.springboot.dggweb.entity.User;
import com.dgg.springboot.dggweb.service.IUserService;
import com.dgg.springboot.dggweb.utils.PageData;
import com.dgg.springboot.dggweb.utils.ResultUtil;
import com.dgg.springboot.dggweb.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * header：请求参数放置于Request Header，使用@RequestHeader获取
	 * query：请求参数放置于请求地址，使用@RequestParam获取
	 * path：（用于restful接口）-->请求参数的获取：@PathVariable
	 * body：（不常用）
	 * form（不常用）
	 */
	@ApiOperation(value = "分页查询用户",notes = "查询内容包括用户名、手机号、真实姓名")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query",name = "content",value = "查询内容",required = false,dataType = "String"),
			@ApiImplicitParam(paramType = "query",name = "pageNo",value = "当前页，默认1",required = false,dataType = "Integer"),
			@ApiImplicitParam(paramType = "query",name = "pageSize",value = "当前页大小，默认20",required = false,dataType = "Integer")
	})
	@GetMapping("/selectUserPage")
	public ResultUtil selectUserPage(@RequestParam(name = "content",required = false)String content,
									 @RequestParam(name = "pageNo",defaultValue = "1",required = false)Integer pageNo,
									 @RequestParam(name = "pageSize",defaultValue = "20",required = false)Integer pageSize){
		PageData<User> pageData = userService.selectUserPage(content,pageNo,pageSize);
		return ResultUtil.success(pageData);
	}

	@ApiOperation(value = "删除用户",notes = "通过id删除用户")
	@ApiImplicitParam(paramType = "path",name = "userId",value = "删除人iD",dataType = "Integer")
	@DeleteMapping("/deleteUser/{userId}")
	public ResultUtil deleteUser(@PathVariable(name = "userId")Integer userId){
		Integer count = userService.deleteUser(userId);
		if(count <= 0){
			return ResultUtil.failed();
		}else{
			return ResultUtil.success();
		}
	}

	@ApiOperation(value = "查询用户",notes = "通过封装用户对象查询")
	@ApiImplicitParam(paramType = "query",name = "content",value = "查询内容",required = false,dataType = "String")
	@GetMapping("/selectUser")
	public ResultUtil selectUser(@RequestParam(name = "content",required = false) String content){
		List<User> userList = userService.selectUserByContent(content);
		return ResultUtil.success(UserVo.entity2vo(userList));
	}

	@ApiOperation(value = "插入用户",notes = "通过封装用户对象进行插入")
	@PostMapping("/insertUser")
	public ResultUtil insertUser(@RequestBody UserDto userDto){
		int count = userService.insertUser(UserDto.dto2entity(userDto));
		if(count <= 0){
			return ResultUtil.failed();
		}else{
			return  ResultUtil.success();
		}
	}




	@ApiOperation(value = "更新用户",notes = "根据id通过封装用户对象进行更新用户")
	@PutMapping("/updateUser")
	public ResultUtil updateUser(@RequestBody UserDto userDto){
		Integer count = userService.updateUser(UserDto.dto2entity(userDto));
		if(count > 0){
			return ResultUtil.success();
		}else{
			return ResultUtil.failed();
		}

	}


	@ApiOperation(value = "批量插入用户",notes = "验证mybatis批量插入带有下划线数值,旨在验证批量操作")
	@PostMapping("/insertUserBatch")
	public ResultUtil insertUserBatch(@RequestBody UserDto userDto){
		int count = userService.insertUserBatch(UserDto.dto2entity(userDto));
		if(count <= 0){
			return ResultUtil.failed();
		}else{
			return  ResultUtil.success();
		}
	}

	@ApiOperation(value = "批量更新用户",notes = "验证mybatis批量更新带有下划线数值,旨在验证批量操作")
	@PostMapping("/updateUserBatch")
	public ResultUtil updateUserBatch(@RequestBody UserDto userDto){
		int count = userService.updateUserBatch(UserDto.dto2entity(userDto));
		if(count <= 0){
			return ResultUtil.failed();
		}else{
			return  ResultUtil.success();
		}
	}

}
