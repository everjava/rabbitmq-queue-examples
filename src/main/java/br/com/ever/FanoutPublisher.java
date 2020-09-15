package br.com.ever;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Fanout publisher
 * 
 * @author everson
 *
 */
public class FanoutPublisher {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		String message = "Message For Mobile and AC";
		//envia para todas as filas cadastradas na Fanout-Exchange
		channel.basicPublish("Fanout-Exchange", "", null, message.getBytes());
		channel.close();
		connection.close();
	}
}
