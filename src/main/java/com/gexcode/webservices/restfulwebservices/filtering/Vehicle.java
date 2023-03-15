package com.gexcode.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("excludeColor")
public class Vehicle {

    private String color;
    private String brand;
    private int yearOfRelease;

    public Vehicle(String color, String brand, int yearOfRelease) {
        this.color = color;
        this.brand = brand;
        this.yearOfRelease = yearOfRelease;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
