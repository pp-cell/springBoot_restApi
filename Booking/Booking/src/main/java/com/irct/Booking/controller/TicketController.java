package com.irct.Booking.controller;

import com.irct.Booking.model.Passenger;
import com.irct.Booking.model.Ticket;
import com.irct.Booking.service.TicketService;
import com.irct.Booking.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
  @Autowired
    private TicketService ticketService;
  @PostMapping(value = "/book" ,consumes = "application/json",produces = "application/json")
  public ResponseEntity<Ticket> book(@RequestBody Passenger passenger)
    {
        Ticket t1=ticketService.bookTicket(passenger);
        return new ResponseEntity<>(t1,HttpStatus.CREATED);
    }
   @GetMapping(value = "/ticket/{tid}",produces = "application/json")
    public ResponseEntity<Ticket> getTicket(@PathVariable Integer tid)
    {
        Ticket t2=ticketService.getTicket(tid);
        return new ResponseEntity<>(t2,HttpStatus.OK);
    }
    @GetMapping(value = "/tickets",produces = "application/json")
    public ResponseEntity<List<Ticket>> getAllTickets()
    {
       List<Ticket> tl= ticketService.getAll();
       return new ResponseEntity<>(tl,HttpStatus.OK);
    }
}
