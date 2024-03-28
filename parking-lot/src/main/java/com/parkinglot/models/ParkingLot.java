package com.parkinglot.models;

import java.util.List;

public class ParkingLot {
    String number;
    int numberOfParkingFloors;
    int numberOfParkingSlotsPerFloors;
    List<ParkingFloor> parkingFloors;

    public ParkingLot(String number, int numberOfParkingFloors, int numberOfParkingSlotsPerFloors, List<ParkingFloor> parkingFloors) {
        this.number = number;
        this.numberOfParkingFloors = numberOfParkingFloors;
        this.numberOfParkingSlotsPerFloors = numberOfParkingSlotsPerFloors;
        this.parkingFloors = parkingFloors;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public int getNumberOfParkingFloors() {
        return numberOfParkingFloors;
    }

    public void setNumberOfParkingFloors(int numberOfParkingFloors) {
        this.numberOfParkingFloors = numberOfParkingFloors;
    }

    public int getNumberOfParkingSlotsPerFloors() {
        return numberOfParkingSlotsPerFloors;
    }

    public void setNumberOfParkingSlotsPerFloors(int numberOfParkingSlotsPerFloors) {
        this.numberOfParkingSlotsPerFloors = numberOfParkingSlotsPerFloors;
    }
}
