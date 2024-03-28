package com.parkinglot.dto;

public class SlotsCSVPerFloor {
    int floorNumber;
    String freeSlots;

    public SlotsCSVPerFloor(int floorNumber, String freeSlots) {
        this.floorNumber = floorNumber;
        this.freeSlots = freeSlots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int numberOfFloors) {
        this.floorNumber = numberOfFloors;
    }

    public String getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(String freeSlots) {
        this.freeSlots = freeSlots;
    }
}
