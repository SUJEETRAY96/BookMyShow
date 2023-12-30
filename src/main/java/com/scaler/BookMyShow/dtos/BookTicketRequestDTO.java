package com.scaler.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class BookTicketRequestDTO {
    private List<Long> seatIds;
    private Long userId;
    private Long showId;
}
