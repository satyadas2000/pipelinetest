package com.test_doc;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import brave.Span;
import brave.Tracer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
 
@RestController
@RequestMapping("/test-doc1")
public class AddController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AddController.class);
   
	

	
	@RequestMapping("/address")
    public String getAdd()
    {
    	LOGGER.info("AddController#getAdd");
    	
      return "dubai";
    }
}
