package com.restapi.RestApiDemo.service;

import com.restapi.RestApiDemo.Entity.Customer;
import com.restapi.RestApiDemo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class CustomerService {
  @Autowired
   private CustomerRepo customerRepo;
    public void save(Customer customer)
    {
        customerRepo.save(customer);

    }
    public Customer getFind(Integer id)
    {

        return customerRepo.findById(id).get();
    }
    public List<Customer> getAll()
    {
        return customerRepo.findAll();
    }
    public void getDelete(Integer id)
    {
        customerRepo.deleteById(id);
    }

}
