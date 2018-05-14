package com.android.example.mimercado;

import java.util.Date;

public class Product {

    private String name;
    private String category;
    private String maker;
    private long weight;
    private long price;
    private String image;

    public Product (){

    }

    public Product(String name, String category, String maker, long weight, long price, String image) {
        this.name = name;
        this.category = category;
        this.maker = maker;
        this.weight = weight;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
