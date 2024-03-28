package com.parkinglot.models;
import java.util.List;


public class ParkingFloor {
    int number;
    ParkingLot parkingLot;
    List<ParkingSlot> parkingSlots;

    public ParkingFloor(int number, ParkingLot parkingLot, List<ParkingSlot> parkingSlots) {
        this.number = number;
        this.parkingLot = parkingLot;
        this.parkingSlots = parkingSlots;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
