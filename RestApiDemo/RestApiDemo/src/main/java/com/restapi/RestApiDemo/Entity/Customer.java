package com.restapi.RestApiDemo.Entity;

import jakarta.persistence.*;

@Entity @Table(name = "customer__tbl")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private  String name;
    private  Long phon;
    public Customer()
    {

    }

    public Customer(Integer id, String name, Long phon) {
        this.id = id;
        this.name = name;
        this.phon = phon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhon() {
        return phon;
    }

    public void setPhon(Long phon) {
        this.phon = phon;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phon=" + phon +
                '}';
    }
}
