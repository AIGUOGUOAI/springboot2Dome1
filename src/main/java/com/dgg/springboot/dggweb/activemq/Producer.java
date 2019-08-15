package com.dgg.springboot.dggweb.activemq;

import com.dgg.springboot.dggweb.enums.MQKeyEnums;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

/**
 * activemq的生产者
 */
@Log4j2
@Component
@EnableCaching
public class Producer {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	public int sendMessage(String key, Object value){
		try {
			jmsMessagingTemplate.convertAndSend(key,value);
			log.info("放入activemq成功key："+key);
			return 1;
		} catch (MessagingException e) {
			log.info("放入activemq失败key:"+key+" errorMSG:"+e);
			return 0;
		}
	}

}
