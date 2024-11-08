package com.qa.nal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public class ProductDB {
    Connection conn = null;

    public ProductDB(){
        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/telusko", "postgres", "0000");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }

    public void save(Product p){
        String query = "insert into product (name, type, place, warranty) values (?, ?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getName());
            st.setString(2, p.getType());
            st.setString(3, p.getPlace());
            st.setInt(4, p.getWarranty());
            st.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll(){
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1)); // the numbers are the column indexes
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                products.add(p);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}
