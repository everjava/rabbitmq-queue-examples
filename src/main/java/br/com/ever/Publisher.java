package br.com.ever;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {

	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			//String body = "First message from rabbitmq";
			
			String[] body = {"um", "dois", "tres" , "quatro"};
			for (String str : body) {
				channel.basicPublish( "", "fila1", null, str.getBytes());
			}
			
			channel.close();
			connection.close();
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
}
