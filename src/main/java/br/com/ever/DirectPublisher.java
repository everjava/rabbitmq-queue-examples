package br.com.ever;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Direct Exchange Publisher
 * 
 * @author everson
 *
 */
public class DirectPublisher {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		new DirectPublisher().publishToMobile(factory);
		new DirectPublisher().publishToTV(factory);
		new DirectPublisher().publishToAC(factory);
	}

	private Channel getChannel(Connection connection) throws IOException, TimeoutException {
		Channel channel = connection.createChannel();
		return channel;
	}

	private void publishToMobile(ConnectionFactory factory) throws IOException, TimeoutException {
		try (Connection connection = factory.newConnection()) {
			try (Channel channel = getChannel(connection)) {
				String message = "This is mobile";
				channel.basicPublish("Direct-Exchange", "mobile", null, message.getBytes());
			}
		}
	}

	private void publishToAC(ConnectionFactory factory) throws IOException, TimeoutException {
		try (Connection connection = factory.newConnection()) {
			try (Channel channel = getChannel(connection)) {
				String message = "This is ac";
				channel.basicPublish("Direct-Exchange", "ac", null, message.getBytes());
			}
		}
	}

	private void publishToTV(ConnectionFactory factory) throws IOException, TimeoutException {
		try (Connection connection = factory.newConnection()) {
			try (Channel channel = getChannel(connection)) {
				String message = "This is tv";
				channel.basicPublish("Direct-Exchange", "tv", null, message.getBytes());
			}
		}
	}

}
