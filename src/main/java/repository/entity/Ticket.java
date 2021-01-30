package repository.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String family;
    private String origin;
    private String destination;
    private String date;
    private int flightNumber;
    private double price;

    public Ticket(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static final class TicketBuilder {
        private int id;
        private String name;
        private String family;
        private String origin;
        private String destination;
        private String date;
        private int flightNumber;
        private double price;

        private TicketBuilder() {
        }

        public static TicketBuilder aTicket() {
            return new TicketBuilder();
        }

        public TicketBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TicketBuilder withFamily(String family) {
            this.family = family;
            return this;
        }

        public TicketBuilder withOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public TicketBuilder withDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public TicketBuilder withDate(String date) {
            this.date = date;
            return this;
        }

        public TicketBuilder withFlightNumber(int flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public TicketBuilder withPrice(double price) {
            this.price = price;
            return this;
        }
        public TicketBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public Ticket build() {
            Ticket ticket = new Ticket();
            ticket.setId(id);
            ticket.setName(name);
            ticket.setFamily(family);
            ticket.setOrigin(origin);
            ticket.setDestination(destination);
            ticket.setDate(date);
            ticket.setFlightNumber(flightNumber);
            ticket.setPrice(price);
            return ticket;
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", flightNumber=" + flightNumber +
                ", price=" + price +
                '}';
    }
}
