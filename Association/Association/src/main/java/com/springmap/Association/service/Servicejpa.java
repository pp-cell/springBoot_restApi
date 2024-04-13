package com.springmap.Association.service;

import com.springmap.Association.model.Customer;
import com.springmap.Association.model.Product;
import com.springmap.Association.repo.CustomerRepo;
import com.springmap.Association.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class Servicejpa {
   @Autowired
    private CustomerRepo customerRepo;
   @Autowired
    private ProductRepo productRepo;
   public void save()
   {
       Customer customer=new Customer();
       customer.setCname("pavan");
       customer.setPhon(781395422L);


       Product product=new Product();

       product.setPname("iqoo");
       product.setPrice(5577.00);

       Product product1=new Product();

       product1.setPname("mi");
       product1.setPrice(2577.00);

       customer.setProducts(Arrays.asList(product,product1));

       product.setCustomer(Arrays.asList(customer));
       product1.setCustomer(Arrays.asList(customer));

       customerRepo.save(customer);
       productRepo.saveAll(Arrays.asList(product,product1));

   }

}
