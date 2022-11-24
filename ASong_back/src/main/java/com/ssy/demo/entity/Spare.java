package com.ssy.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "spare", schema = "ssy")
public class Spare {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "price")
    private Double price;

    @Basic
    @Column(name = "type")
    private String type;


    @Basic
    @Column(name = "brand")
    private String brand;

    @Basic
    @Column(name = "introduce")
    private String introduce;

    public Integer getId() {
        return Id;
    }


    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }


}
