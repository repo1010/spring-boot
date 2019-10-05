package com.spring.angularspring.service;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.angularspring.model.Product;

@Service
public class RabbitMQService {

	@Autowired
	private AmqpTemplate rabbitmqTemplate;

	@Value("${app.rabbitmq.routingkey}")
	private String routingKey;

	@Value("${app.rabbitmq.exchange}")
	private String exchang;
	
	public boolean publishMesaage(List<Product> empList, String operation) {
		rabbitmqTemplate.convertAndSend(exchang, routingKey, operation +" : "+( empList.toString()));
		System.out.println("Send Message for Operation "+ operation+" :" + (empList.toString()));
		
		return true;		
	}
}
