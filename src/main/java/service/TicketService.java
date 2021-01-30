package service;

import exceptions.FlightNumberOutOfBoundException;
import repository.entity.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketService {

    boolean cancelTicket(Ticket ticket);
    Ticket getTicketById(int id);
    void addTicket(Ticket ticket) throws Exception;
    void updateTicket(Ticket ticket) throws FlightNumberOutOfBoundException;
    List<Ticket> searchTickets(String name, String family,Date from, Date to, int flightNumber, String destination,
                               String origin, int minPrice, int maxPrice, String company);
    List<Ticket> getAllTickets();
    void deleteAllTickets();
}
