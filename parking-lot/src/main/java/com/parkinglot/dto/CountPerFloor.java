package com.parkinglot.dto;

import com.parkinglot.constants.VehicleType;

public class CountPerFloor {
    int floorNumber;
    int numberOfFreeSlots;

    public CountPerFloor(int floorNumber, int numberOfFreeSlots) {
        this.floorNumber = floorNumber;
        this.numberOfFreeSlots = numberOfFreeSlots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int numberOfFloors) {
        this.floorNumber = numberOfFloors;
    }

    public int getNumberOfFreeSlots() {
        return numberOfFreeSlots;
    }

    public void setNumberOfFreeSlots(int numberOfFreeSlots) {
        this.numberOfFreeSlots = numberOfFreeSlots;
    }
}
