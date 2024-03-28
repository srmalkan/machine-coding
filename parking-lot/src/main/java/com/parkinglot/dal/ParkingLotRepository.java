package com.parkinglot.dal;

import com.parkinglot.constants.VehicleType;
import com.parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingLotRepository {
    static ParkingLotRepository parkingLotRepository;
    Map<String, ParkingLot> parkingLots;

    public static ParkingLotRepository getParkingLotReportingInstance(){
        if(Objects.isNull(parkingLotRepository)){
            parkingLotRepository = new ParkingLotRepository();
        }
        return parkingLotRepository;
    }

    private ParkingLotRepository() {
        parkingLots = new HashMap<>();
    }

    public void save(ParkingLot parkingLot){
        parkingLots.put(parkingLot.getNumber(), parkingLot);
    }

    public ParkingLot get(String number){
        return parkingLots.get(number);
    }
}
