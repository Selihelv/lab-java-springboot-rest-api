package com.example.labweek5.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class Product {

    @NotBlank (message = "Name cannot be blank" )
    @Length(min = 3, message =  "Min length 3")
    private String name;

    @Positive (message = "Price must be positive")
    private double price;

    @NotBlank (message =  " Category cannot be blank")
    private String category;

    @Positive (message = "Quantity must be positive")
    private int quantity;

    public Product(String name, double price, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
