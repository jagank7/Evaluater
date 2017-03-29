package com.evaluator.dao.impl;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.evaluator.dao.MongoClientWrapper;
import com.evaluator.dao.SolutionsDao;
import com.evaluator.service.model.Solution;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * This class is responsible to implement method that write solution to data
 * store
 * 
 * @author Jagan
 * @version 1.0
 */
public class SolutionsDaoImpl implements SolutionsDao {

	private MongoClientWrapper mongoWrapper;
	private MongoDatabase db;
	private MongoCollection<Document> collection;
	
	public SolutionsDaoImpl(MongoClientWrapper mongoWrapper) {
		this.mongoWrapper = mongoWrapper;
		db = mongoWrapper.getClient().getDatabase("test");
		collection = db.getCollection("solution");
	}

	public String writeSolution(Solution sol) {
		ObjectId id = ObjectId.get();
		Document doc = new Document("_id", id).append("code", sol.getCode());
		collection.insertOne(doc);
		System.out.println(id.toHexString());
		return id.toHexString();
	}

	public Solution readSoluiton(String _id) {
		return null;
	}

}
