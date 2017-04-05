package demorabbit;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 * Created by striker on 4/6/17.
 */
public class Publish {

    private final static String QUEUE_HOST = "localhost";
    private final static String QUEUE_NAME = "hello";
    private final static String QUEUE_MESSAGE = "hello from java";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(QUEUE_HOST);
        Connection connection = factory.newConnection();
        Channel channel =  connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = QUEUE_MESSAGE;
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));

        System.out.print(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();

    }

}
