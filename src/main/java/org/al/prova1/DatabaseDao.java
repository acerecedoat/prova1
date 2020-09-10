package org.al.prova1;

import java.util.List;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DatabaseDao {

	@Autowired
	Nitrite db;
	
	public static class GithubRow {
		String month;
		Double value;
		public GithubRow () {}
		public GithubRow (String month, Double value) {
			this.month = month;
			this.value = value;
		}
		@Override
		public String toString() {
			return getClass().getSimpleName()+"[month:"+month+", value:"+value+"]";
		}
	}
	
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
			
			ObjectRepository<GithubRow> repository = db.getRepository(GithubRow.class);
			
//			NitriteCollection collection = db.getCollection("githubcsv");
//			System.out.println("1: "+collection);
//			msg += "<br/>"+collection;
//			
//			collection = db.getCollection("githubcsv");
//			System.out.println("3: get");
//			msg += "<br/>get";
			
	    	repository.insert(new GithubRow("2020-07", 0.8));
	    	System.out.println("inserted");
	    	msg += "<br/>inserted";
	    	
//	    	collection.find(Filters.eq("", ""), );
//	    	for (Document doc : collection.find() ) {
//	    		msg += "<br/>doc: "+doc;
//	    	}
	    	
	    	List<GithubRow> list = repository.find(ObjectFilters.eq("month", "2020-07")).toList();
	    	for (GithubRow row : list) {
	    		System.out.println("row: "+row);
	    		msg += "<br/>"+row;
	    	}

		} 
		catch (Exception ex) {
			ex.printStackTrace();
			msg += "<br>[ERROR] "+ex.toString();
		}
		return msg;
	}
}
