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
        if (numBookedTickets < bookedTickets.length) {
            bookedTickets[numBookedTickets] = ticket;
            numBookedTickets++;
        }
    }

    public void reserveTickets(int numBookedTickets, Venue venue) {
        if (numBookedTickets <= venue.getAvailableTickets()) {
            for (int i = 0; i < numBookedTickets; i++) {
                Ticket ticket = venue.getTicket(i);
                ticket.setBookingStatus(true);
                addBookedTicket(ticket);
            }
        }
    }
}
