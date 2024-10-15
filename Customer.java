import java.util.Random;

public class Customer {
    private String name;
    private int numBookedTickets;
    private double totalPrice;
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

    public double getTotalPrice() {
        setTotalPrice();
        return totalPrice;
    }

    private void setTotalPrice() {
        double totalPrice = 0;
        for (Ticket ticket : bookedTickets) {
            totalPrice += ticket.getPrice();
        }
        this.totalPrice = totalPrice;
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

    public void addBookedTicket(Ticket ticket, int i) {
        if (numBookedTickets <= bookedTickets.length) {
            bookedTickets[i] = ticket;
        }
    }

    public void reserveTickets(Venue venue) {
        if (numBookedTickets <= venue.getAvailableTicketNumber()) {
            Ticket[] tickets = getAvailableTickets(venue);
            int i = 0;
            for (Ticket ticket : tickets) {
                this.addBookedTicket(ticket, i);
                i++;
        }
    }
    }

    private Ticket[] getAvailableTickets(Venue venue) {
        Random random = new Random();
        boolean isEnoughSeats = false;
        int sectionID = 0;
        Ticket[] tickets = new Ticket[numBookedTickets];

        while(!isEnoughSeats) {
            sectionID = random.nextInt(venue.getSections().length);
            if (venue.getSections()[sectionID].getAvailableTicketNumber() >= numBookedTickets) {
                isEnoughSeats = true;
            }
        }
        for (int i = 0; i < numBookedTickets; i++) {
            boolean isSeatEmpty = false;
            int rowNumber = 0;
            int seatNumber = 0;
            while (!isSeatEmpty) {
                rowNumber = random.nextInt(venue.getSections()[sectionID].getNumRows())+1;
                seatNumber = random.nextInt(venue.getSections()[sectionID].getNumSeats())+1;
                if (!venue.getSections()[sectionID].getSeats()[rowNumber-1][seatNumber-1].isReserved()) {
                    isSeatEmpty = true;
                }
            }

            venue.getSections()[sectionID].getSeats()[rowNumber-1][seatNumber-1].setBookingStatus(true);
            tickets[i] = venue.getSections()[sectionID].getSeats()[rowNumber-1][seatNumber-1];
            //System.out.println(rowNumber + " " + seatNumber);
        }
        return tickets;
        }
}