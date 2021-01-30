package controller;

import exceptions.FlightNumberOutOfBoundException;
import repository.entity.Ticket;
import service.TicketServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tickets")
public class TicketsREST {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getTickets(){
        //return Response.status(200).entity("hi").build();
        return TicketServiceImpl.getInstance().getAllTickets();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket getTicketById(@PathParam("id") int id){
        return TicketServiceImpl.getInstance().getTicketById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response creatTicket(Ticket ticket){
        try {
            TicketServiceImpl.getInstance().addTicket(ticket);
            System.out.println("ticket is created");
            return Response.status(200).entity("your ticket is registered").build();
        } catch (Exception e) {
            return Response.status(200).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTicket(@PathParam("id") int id, Ticket ticket){
        try {
            TicketServiceImpl.getInstance().updateTicket(ticket);
            return Response.status(200).entity("ticket with id "+id+" is updated").build();
        } catch (FlightNumberOutOfBoundException e) {
            return Response.status(200).entity(e.getMessage()).build();
        }
    }

    @DELETE
    public Response deleteTickets(){
        TicketServiceImpl.getInstance().deleteAllTickets();
        return Response.status(200).entity("All tickets are deleted").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTicketById(@PathParam("id") int id){
        Ticket ticket = TicketServiceImpl.getInstance().getTicketById(id);
        TicketServiceImpl.getInstance().cancelTicket(ticket);
        return Response.status(200).entity("ticket with id "+id+" is deleted").build();
    }

}
