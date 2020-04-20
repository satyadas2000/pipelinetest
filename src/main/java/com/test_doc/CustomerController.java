package com.test_doc;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
 
@RestController
@RequestMapping("/test-doc")
public class CustomerController
{
    @RequestMapping("/customers")
    public List<Customer> findAll()
    {
      List<Customer> customerList = new ArrayList<Customer>();
      customerList.add(new Customer(1, "frank"));
      customerList.add(new Customer(2, "john"));
      return customerList;
    }
}
