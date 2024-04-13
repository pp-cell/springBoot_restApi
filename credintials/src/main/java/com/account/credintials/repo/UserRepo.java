package com.account.credintials.repo;

import com.account.credintials.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
     User findByEmailAndPassword(String email,String password);
}
