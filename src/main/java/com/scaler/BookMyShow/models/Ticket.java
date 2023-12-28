package com.scaler.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Ticket extends BaseModel{
    private int amount;
    private Date bookingTime;
    private List<Seat> seats;
    private User bookedBy;
    private List<Payments> payments;
    private Show show;
    private TicketStatus status;
}
