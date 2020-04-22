package com.test_doc;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
 
@RestController
@RequestMapping("/test-doc")
public class CustomerController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
   
	@Autowired
	private Tracer tracer;
	@Autowired
	private RestTemplate restTemplate;

	
	
	@RequestMapping("/customers")
    public List<Customer> findAll()
    {
    	LOGGER.info("CustomerController#findAll");
    	Span getBarSpan = tracer.createSpan("findall-span");
		LOGGER.info("Calling to get message");
		String addrmsg = restTemplate.getForObject("http://localhost:8081/test-doc1/address", String.class);
      List<Customer> customerList = new ArrayList<Customer>();
      customerList.add(new Customer(1, "frank",addrmsg));
      customerList.add(new Customer(2, "john",addrmsg));
      LOGGER.info("Done to get message");
      tracer.close(getBarSpan);
      return customerList;
    }
}
