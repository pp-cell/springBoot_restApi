package com.irct.Booking.service;

import com.irct.Booking.model.Passenger;
import com.irct.Booking.model.Ticket;
import com.irct.Booking.repo.TicketRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
     @Autowired
    private TicketRepo repo;
   @Override
    public Ticket bookTicket(Passenger passenger)
    {
        Ticket t=new Ticket();
        BeanUtils.copyProperties(passenger,t);
        t.setTicketStatus("Confirmed");
        Ticket status=repo.save(t);
        return status;
    }
    @Override
    public Ticket getTicket(Integer tid)
    {
         return repo.findById(tid).orElseThrow();
    }
    @Override
    public List<Ticket> getAll()
    {
        return repo.findAll();
    }
}
