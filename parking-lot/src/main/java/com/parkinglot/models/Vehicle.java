package com.parkinglot.models;

import com.parkinglot.constants.VehicleType;

public class Vehicle {
    String number;
    VehicleType type;
    String color;

    public Vehicle(String number, VehicleType type, String color){
        this.number = number;
        this.type = type;
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
