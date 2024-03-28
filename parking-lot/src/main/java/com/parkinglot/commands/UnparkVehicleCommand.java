package com.parkinglot.commands;

import com.parkinglot.models.Vehicle;
import com.parkinglot.service.ParkingLotService;

import java.util.List;
import java.util.Objects;

public class UnparkVehicleCommand implements CLICommand{
    @Override
    public String process(List<String> Args) {
        String ticketNumber = Args.get(1);
        Vehicle vehicle = ParkingLotService.getParkingLotServiceInstance().unparkVehicle(ticketNumber);
        if(Objects.isNull(vehicle)){
            return "Invalid Ticket";
        }
        return String.format("Unparked vehicle with Registration Number: %s and Color: %s", vehicle.getNumber(), vehicle.getColor());
    }
}
