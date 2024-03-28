package com.parkinglot;

import com.parkinglot.commands.CLICommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParkingLotApp {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String exitCommand = "exit";
        List<String> consolidatedOutput = new ArrayList<>();
        consolidatedOutput.add("------------------------------------------------------");
        while(scanner.hasNextLine()){
            String newCommand = scanner.nextLine();
            if(newCommand.equals(exitCommand)){
                break;
            }
            List<String> commandAndArgs = Arrays.asList(newCommand.split(" "));
            String output = CLICommand.getCLICommandHandler(commandAndArgs.get(0)).process(commandAndArgs);
            consolidatedOutput.add(output);
        }
        for(String output : consolidatedOutput){
            System.out.println(output);
        }
    }
}
