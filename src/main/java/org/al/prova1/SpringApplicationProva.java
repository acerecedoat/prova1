package org.al.prova1;

import org.dizitart.no2.Nitrite;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApplicationProva extends SpringBootServletInitializer {
	
	@Value("${nitrite.database.path}")
	private String dagtabaseFilePath;
	
	@Value("${nitrite.database.username}")
	private String dagtabaseFileUsername;
	
	@Value("${nitrite.database.password}")
	private String dagtabaseFilePassword;
	
    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationProva.class, args);
    }
    
    @Bean
    public Nitrite nosqlDatabase() {
    	return Nitrite.builder()
    	        .compressed()
    	        .filePath(dagtabaseFilePath)
    	        .openOrCreate(dagtabaseFileUsername, dagtabaseFilePassword);
    }
}
