package com.auca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "propertiessss")
public class Property {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private double price;
    
    private String location;
    
    private int bedrooms;
    
    private int bathrooms;
    
    // Constructors
    
    public Property() {
        // Default constructor
    }
    
    public Property(String name, double price, String location, int bedrooms, int bathrooms) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
    }
    
    // Getters and Setters
    
    public Long getId() {
        return id;
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
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public int getBedrooms() {
        return bedrooms;
    }
    
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }
    
    public int getBathrooms() {
        return bathrooms;
    }
    
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }
}
