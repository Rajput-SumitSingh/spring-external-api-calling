package com.spoil3rrr.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.persistence.Id;

@Service
public class ExternalAPIService {

    private final RestTemplate restTemplate;
    
    String url = "https://speakerscanada.com/json-api/?auth-key=sbcprivatekey&action=get-data&speaker-id=";

    public ExternalAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getExternalTopicsData() {
        ResponseEntity<String> response = restTemplate.getForEntity("https://speakerscanada.com/json-api/?auth-key=sbcprivatekey&action=topics", String.class);
        return response.getBody();
    }
    
    public String getSpeakerData() {
    	ResponseEntity<String> response = restTemplate.getForEntity("https://speakerscanada.com/json-api/?auth-key=sbcprivatekey&action=speakers", String.class);
    	return response.getBody();
    }
    
    public String getSpeakerTypeData() {
    	ResponseEntity<String> respnse = restTemplate.getForEntity("https://speakerscanada.com/json-api/?auth-key=sbcprivatekey&action=types", String.class);
    	return respnse.getBody();
    }
    
    public String getSingleSpeakerData(String id) {
    	ResponseEntity<String> response = restTemplate.getForEntity(url+id, String.class);
    	return response.getBody();
    }
    
}
