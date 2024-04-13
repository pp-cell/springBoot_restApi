package com.error.exception.controller;

import com.error.exception.entity.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller

public class ExceptionController {
    @GetMapping("/welcome/{id}")

    public String welcome(@PathVariable Integer id, Model model) throws Exception {
        if (id >= 100) {
            throw new productError("invalid entry");
        } else
        {
            model.addAttribute("msg", "wlecome buddy");
    }
        return "welcome";

    }
   @GetMapping("/hello")
   @ResponseBody
    public String hello()
    {


        return "hello";
    }
   @GetMapping("/")
    public String loadForm(Model model)
    {
        model.addAttribute("user",new User());
        return "form";
    }
   @PostMapping("/form")
    public String form(@Valid User user, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            return "form";
        }
        else {
            System.out.println(user);
            model.addAttribute("msg", "form valid");
            return "form";
        }
    }


}
