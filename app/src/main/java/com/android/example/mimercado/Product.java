package com.android.example.mimercado;

import java.util.Date;

public class Product {

    private int name;
    private int category;
    private String maker;
    private double weight;
    private double price;
    private int image;

    public Product (){

    }

    public Product(int name, int category, String maker, double weight, double price, int image) {
        this.name = name;
        this.category = category;
        this.maker = maker;
        this.weight = weight;
        this.price = price;
        this.image = image;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
