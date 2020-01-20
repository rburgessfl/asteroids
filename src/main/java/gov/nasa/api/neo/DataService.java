package gov.nasa.api.neo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataService{

    @Autowired
    RestTemplate restTemplate;

    public String apiKey = System.getProperty("api_key");
    public int page = 0;

    public String fetch() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                ("https://api.nasa.gov/neo/rest/v1/neo/browse?page="+page+"&api_key="+apiKey), String.class);
        String responseBody = response.getBody();
        String dataPackage = responseBody.substring(responseBody.indexOf("near_earth_objects"));
        dataPackage = dataPackage.substring(dataPackage.indexOf(":")+1);
        int end = dataPackage.length()-1;

        System.out.println(dataPackage.substring(0, end));
        return dataPackage.substring(0, end);
    }
}
