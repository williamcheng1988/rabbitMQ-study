package com.william.rabbitMQ.sample;

import java.io.IOException;
import java.util.Scanner;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 消息生产者
 * 
 * @author William Cheng
 * 2016年10月5日-下午9:20:40
 */
public class Publisher {
	private final static String QUEUE_NAME = "williamMQ";

	public static void main(String[] args) throws IOException {

		System.out.println(" [#] 请输入需要发送的消息：");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\r");
		while (sc.hasNextLine()) {
			// 接受输入
			String message = sc.next();
			publishMsg(message.replace("\r", ""));
		}
		sc.close();
	}

	private static void publishMsg(String message) throws IOException {
		System.out.println(" [#] 待发送消息："+message);
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [v] Sent '" + message + "'");
		
		channel.close();
		connection.close();
	}
}