package com.springmap.Association.model;

import jakarta.persistence.*;

import java.util.List;

@Entity @Table(name = "customer")
public class Customer {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Cid;
    private   String Cname;
    private   Long phon;
  @ManyToMany(cascade =CascadeType.ALL)
  @JoinTable(name = "Customer_Product",joinColumns = @JoinColumn(name = "Cid"),
          inverseJoinColumns = @JoinColumn(name = "pid"))
   private List<Product>  products;

    public Integer getCid() {
        return Cid;
    }

    public void setCid(Integer cid) {
        Cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public Long getPhon() {
        return phon;
    }

    public void setPhon(Long phon) {
        this.phon = phon;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Cid=" + Cid +
                ", Cname='" + Cname + '\'' +
                ", phon=" + phon +
                ", products=" + products +
                '}';
    }
}
