package com.example.appartmentsapplication;

public class Apartment {
    private double surfaceArea;
    private double monthlyRent;
    private Cities city;

    public Apartment(double surfaceArea, double monthlyRent, Cities city) {
        this.surfaceArea = surfaceArea;
        this.monthlyRent = monthlyRent;
        this.city = city;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public Cities getCity() {
        return city;
    }
}
