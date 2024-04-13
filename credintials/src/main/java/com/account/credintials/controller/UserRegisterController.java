package com.account.credintials.controller;

import com.account.credintials.entity.User;
import com.account.credintials.service.UserServices;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserRegisterController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/welcome")
    public String welcom(Model model) {
        model.addAttribute("wel", "hi every one");
        return "welcome";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login", new User());
        return "index";
    }

    @PostMapping("/login")
    public String loginControl(User user, Model model) {

        User status = userServices.getUser(user.getEmail(), user.getPassword());

        if (status != null) {
            model.addAttribute("msg2", "welcome" + status.getName() + "!");
            return "dashboard";
        } else {
            model.addAttribute("msg", "unsuccessfull");
            return "index";
        }

    }


    @GetMapping("/saveUser")
    public  String loadForm(Model model)
    {
        model.addAttribute("user",new User());
        return "registerView";
    }


    @PostMapping("/saveUser")
    public String userSave(User user, Model model) throws MessagingException {
        boolean status = userServices.saveUser(user);
        if (status) {
            model.addAttribute("msg1", "successfull");
        } else {
            model.addAttribute("msg1", "unsuccessfull");
        }

       return "registerView";

    }
    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("login", new User());
        return "index";
    }
}
