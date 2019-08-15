package com.dgg.springboot.dggweb.enums;

public enum MQKeyEnums {

	activeMQKeyTest("activeMQKeyTest");

	private String activeMQKey ;

	MQKeyEnums(String activeMQKey) {
		this.activeMQKey = activeMQKey;
	}

	public String getActiveMQKey() {
		return activeMQKey;
	}

	public void setActiveMQKey(String activeMQKey) {
		this.activeMQKey = activeMQKey;
	}
}
