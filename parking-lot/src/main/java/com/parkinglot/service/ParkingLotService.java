package com.parkinglot.service;

import com.parkinglot.constants.VehicleType;
import com.parkinglot.dal.ParkingFloorRepository;
import com.parkinglot.dal.ParkingLotRepository;
import com.parkinglot.dal.ParkingSlotRepository;
import com.parkinglot.dal.TicketRepository;
import com.parkinglot.dto.CountPerFloor;
import com.parkinglot.dto.SlotsCSVPerFloor;
import com.parkinglot.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingLotService {
    static ParkingLotService parkingLotService;
    ParkingLotRepository parkingLotRepository;
    ParkingFloorRepository parkingFloorRepository;
    ParkingSlotRepository parkingSlotRepository;
    TicketRepository ticketRepository;
    String parkingLotNumber;

    public static ParkingLotService getParkingLotServiceInstance(){
        if(Objects.isNull(parkingLotService)){
            parkingLotService = new ParkingLotService();
        }
        return parkingLotService;
    }

    private ParkingLotService(){
        parkingLotRepository = ParkingLotRepository.getParkingLotReportingInstance();
        parkingFloorRepository = ParkingFloorRepository.getParkingFloorRepositoryInstance();
        parkingSlotRepository = ParkingSlotRepository.getParkingSlotRepositoryInstance();
        ticketRepository = TicketRepository.getTicketRepositoryInstance();
    }

    public void createParkingLot(String parkingLotNumber, int numberOfParkingFloors, int numberOfParkingSlotsPerFloors){
        ParkingLot parkingLot = new ParkingLot(parkingLotNumber, numberOfParkingFloors, numberOfParkingSlotsPerFloors, new ArrayList<>());
        for (int i=1; i<=numberOfParkingFloors; i++){
            ParkingFloor parkingFloor = new ParkingFloor(i, parkingLot, new ArrayList<>());
            for (int j=1; j<=numberOfParkingSlotsPerFloors; j++){
                ParkingSlot parkingSlot = null;
                if(j==1){
                    parkingSlot = new ParkingSlot(j, parkingFloor, VehicleType.TRUCK);
                }else if(j==2 || j==3){
                    parkingSlot = new ParkingSlot(j, parkingFloor, VehicleType.BIKE);
                }else{
                    parkingSlot = new ParkingSlot(j, parkingFloor, VehicleType.CAR);
                }
                parkingSlotRepository.save(parkingSlot);
                parkingFloor.getParkingSlots().add(parkingSlot);
            }
            parkingFloorRepository.save(parkingFloor);
            parkingLot.getParkingFloors().add(parkingFloor);
        }
        this.parkingLotNumber = parkingLotNumber;
        parkingLotRepository.save(parkingLot);
    }

    public String parkVehicle(String vehicleNumber, VehicleType vehicleType, String color){
        Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType, color);
        ParkingSlot parkingSlot = findNextFreeSlot(vehicleType);
        if(Objects.isNull(parkingSlot)){
            return null;
        }
        parkingSlot.setOccupied(true);
        String ticketNumber = String.format("%s_%s_%s", parkingLotNumber, parkingSlot.getParkingFloor().getNumber(), parkingSlot.getNumber());
        Ticket ticket = new Ticket(ticketNumber, parkingSlot, vehicle);
        ticketRepository.save(ticket);
        return ticketNumber;
    }

    public Vehicle unparkVehicle(String ticketNumber){
        if(!ticketRepository.contains(ticketNumber)){
            return null;
        }
        Ticket ticket = ticketRepository.get(ticketNumber);
        ticket.getParkingSlot().setOccupied(false);
        ticketRepository.remove(ticketNumber);
        return ticket.getVehicle();
    }

    public List<CountPerFloor> displayFreeCount(VehicleType vehicleType){
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotNumber);
        List<CountPerFloor> countPerFloors = new ArrayList<>();

        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            int numberOfSlots = 0;
            for (ParkingSlot ps : parkingFloor.getParkingSlots()) {
                if (!ps.isOccupied() && ps.getVehicleType().equals(vehicleType)) {
                    numberOfSlots++;
                }
            }
            CountPerFloor countPerFloor = new CountPerFloor(parkingFloor.getNumber(), numberOfSlots);
            countPerFloors.add(countPerFloor);
        }
        return countPerFloors;
    }

    public List<SlotsCSVPerFloor> displayFreeSlots(VehicleType vehicleType){
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotNumber);
        List<SlotsCSVPerFloor> slotsCSVPerFloorList = new ArrayList<>();

        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            String freeSlotCSV = "";
            for (ParkingSlot ps : parkingFloor.getParkingSlots()) {
                if (!ps.isOccupied() && ps.getVehicleType().equals(vehicleType)) {
                    freeSlotCSV += "," + ps.getNumber();
                }
            }
            SlotsCSVPerFloor slotsCSVPerFloor = new SlotsCSVPerFloor(parkingFloor.getNumber(), freeSlotCSV);
            slotsCSVPerFloorList.add(slotsCSVPerFloor);
        }
        return slotsCSVPerFloorList;
    }

    public List<SlotsCSVPerFloor> displayOccupiedSlots(VehicleType vehicleType){
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotNumber);
        List<SlotsCSVPerFloor> slotsCSVPerFloorList = new ArrayList<>();

        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            String freeSlotCSV = "";
            for (ParkingSlot ps : parkingFloor.getParkingSlots()) {
                if (ps.isOccupied() && ps.getVehicleType().equals(vehicleType)) {
                    freeSlotCSV += "," + ps.getNumber();
                }
            }
            SlotsCSVPerFloor slotsCSVPerFloor = new SlotsCSVPerFloor(parkingFloor.getNumber(), freeSlotCSV);
            slotsCSVPerFloorList.add(slotsCSVPerFloor);
        }
        return slotsCSVPerFloorList;
    }

    private ParkingSlot findNextFreeSlot(VehicleType vehicleType){
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotNumber);
        ParkingSlot parkingSlot = null;

        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for (ParkingSlot ps : parkingFloor.getParkingSlots()) {
                if (!ps.isOccupied() && ps.getVehicleType().equals(vehicleType)) {
                    parkingSlot = ps;
                    break;
                }
            }
            if(parkingSlot!=null){
                break;
            }
        }

        return parkingSlot;
    }

}
