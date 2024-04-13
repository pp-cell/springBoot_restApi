package com.account.credintials.service;

import com.account.credintials.entity.User;
import com.account.credintials.repo.UserRepo;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EmailServices emailServices;
public boolean saveUser(User user) throws MessagingException {
   User user1= userRepo.save(user);

    if (user1.getId()!=null) {
        String emailContent = "Welcome to our website!";
        emailServices.sendEmail(user1.getEmail(), "Registration confirmation", emailContent);
    }
        return true;

}
public User getUser(String email,String password)
{
    User us=userRepo.findByEmailAndPassword(email,password);
    return us;
}
}
