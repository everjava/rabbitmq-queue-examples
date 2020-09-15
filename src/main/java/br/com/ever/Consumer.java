package br.com.ever;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {
	public static void main(String[] args) {		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection;
		try {
			connection = factory.newConnection();
			Channel channel = connection.createChannel();			
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				String message = new String(delivery.getBody());
				 System.out.println(message);
			};			
			channel.basicConsume("fila1", true, deliverCallback, consumerTag -> {} );			
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
}
