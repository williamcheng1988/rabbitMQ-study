package com.william.rabbitmq.demo;

public interface MQProducer {
	/**
	 * ������Ϣ��ָ������
	 * 
	 * @param queueKey
	 * @param object
	 */
	public void sendDataToQueue(String queueKey, Object object);
}