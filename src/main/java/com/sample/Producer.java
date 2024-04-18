package com.sample;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
    public static void main(String[] args) {
        String queueName = "demo";
        if (args.length > 0) {
            queueName = args[0];
        }
        if (queueName == null)
            queueName = "demo";
        ConnectionFactory factory = new ActiveMQConnectionFactory(
                "admin",
                "adminPassword",
                "tcp://localhost:61616");
        Connection connection;
        try {
            connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);

            String[] messages = new String[10];
            for (int i = 0; i < messages.length; i++) {
                messages[i] = "Hello AMQ Broker Message " + i;
            }
            MessageProducer producer = session.createProducer(destination);
            for (String message : messages) {
                TextMessage textMessage = session.createTextMessage(message);
                producer.send(textMessage);
            }

            System.out.println("Message published to " + queueName + "...");

            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
