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
import brave.Tracer.SpanInScope;
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
		List<Customer> customerList;
    	LOGGER.info("CustomerController#findAll");
    	brave.Span span = tracer.nextSpan().name("findallspan");
    	try (SpanInScope ws = tracer.withSpanInScope(span.start())) {
		LOGGER.info("Calling to get message");
		String addrmsg = restTemplate.getForObject("/test-doc1/address", String.class);
      customerList = new ArrayList<Customer>(); 
      customerList.add(new Customer(1, "frank",addrmsg));
      customerList.add(new Customer(2, "john",addrmsg));
      LOGGER.info("Done to get message");
    	} finally {
    		  span.finish();
    		}
      return customerList;
    }
}
