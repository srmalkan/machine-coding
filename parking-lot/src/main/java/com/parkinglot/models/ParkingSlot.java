package com.parkinglot.models;

import com.parkinglot.constants.VehicleType;

public class ParkingSlot {
    int number;
    ParkingFloor parkingFloor;
    VehicleType vehicleType;
    boolean isOccupied;

    public ParkingSlot(int number, ParkingFloor parkingFloor, VehicleType vehicleType) {
        this.number = number;
        this.parkingFloor = parkingFloor;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
