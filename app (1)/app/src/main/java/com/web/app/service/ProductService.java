package com.web.app.service;

import com.web.app.entity.Product;
import com.web.app.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;
    public boolean save(Product product)
    {
       Product pro= repo.save(product);
       return pro.getId()!=null;
    }
    public List<Product> getProducts()
    {
        List<Product> l=  repo.findAll();
    return l;
    }
   public boolean getDel(Integer id)
    {
         repo.deleteById(id);
        return true;

    }
    public Product getProductById(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
