package gov.nasa.api.neo.configuration;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    public String mongoHost = System.getProperty("mongo_url");

    public @Bean
    MongoTemplate mongoTemplate(){
        return new MongoTemplate(new MongoClient(mongoHost), "asteroids");
    }
}
