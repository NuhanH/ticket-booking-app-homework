import java.util.Random;

public class Customer {
    private String name;
    private int numBookedTickets;
    private Ticket[] bookedTickets;

    public Customer() {
        this.name = "";
        this.numBookedTickets = 0;
        this.bookedTickets = new Ticket[0];
    }

    public Customer(Customer customer) {
        this.name = customer.name;
        this.numBookedTickets = customer.numBookedTickets;
        this.bookedTickets = new Ticket[customer.bookedTickets.length];
        for (int i = 0; i < customer.bookedTickets.length; i++) {
            this.bookedTickets[i] = new Ticket(customer.bookedTickets[i]);
        }
    }

    public Customer(String name, int numBookedTickets) {
        this.name = name;
        this.numBookedTickets = numBookedTickets;
        this.bookedTickets = new Ticket[numBookedTickets];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumBookedTickets() {
        return numBookedTickets;
    }

    public void setNumBookedTickets(int numBookedTickets) {
        this.numBookedTickets = numBookedTickets;
    }

    public Ticket[] getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(Ticket[] bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public void addBookedTicket(Ticket ticket) {
        if (numBookedTickets <= bookedTickets.length) {
            for (int i = 0; i < numBookedTickets; i++) {
                bookedTickets[i] = ticket;
            }
        }
    }

    public void reserveTickets(Venue venue) {
        if (numBookedTickets <= venue.getAvailableTicketNumber()) {
            Ticket ticket = getAvailableTicket(venue);

            ticket.setBookingStatus(true);
            this.addBookedTicket(ticket);
        }
    }

    private Ticket getAvailableTicket(Venue venue) {
        Random random = new Random();
        boolean isEnoughSeats = false;
        int sectionID = 0;
        while(!isEnoughSeats) {
            sectionID = random.nextInt(venue.getSections().length)+1;
            if (venue.getSections()[sectionID-1].getAvailableTicketNumber() >= numBookedTickets) {
                isEnoughSeats = true;
            }
        }

        for (int i = 0; i < numBookedTickets; i++) {
            boolean isSeatEmpty = false;

            while (!isSeatEmpty) {
                int rowNumber = random.nextInt(venue.getSections()[sectionID-1].getNumRows())+1;
                int seatNumber = random.nextInt(venue.getSections()[sectionID-1].getNumSeats())+1;
                if (venue.getSections()[sectionID-1].getSeats()[rowNumber-1][seatNumber-1].isReserved() == false) {
                    isSeatEmpty = true;
                }
            return venue.getSections()[sectionID-1].getSeats()[rowNumber-1][seatNumber-1];
            }   
        }
        return null;
        }
    }
