package org.al.prova1;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;

@SpringBootApplication
public class SpringApplicationProva extends SpringBootServletInitializer {
	
    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationProva.class, args);
    }
    
//    @Bean
//    public MongoInMemory mongoInMemory(
//        @Value("${spring.data.mongodb.port}") int port,
//        @Value("${spring.data.mongodb.host}")  String host) {
//            return new MongoInMemory(port, host)
//    }
    
//    @Bean
//    public MongoTemplate mongoTemplate() throws IOException {
//        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
//        mongo.setBindIp("localhost");
//        MongoClient mongoClient = mongo.getObject();
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "myMongoDb");
//        return mongoTemplate;
//    }
}
