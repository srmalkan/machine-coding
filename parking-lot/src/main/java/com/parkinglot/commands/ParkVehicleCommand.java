package com.parkinglot.commands;

import com.parkinglot.constants.VehicleType;
import com.parkinglot.service.ParkingLotService;

import java.util.List;
import java.util.Objects;

public class ParkVehicleCommand implements CLICommand{
    @Override
    public String process(List<String> Args) {
        String vehicleNumber = Args.get(2);
        String vehicleColor = Args.get(3);
        VehicleType vehicleType = VehicleType.valueOf(Args.get(1));
        String ticketNumber = ParkingLotService.getParkingLotServiceInstance().parkVehicle(vehicleNumber, vehicleType, vehicleColor);
        if(Objects.isNull(ticketNumber)){
            return "Parking Lot Full";
        }
        return String.format("Parked vehicle. Ticket ID: %s", ticketNumber);
    }
}
