package com.parkinglot.dal;

import com.parkinglot.models.ParkingLot;
import com.parkinglot.models.ParkingSlot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingSlotRepository {
    static ParkingSlotRepository parkingSlotRepository;
    Map<Integer, ParkingSlot> parkingSlots;

    public static ParkingSlotRepository getParkingSlotRepositoryInstance(){
        if(Objects.isNull(parkingSlotRepository)){
            parkingSlotRepository = new ParkingSlotRepository();
        }
        return parkingSlotRepository;
    }

    private ParkingSlotRepository() {
        parkingSlots = new HashMap<>();
    }

    public void save(ParkingSlot parkingSlot){
        parkingSlots.put(parkingSlot.getNumber(), parkingSlot);
    }

    public ParkingSlot get(int number){
        return parkingSlots.get(number);
    }
}
