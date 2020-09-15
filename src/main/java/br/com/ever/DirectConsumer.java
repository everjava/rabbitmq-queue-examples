package br.com.ever;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * Direct Exchange Consumer
 * @author everson
 *
 */
public class DirectConsumer {
	public static void main() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody());
			System.out.println("Message received = " + message);
		};
		channel.basicConsume("Mobile", true, deliverCallback, consumerTag -> {});
		//channel.basicConsume("AC", true, deliverCallback, consumerTag -> {});
		//channel.basicConsume("TV", true, deliverCallback, consumerTag -> {});
	}

}
