package com.parkinglot.commands;

import com.parkinglot.service.ParkingLotService;

import java.util.List;

public class CreateParkingLotCommand implements CLICommand{
    @Override
    public String process(List<String> Args) {
        String parkingLotNumber = Args.get(1);
        String numberOfFloors = Args.get(2);
        String numberOfSlotPerFloor = Args.get(3);
        ParkingLotService.getParkingLotServiceInstance().createParkingLot(parkingLotNumber,Integer.parseInt(numberOfFloors), Integer.parseInt(numberOfSlotPerFloor));
        return String.format("Created parking lot with %s floors and %s slots per floor", numberOfFloors, numberOfSlotPerFloor);
    }
}
