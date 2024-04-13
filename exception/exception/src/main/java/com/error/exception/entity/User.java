package com.error.exception.entity;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {
   @NotEmpty(message = "name Mandatory")
   @Size(min = 3,max = 8,message = "minimum 3 and maximum 8")
    private String name;
   @NotEmpty(message = "enter the email")
   @Email(message = "enter the valid email")
    private String email;
   @NotNull(message = "enter number mandatory")
    private Long phno;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhno() {
        return phno;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phno=" + phno +
                '}';
    }
}
