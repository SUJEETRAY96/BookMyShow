package com.scaler.BookMyShow.repositories;

import com.scaler.BookMyShow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Ticket save(Ticket ticket);
}
