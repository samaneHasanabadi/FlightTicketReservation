package service;

import exceptions.DateFormatException;
import exceptions.FlightNumberOutOfBoundException;
import repository.dao.TicketDao;
import repository.entity.Ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TicketServiceImpl implements TicketService {

    private static TicketServiceImpl instance;

    public static TicketServiceImpl getInstance() {
        if(instance == null){
            synchronized (TicketServiceImpl.class){
                if(instance == null){
                    instance = new TicketServiceImpl();
                }
            }
        }
        return instance;
    }
    private TicketDao ticketDao = TicketDao.getInstance();

    @Override
    public boolean cancelTicket(Ticket ticket) {
        boolean isCanceled = false;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date ticketDate = null;
        try {
            ticketDate = new SimpleDateFormat("yyyy-MM-dd").parse(ticket.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(ticketDate.before(date)){
            ticketDao.delete(ticket);
            isCanceled = true;
        }
        return isCanceled;
    }

    @Override
    public Ticket getTicketById(int id) {
        Ticket ticket = ticketDao.read(id);
        return ticket;
    }

    @Override
    public void addTicket(Ticket ticket) throws Exception{
        if(ticket.getFlightNumber() <100 || ticket.getFlightNumber() > 999){
            throw new FlightNumberOutOfBoundException();
        }else if(ticket.getDate() == null){
            throw new DateFormatException();
        }
        else {
            ticketDao.creat(ticket);
        }
    }

    @Override
    public void updateTicket(Ticket ticket) throws FlightNumberOutOfBoundException {
        if(ticket.getFlightNumber() <100 || ticket.getFlightNumber() > 999){
            throw new FlightNumberOutOfBoundException();
        }else {
            ticketDao.update(ticket);
        }
    }

    @Override
    public List<Ticket> searchTickets(String name, String family, Date from, Date to, int flightNumber, String destination, String origin, int minPrice, int maxPrice, String company) {
        ticketDao.searchTickets(name, family, from, to, flightNumber, destination, origin, minPrice, maxPrice, company);
        return null;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDao.showAllTickets();
    }

    @Override
    public void deleteAllTickets() {
        ticketDao.deleteAllTickets();
    }


}
