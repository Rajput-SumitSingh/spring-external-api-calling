package com.spoil3rrr.Controll3r;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spoil3rrr.Entity.Topics;
import com.spoil3rrr.Service.ExternalAPIService;
import com.spoil3rrr.Service.TopicService;

@RestController
public class SpeakerControll3r {
	
	private ExternalAPIService externalAPIService ;
	
	public SpeakerControll3r(ExternalAPIService externalAPIService) {
        this.externalAPIService = externalAPIService;
    }

    @GetMapping("/json-api/topics")
    public String getExternalData() {
        return externalAPIService.getExternalTopicsData();
    }
	
    @GetMapping("/json-api/speakers")
    public String getSpeakerData() {
    	return externalAPIService.getSpeakerData();
    }
    
    @GetMapping("json-api/types")
    public String getSpeakerTypeData() {
    	return externalAPIService.getSpeakerTypeData();
    }
    
    @GetMapping("json-api/speaker-id={id}")
    public String getSingleSpeakerData(@PathVariable String id) {
    	return externalAPIService.getSingleSpeakerData(id);
    }
    
    
}
