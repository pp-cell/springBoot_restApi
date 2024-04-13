package com.irct.Booking.service;

import com.irct.Booking.model.Passenger;
import com.irct.Booking.model.Ticket;

import java.util.List;

public interface TicketService {
    public Ticket bookTicket(Passenger passenger);
    public Ticket getTicket(Integer tid);
    public List<Ticket> getAll();

}
