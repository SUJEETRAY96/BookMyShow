package com.scaler.BookMyShow.services;

import com.scaler.BookMyShow.exception.InvalidArgumentException;
import com.scaler.BookMyShow.exception.SeatNotAvailableException;
import com.scaler.BookMyShow.models.*;
import com.scaler.BookMyShow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private SeatRepository seatRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private UserRepository userRepository;
    private TicketRepository ticketRepository;
    @Autowired
    public TicketService(SeatRepository seatRepository,
                         ShowSeatRepository showSeatRepository,
                         ShowRepository showRepository,
                         UserRepository userRepository,
                         TicketRepository ticketRepository){
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }
    public Ticket bookTicket(Long userId, Long showId, List<Long> seatIds)
            throws Exception {

        List<Seat> seats = seatRepository.findAllByIdIn(seatIds);
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new InvalidArgumentException("show By "+showId+" does not exist.");
        }
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats,showOptional.get());
        for(ShowSeat showSeat:showSeats){
            if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))){
                throw new SeatNotAvailableException("Seats are not available");
            }
        }
        List<ShowSeat> savedShowSeats = new ArrayList<ShowSeat>();
        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new Exception("User Id with "+userId+" does not exist.");
        }

        Ticket ticket = new Ticket();
        ticket.setBookedBy(userOptional.get());
        ticket.setBookingTime(new Date());
        ticket.setShow(showOptional.get());
        ticket.setSeats(seats);
        ticket.setAmount(0);
        ticket.setStatus(TicketStatus.PROCESSING);

        Ticket savedTicket = ticketRepository.save(ticket);


        return savedTicket;
    }
}
