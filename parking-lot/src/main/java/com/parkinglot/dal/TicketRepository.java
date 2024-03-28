package com.parkinglot.dal;

import com.parkinglot.models.ParkingLot;
import com.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TicketRepository {
    static TicketRepository ticketRepository;
    Map<String, Ticket> tickets;

    public static TicketRepository getTicketRepositoryInstance(){
        if(Objects.isNull(ticketRepository)){
            ticketRepository = new TicketRepository();
        }
        return ticketRepository;
    }

    private TicketRepository() {
        tickets = new HashMap<>();
    }

    public void save(Ticket ticket){
        tickets.put(ticket.getNumber(), ticket);
    }

    public Ticket get(String number){
        return tickets.get(number);
    }

    public boolean contains(String number){
        return tickets.containsKey(number);
    }

    public void remove(String number){
        tickets.remove(number);
    }
}
