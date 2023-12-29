package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Event event;
    @ManyToOne
    private SeatType seatType;
    private int price;
}
