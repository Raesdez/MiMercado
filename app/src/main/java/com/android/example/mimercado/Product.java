package com.android.example.mimercado;

import android.os.Parcel;
import android.os.Parcelable;


public class Product implements Parcelable {

    private int name;
    private int category;
    private String maker;
    private double weight;
    private double price;
    private int image;


    //Todo Comment this later
    private Product(Parcel in) {

        name = in.readInt();
        category = in.readInt();
        image = in.readInt();
        weight = in.readDouble();
        price = in.readDouble();
        maker = in.readString();
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


//####################################################################################

    //TODO Comment this code later
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(name);
        dest.writeInt(category);
        dest.writeInt(image);
        dest.writeString(maker);
        dest.writeDouble(weight);
        dest.writeDouble(price);
    }

    public static final Parcelable.Creator<Product> CREATOR
            = new Parcelable.Creator<Product>() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public Product[] newArray(int size) {
        return new Product[size];
    }
}

