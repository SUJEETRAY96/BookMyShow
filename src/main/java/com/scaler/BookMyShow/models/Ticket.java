package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private int amount;
    private Date bookingTime;
    @ManyToMany
    private List<Seat> seats;
    @ManyToOne
    private User bookedBy;
    @OneToMany
    private List<Payments> payments;
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;
}
