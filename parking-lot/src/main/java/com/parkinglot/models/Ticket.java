package com.parkinglot.models;

public class Ticket {
    String number;
    ParkingSlot parkingSlot;
    Vehicle vehicle;

    public Ticket(String number, ParkingSlot parkingSlot, Vehicle vehicle) {
        this.number = number;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
