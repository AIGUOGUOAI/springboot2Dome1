package com.dgg.springboot.dggweb.controller;


import com.dgg.springboot.dggweb.activemq.Producer;
import com.dgg.springboot.dggweb.enums.Contents;
import com.dgg.springboot.dggweb.enums.MQKeyEnums;
import com.dgg.springboot.dggweb.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "activemq测试")
@RestController
@RequestMapping("/myActiveMQ")
public class ActivemqController {

	@Autowired
	private Producer producer;

	/**
	 * 发送消息
	 */
	@ApiOperation(value = "发送消息",notes = "activemq发送消息测试")
	@PostMapping("/sendMSG")
	public ResultUtil sendMSG(@RequestBody String msg){
		for(int i=0;i<10;i++){
			int sendResult = producer.sendMessage(Contents.ACTIVEMQ_KEY_TEST,msg+" 第 "+i+" 条消息");
		}
		return ResultUtil.success();
	}

	/**
	 * 接收消息
	 */
	@JmsListener(destination = Contents.ACTIVEMQ_KEY_TEST)
	public void receiveMSG(final String msg){
		System.out.println("接收到的消息"+msg);
	}

}
