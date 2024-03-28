package com.parkinglot.commands;

import com.parkinglot.constants.VehicleType;
import com.parkinglot.dto.CountPerFloor;
import com.parkinglot.dto.SlotsCSVPerFloor;
import com.parkinglot.service.ParkingLotService;

import java.util.List;

public class DisplayCommand implements CLICommand{
    @Override
    public String process(List<String> Args) {
        String subCommand = Args.get(1);
        VehicleType vehicleType = VehicleType.valueOf(Args.get(2));
        String result = "";
        switch (subCommand){
            case "free_count" :
                List<CountPerFloor> countPerFloors = ParkingLotService.getParkingLotServiceInstance().displayFreeCount(vehicleType);
                for(CountPerFloor countPerFloor : countPerFloors){
                    result += String.format("No. of free slots for %s on Floor %s: %s\n", vehicleType, countPerFloor.getFloorNumber(), countPerFloor.getNumberOfFreeSlots());
                }
                break;
            case "free_slots" :
                List<SlotsCSVPerFloor> slotsCSVPerFloors = ParkingLotService.getParkingLotServiceInstance().displayFreeSlots(vehicleType);
                for(SlotsCSVPerFloor slotsCSVPerFloor : slotsCSVPerFloors){
                    result += String.format("Free slots for %s on Floor %s: %s\n", vehicleType, slotsCSVPerFloor.getFloorNumber(), slotsCSVPerFloor.getFreeSlots());
                }
                break;
            case "occupied_slots" :
                List<SlotsCSVPerFloor> occupiedSlots = ParkingLotService.getParkingLotServiceInstance().displayOccupiedSlots(vehicleType);
                for(SlotsCSVPerFloor slotsCSVPerFloor : occupiedSlots){
                    result += String.format("Occupied slots for %s on Floor %s: %s\n", vehicleType, slotsCSVPerFloor.getFloorNumber(), slotsCSVPerFloor.getFreeSlots());
                }
                break;
        }
        return result;
    }
}
