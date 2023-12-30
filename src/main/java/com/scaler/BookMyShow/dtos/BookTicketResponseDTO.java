package com.scaler.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookTicketResponseDTO {
    private int amount;
    private long ticketId;
    private List<String> seatNumber;
    private String auditoriumName;

}
