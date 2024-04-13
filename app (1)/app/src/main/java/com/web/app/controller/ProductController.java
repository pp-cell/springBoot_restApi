package com.web.app.controller;

import com.web.app.entity.Product;
import com.web.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ProductController {
   @Autowired
    private ProductService productService;
   @GetMapping("/")
   public ModelAndView loadForm()
   {
       ModelAndView m=new ModelAndView();
       m.addObject("pojo",new Product());
       m.setViewName("index");
       return m;
   }
 @PostMapping("/saveProducts")
   public ModelAndView savePro(Product pojo)
   {
       ModelAndView mode=new ModelAndView();
     boolean status=  productService.save(pojo);
     if(status)
     {
         mode.addObject("msg","successfull");
     }
     else {
         mode.addObject("msg1","not saved");
     }
     mode.addObject("pojo",new Product());
     mode.setViewName("index");
     return mode;
   }
   @GetMapping("/products")
   public ModelAndView getPro()
   {
       List<Product> productList=productService.getProducts();
       ModelAndView mov=new ModelAndView();
       mov.addObject("plist",productList);
       mov.setViewName("load");
       return mov;
   }
 @GetMapping("/delete/{id}")
   public ModelAndView proDel(@PathVariable Integer id)
   {
       ModelAndView m2=new ModelAndView();
       boolean b=productService.getDel(id);
       if(b)
       {
           m2.addObject("delete","success full delete");
       }
       else {
           m2.addObject("delete", "unsuccessfull delete");
       }
       m2.setViewName("load");
       return m2;
   }
   @GetMapping("/update/{id}")
   public ModelAndView edit(@PathVariable Integer id)
   {
       ModelAndView mv=new ModelAndView();
     Product product=  productService.getProductById(id);
     mv.addObject("prod",product);
     mv.setViewName("edit");


return mv;
   }
    @PostMapping("/update")
    public ModelAndView edit(Product prod)
    {
        ModelAndView my=new ModelAndView();
        boolean status=  productService.save(prod);
        if(status)
        {
            my.addObject("sg","successfull");
        }
        else {
            my.addObject("sg","not saved");
        }
        my.addObject("pojo",new Product());
        my.setViewName("index");
        return my;
    }


}
