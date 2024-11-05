package com.qa.nal;

public class Product {
    private String name; // encapsulation
    // all properties should be private
    // and only way to access em is getters and setters
    private String type;
    private String place;
    private int warranty;

    // two constructors for two cases
    public Product(){
    }


    public Product(String name, String type, String place, int warranty){
        this.name = name;
        this.type = type;
        this.place = place;
        this.warranty = warranty;
    }

    // only way to access the properties out of the class
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getPlace(){
        return place;
    }

    public void setPlace(String place){
        this.place = place;
    }

    public int getWarranty(){
        return warranty;
    }

    public void setWarranty(int warranty){
        this.warranty = warranty;
    }

    // if want to print object and the values of it 
    // use a to String method
    //@Override
    public String toString(){
        return "Product{" +
                "name = " + name + "\"" +
                ", type = " + type + "\"" +
                ", place = " + place + "\"" +
                ", warranty = " + warranty +
                "}";
    }
}

// console based application
// later connect with database
// convert it into database
// create a server to it
// shifting normal application to web application