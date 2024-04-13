package com.restapi.RestApiDemo.Controller;

import com.restapi.RestApiDemo.Entity.Customer;
import com.restapi.RestApiDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerApi {
    @Autowired
    private CustomerService cus;
    @PostMapping(value = "/send",consumes = "application/json",produces = "text/plain")
    public ResponseEntity<String> getReceive(@RequestBody Customer customer)
    {
        cus.save(customer);
        return new ResponseEntity<>("successfully saved", HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/delete/{id}",produces = "text/plain")
    public ResponseEntity<String> getDel(@PathVariable("id") Integer id)
    {
           cus.getDelete(id);
          return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }
    @PutMapping(value = "/update",consumes = "application/json",produces = "text/plain")
    public ResponseEntity<String> getUpdate(@RequestBody Customer customer)
    {
        cus.save(customer);
        return new ResponseEntity<>("successfully updated",HttpStatus.OK);
    }
    @GetMapping(value = "/data/{id}",produces = "application/json")
    public ResponseEntity<Customer> getData(@PathVariable("id") Integer id)
    {
        Customer customer=cus.getFind(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }


}
