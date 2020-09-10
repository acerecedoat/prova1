package org.al.prova1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * http://localhost:8080/swagger-ui.html
 */
@OpenAPIDefinition()
@RestController
@RequestMapping("/tst")
class ProvaController {
	private static final Logger LOG = LoggerFactory.getLogger(ProvaController.class); 
	
    /**
    curl http://localhost:8080/tst 
     */
    @Operation(
    	summary = "Get hello.",
        description = "Returns any text message.",
        responses = {
       		@ApiResponse(responseCode = "200",
   				description = "File has returned.",
   				content = @Content(mediaType = "application/octet-stream")),
       		@ApiResponse(responseCode = "500", 
       			description = "Error returning file.",
       			content = @Content(mediaType = "text/plain")),
       		@ApiResponse(responseCode = "401", 
				description = "Unauthorized",
				content = @Content(mediaType = "text/plain"))
        }
    )
    @GetMapping
	public ResponseEntity<String> hello() {
    	LOG.info("Hi");
    	return ResponseEntity.ok("Success.");
	}
    
    @GetMapping("/csv")
    public ResponseEntity<String> list() {
    	
    	LOG.info("Hi");
    	
    	MongoClient mongoClient = new MongoClient("localhost", 27017);
    	DB database = mongoClient.getDB("myMongoDb");
    	database.createCollection("customers", null);
    	
    	DBCollection collection = database.getCollection("customers");
    	BasicDBObject document = new BasicDBObject();
    	document.put("name", "Shubham");
    	document.put("company", "Baeldung");
    	collection.insert(document);
    	
    	BasicDBObject query = new BasicDBObject();
    	query.put("name", "Shubham");
    	 
    	BasicDBObject newDocument = new BasicDBObject();
    	newDocument.put("name", "John");
    	 
    	BasicDBObject updateObject = new BasicDBObject();
    	updateObject.put("$set", newDocument);
    	 
    	collection.update(query, updateObject);
    	
    	BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("name", "John");
    	DBCursor cursor = collection.find(searchQuery);
    	 
    	while (cursor.hasNext()) {
    	    System.out.println(cursor.next());
    	}
    	
    	return ResponseEntity.ok("Success.");
    }
}
