package org.al.prova1;

import java.util.Date;
import java.util.List;

import org.dizitart.no2.Document;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DatabaseDao {

	@Autowired
	Nitrite db;
	
	public static class GithubRow_v1 {
		String month;
		Double value;
		public GithubRow_v1 () {}
		public GithubRow_v1 (String month, Double value) {
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
//			// TEST REPO
//			ObjectRepository<GithubRow_v1> repository = db.getRepository(GithubRow_v1.class);
//	    	repository.insert(new GithubRow_v1("2020-07", 0.8));
//	    	System.out.println("inserted");
//	    	msg += "<br/>inserted";
//	    	List<GithubRow_v1> list = repository.find(ObjectFilters.eq("month", "2020-07")).toList();
//	    	for (GithubRow_v1 row : list) {
//	    		System.out.println("row: "+row);
//	    		msg += "<br/>"+row;
//	    	}
	    	

	    	db.getCollection("github_co").insert(Document.createDocument("firstName", "John")
	    		     .put("lastName", "Doe")
	    		     .put("birthDay", new Date())
	    		     .put("data", new byte[] {1, 2, 3}));
	    	
	    	
	    	List<Document> docs = db.getCollection("github_co").find().toList();
	    	for (Document doc : docs) {
	    		System.out.println("doc: "+doc);
	    		msg += "<br/>"+doc;
	    	}
	    	
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			msg += "<br>[ERROR] "+ex.toString();
		}
		return msg;
	}
}
