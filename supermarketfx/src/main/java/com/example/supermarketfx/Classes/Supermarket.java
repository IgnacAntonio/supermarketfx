package com.example.supermarketfx.Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Supermarket {
    private LinkedList<Product> products = new LinkedList<>();

    public Supermarket() {
    }

    public boolean addProduct(Product product) {
        boolean productAdded = false;
        if (product != null && !products.contains(product)) {
            products.add(product);
            productAdded = true;
        }
        return productAdded;
    }

    public boolean removeProduct(Product product) {
        return product != null && product.getQuantity() <= 0 && products.remove(product);
    }

    public boolean buyProduct(Product product, int quantity) {
        boolean productSold = false;
        for (Product p : products) {
            if (p.equals(product) && p.getQuantity() < quantity) {
                quantity = p.getQuantity();
            }
            p.setQuantity(p.getQuantity() - quantity);
            if (p.getQuantity() <= 0) {
                removeProduct(p);
            }
            productSold = true;
        }
        return productSold;
    }

    public boolean checkIfBarcodeIsUnique(int barcode) {
        boolean barcodeIsUnique = true;
        for (Product product : products) {
            if (product.getBarcode() == barcode) {
                barcodeIsUnique = false;
            }
        }
        return barcodeIsUnique;
    }

    public Product getProduct(Product product) {
        for (Product p : products) {
            if (p.equals(product)) {
                return p;
            }
        }
        return null;
    }

    public boolean availableProduct(Product product) {
        return products.contains(product);
    }

    public void getAllergenFreeProducts() {
        for (Product p : products) {
            if (p.getClass() == FoodProduct.class) {
                if (((FoodProduct) p).getAllergens().isEmpty()) {
                    System.out.println(p.toString());
                }
            }
        }
    }

    public void getAllProductsFromDataBase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM products";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            int quantity = resultSet.getInt("quantity");
            int barcode = resultSet.getInt("barcode");
            Product product = new Product(name, price, quantity, barcode);
            addProduct(product);
        }
    }

    public boolean addProductToDataBase(Connection connection, Product p) {
        boolean productAdded = false;
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO products (name, price, quantity, barcode) VALUES ('" + p.getName() + "', " + p.getPrice() + ", " + p.getQuantity() + ", " + p.getBarcode() + ")";
            statement.executeUpdate(sql);
            productAdded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productAdded;
    }
}
