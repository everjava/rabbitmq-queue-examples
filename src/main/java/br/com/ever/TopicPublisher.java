package br.com.ever;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;



/**
 *  ---------------------
 *  ---Exchange binding
 *  #.ac 	   = AC  		</br>
 *  *.mobile.* = Mobile		</br>
 *  *.tv.*.*   = TV			</br>
 *  ---
 *  * = um item     		</br>
 *  # = varios items 		</br>
 *  --------------------   
 *  xx.yyy.ac 		= AC 		</br>
 *  xx.ac      		= AC 		</br>
 *  ac.yyy.xx 		= N/A 		</br>
 *  yy.xx.w.ac  	= AC 		</br>
 *  tv.mobile.ac 	= Mobile/AC </br>
 *  mobile.tv.ac	= AC	 	</br>
 *  mobile.tv.ac.xe = TV		</br>
 *
 */
public class TopicPublisher {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();		
		String message = "Message for Mobile and AC";		
		channel.basicPublish("Topic-Exchange", "tv.mobile.ac", null, message.getBytes());		
		channel.close();
		connection.close();
	}
}
























