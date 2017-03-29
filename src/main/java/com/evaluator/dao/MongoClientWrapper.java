package com.evaluator.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

/**
 * Creates the mongo client and configures
 * @author Jagan
 *@version 1.0
 */
public class MongoClientWrapper {
	// TODO- make this class singleton
	public MongoClientWrapper(String host, int port, int connPerHost){
		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(connPerHost).build();
		this.client = new MongoClient(new ServerAddress(host, port), options);
	}
	
	private MongoClient client;

	public MongoClient getClient() {
		return client;
	}
	
}
