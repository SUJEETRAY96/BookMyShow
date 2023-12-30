package com.scaler.BookMyShow.exception;

public class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException(String seatsAreNotAvailable) {
        super(seatsAreNotAvailable);
    }
}
