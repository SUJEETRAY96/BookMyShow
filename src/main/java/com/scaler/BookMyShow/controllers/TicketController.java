package com.scaler.BookMyShow.controllers;

import com.scaler.BookMyShow.dtos.BookTicketRequestDTO;
import com.scaler.BookMyShow.dtos.BookTicketResponseDTO;
import com.scaler.BookMyShow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    BookTicketResponseDTO bookTicket(BookTicketRequestDTO request){

        return null;
    }
}
