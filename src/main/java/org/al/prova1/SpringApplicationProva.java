package org.al.prova1;

import org.dizitart.no2.Nitrite;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApplicationProva extends SpringBootServletInitializer {
	
    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationProva.class, args);
    }
    
    @Bean
    public Nitrite nosqlDatabase() {
    	return Nitrite.builder()
    	        .compressed()
    	        .filePath("target/nitrite/test.db")
    	        .openOrCreate("sa", "sa");
    }
}
