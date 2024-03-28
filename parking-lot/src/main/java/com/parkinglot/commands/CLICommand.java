package com.parkinglot.commands;

import java.util.List;

public interface CLICommand {
    public static CLICommand getCLICommandHandler(String cmd){
        CLICommand cliCommand = null;
        switch (cmd){
            case "create_parking_lot" : cliCommand = new CreateParkingLotCommand(); break;
            case "park_vehicle" : cliCommand = new ParkVehicleCommand(); break;
            case "unpark_vehicle" : cliCommand = new UnparkVehicleCommand(); break;
            case "display" : cliCommand = new DisplayCommand(); break;
        }
        return cliCommand;
    }
    public String process(List<String> Args);
}
