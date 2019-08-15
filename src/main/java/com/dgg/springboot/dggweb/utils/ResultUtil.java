package com.dgg.springboot.dggweb.utils;

import lombok.Data;

@Data
public class ResultUtil<T> {
	private int status;
	private String msg;
	private T data;

	public static ResultUtil success(){
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setStatus(1);
		resultUtil.setMsg("success");
		resultUtil.setData(null);
		return  resultUtil;
	}

	public static ResultUtil success(String msg,Object data){
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setStatus(1);
		resultUtil.setMsg(msg);
		resultUtil.setData(data);
		return  resultUtil;
	}

	public static ResultUtil success(Object data){
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setStatus(1);
		resultUtil.setMsg("success");
		resultUtil.setData(data);
		return  resultUtil;
	}

	public static ResultUtil failed(Object data){
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setStatus(0);
		resultUtil.setMsg("error");
		resultUtil.setData(data);
		return  resultUtil;
	}

	public static ResultUtil failed(String msg,Object data){
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setStatus(0);
		resultUtil.setMsg(msg);
		resultUtil.setData(data);
		return  resultUtil;
	}

	public static ResultUtil failed(){
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setStatus(0);
		resultUtil.setMsg("error");
		resultUtil.setData(null);
		return  resultUtil;
	}

	public static ResultUtil failed(String msg){
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setStatus(0);
		resultUtil.setMsg(msg);
		resultUtil.setData(null);
		return  resultUtil;
	}
}
