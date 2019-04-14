package com.aitongyi.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-04-14
 * Time: 23:25:00
 * Description:
 */
public class Provider
{
    public final static String QUEUE="HELLO";
    public static void main(String[] args) throws IOException, TimeoutException
    {
        ConnectionFactory connectionFactory= new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE,false,false,false,null);
        channel.basicPublish("",QUEUE,null,"good luck".getBytes());
        channel.close();
        connection.close();
    }
}
