package gov.nasa.api.neo.restService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class DataService{

    @Autowired
    RestTemplate restTemplate;

    public String apiKey = System.getProperty("api_key");
    public int page = 0;

    public String fetch() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                ("https://api.nasa.gov/neo/rest/v1/neo/browse?page="+page+"&api_key="+apiKey), String.class);

        JSONObject dataPackage = new JSONObject(Objects.requireNonNull(response.getBody()));
        JSONArray nearEarthObjects = dataPackage.getJSONArray("near_earth_objects");

        System.out.println(nearEarthObjects);

        return "Success";
    }
}
