package com.parkinglot.dal;

import com.parkinglot.models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingFloorRepository {
    static ParkingFloorRepository parkingFloorRepository;
    Map<Integer, ParkingFloor> parkingFloors;

    public static ParkingFloorRepository getParkingFloorRepositoryInstance(){
        if(Objects.isNull(parkingFloorRepository)){
            parkingFloorRepository = new ParkingFloorRepository();
        }
        return parkingFloorRepository;
    }

    private ParkingFloorRepository() {
        parkingFloors = new HashMap<>();
    }

    public void save(ParkingFloor parkingFloor){
        parkingFloors.put(parkingFloor.getNumber(), parkingFloor);
    }

    public ParkingFloor get(int number){
        return parkingFloors.get(number);
    }
}
