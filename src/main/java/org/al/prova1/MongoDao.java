package org.al.prova1;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

@Component
public class MongoDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public String doTest () {
		String msg = "";
		try {
//	    	MongoClient mongoClient = new MongoClient("localhost", 27017);
//	    	DB database = mongoClient.getDB("myMongoDb");
//	    	database.createCollection("customers", null);
//	    	
//	    	DBCollection collection = database.getCollection("customers");
//	    	BasicDBObject document = new BasicDBObject();
//	    	document.put("name", "Shubham");
//	    	document.put("company", "Baeldung");
//	    	collection.insert(document);
//	    	
//	    	BasicDBObject query = new BasicDBObject();
//	    	query.put("name", "Shubham");
//	    	 
//	    	BasicDBObject newDocument = new BasicDBObject();
//	    	newDocument.put("name", "John");
//	    	 
//	    	BasicDBObject updateObject = new BasicDBObject();
//	    	updateObject.put("$set", newDocument);
//	    	 
//	    	collection.update(query, updateObject);
//	    	
//	    	BasicDBObject searchQuery = new BasicDBObject();
//	    	searchQuery.put("name", "John");
//	    	DBCursor cursor = collection.find(searchQuery);
//	    	 
//	    	while (cursor.hasNext()) {
//	    	    System.out.println(cursor.next());
//	    	}
			
			MongoCollection<Document> collection = mongoTemplate.getCollection("githubcsv");
			System.out.println("1: "+collection);
			msg += "<br/>"+collection;
			
			mongoTemplate.createCollection("githubcsv");
			System.out.println("2: created");
			msg += "<br/>created";
			
			collection = mongoTemplate.getCollection("githubcsv");
			System.out.println("3: get");
			msg += "<br/>get";
			
	    	Document document = new Document();
	    	document.put("name", "Shubham");
	    	document.put("company", "Baeldung");
	    	collection.insertOne(document);
	    	System.out.println("4: inserted");
	    	msg += "<br/>inserted";
	    	
//	    	collection.find(Filters.eq("", ""), );
	    	for (Document doc : collection.find() ) {
	    		
	    		msg += "<br/>doc: "+doc;
	    	}
	    	
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			msg += "<br>[ERROR] "+ex.toString();
		}
		return msg;
	}
}
