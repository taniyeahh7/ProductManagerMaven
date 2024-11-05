package com.qa.nal;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService {
    // right now storing all the items in a list
    // in actuality should be stored in a db

    List<Product> products = new ArrayList<>();
    // ProductDB db = new ProductDB();

    public void addProduct(Product p){
        products.add(p); // have to pass the object
        // db.save(p); // adds that product to the db directly
    }

    public List<Product> getAllProduct(){
        return products;
    }

    public Product getProduct(String name){
        for(Product prod : products){
            if(prod.getName().equals(name)){ // cuz is a string
                return prod;
            }
        }

        return null; // not a good way to handle it, can return an empty object
    }

    public Product getPlace(String place){
        for(Product prod : products){
            if(prod.getPlace().equals(place)){
                return prod;
            }
        }

        return null;
    }

    public List<Product> getProductOutOfWarranty(){
        List<Product> prod = new ArrayList<>();

        for(Product p : products){
            if(p.getWarranty() < 2024){
                prod.add(p);
            }
        }

        return prod;
    }

    public List<Product> getProductWithText(String text){
        // method using substring
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : products){
            // text in name, place, type
            String name =  p.getName().toLowerCase();
            String place = p.getPlace().toLowerCase();
            String type = p.getType().toLowerCase();
            if(place.contains(str) || name.contains(str) || type.contains(str)){ // String has the contains function
                prods.add(p);
            }
        }
        return prods;
    }

    // get product with text using the stream API
    // public List<Product> getProductWithText(String text){
    //     String str = text.toLowerCase();

    //     return products.stream()
    //            .filter(p -> p.getName().contains(str) || p.getType().contains(str) || p.getType().contains(str))
    //            .collect(Collectors.toList());
    // }
}
