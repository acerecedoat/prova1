package org.al.prova1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@Autowired
	MongoDao mongoDao;
	
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
    	return ResponseEntity.ok("Success: "+mongoDao.doTest());
    }
}
