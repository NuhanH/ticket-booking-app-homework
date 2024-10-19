package src.ticketbooking;
import java.util.Random;

    /**  Customer class with its 3 constructors, getters, setters, and methods to 
        calculate the total price of the tickets, reserve tickets, and get available tickets
     */

public class Customer {
    private String name;
    private int numBookedTickets;
    private double totalPrice;
    private Ticket[] bookedTickets;

    // Default constructor
    public Customer() {
        this.name = "";
        this.numBookedTickets = 0;
        this.bookedTickets = new Ticket[0];
    }

    // Copy constructor
    public Customer(Customer customer) {
        this.name = customer.name;
        this.numBookedTickets = customer.numBookedTickets;
        this.bookedTickets = new Ticket[customer.bookedTickets.length];

        // Deep copy of bookedTickets
        for (int i = 0; i < customer.bookedTickets.length; i++) {
            this.bookedTickets[i] = new Ticket(customer.bookedTickets[i]);
        }
    }

    // Parameterized constructor
    public Customer(String name, int numBookedTickets) {
        this.name = name;
        this.numBookedTickets = numBookedTickets;
        this.bookedTickets = new Ticket[numBookedTickets];
    }

    // Getters and setters
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

    // Method to calculate the total price of the tickets and set the totalPrice attribute.
    private void setTotalPrice() {
        double calculatedTotalPrice = 0;
        for (Ticket ticket : bookedTickets) {
            calculatedTotalPrice += ticket.getPrice();
        }
        this.totalPrice = calculatedTotalPrice;
    }

    public int getNumBookedTickets() {
        return numBookedTickets;
    }

    public void setNumBookedTickets(int numBookedTickets) {
        this.numBookedTickets = numBookedTickets;
    }

    // Method to get the booked tickets and return a deep copy of the bookedTickets array for security reasons.
    public Ticket[] getBookedTickets() {
        Ticket[] temp = new Ticket[bookedTickets.length];

        for (int i = 0; i < bookedTickets.length; i++) {
            temp[i] = new Ticket(bookedTickets[i]);
        }
        return temp;
    }

    public void setBookedTickets(Ticket[] bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    // Method to add a booked ticket to the bookedTickets array.
    public void addBookedTicket(Ticket ticket, int i) {
        if (numBookedTickets <= bookedTickets.length) {
            bookedTickets[i] = ticket;
        }
    }

    // Method to reserve tickets for the customer and add them to the bookedTickets array.
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

    // Method to get available tickets for the customer.
    private Ticket[] getAvailableTickets(Venue venue) {
        Random random = new Random();
        boolean isEnoughSeats = false;
        int sectionID = 0;
        Ticket[] tickets = new Ticket[numBookedTickets];

        // Check if there are enough seats in the venue for the customer in a random section.
        while(!isEnoughSeats) {
            sectionID = random.nextInt(venue.getSections().length);
            if (venue.getSections()[sectionID].getAvailableTicketNumber() >= numBookedTickets) {
                isEnoughSeats = true;
            }
        }

        // Reserve tickets for the customer randomly.
        for (int i = 0; i < numBookedTickets; i++) {
            boolean isSeatEmpty = false;
            int rowNumber = 0;
            int seatNumber = 0;

            while (!isSeatEmpty) {
                rowNumber = random.nextInt(venue.getSections()[sectionID].getNumRows())+1;
                seatNumber = random.nextInt(venue.getSections()[sectionID].getNumSeats())+1;
                
                // Check if the seat is empty and turn isSeatEmpty to true if it is.
                if (!venue.getSections()[sectionID].getSeats()[rowNumber-1][seatNumber-1].isReserved()) {
                    isSeatEmpty = true;
                }
            }

            // Set the booking status of the seat to true and add the ticket to the tickets array.
            venue.getSections()[sectionID].getSeats()[rowNumber-1][seatNumber-1].setBookingStatus(true);
            tickets[i] = venue.getSections()[sectionID].getSeats()[rowNumber-1][seatNumber-1];
        }

        return tickets;
        }
}