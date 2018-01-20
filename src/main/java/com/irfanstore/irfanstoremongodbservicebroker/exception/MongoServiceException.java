package com.irfanstore.irfanstoremongodbservicebroker.exception;

import org.springframework.cloud.servicebroker.exception.ServiceBrokerException;


public class MongoServiceException extends ServiceBrokerException {

	private static final long serialVersionUID = 8667141725171626000L;

	public MongoServiceException(String message) {
		super(message);
	}
	
}
