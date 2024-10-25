package src.ticketbooking;
import java.util.Random;

/**
 * Section class represents a section in a venue.
 * A section has a unique ID, number of rows, number of seats, maximum price, minimum price and a 2D array of tickets.
 * The first row has the maximum price, the second row has 80% of the maximum price and the 
   rest of the rows have random prices between the maximum and minimum prices.
 */

public class Section {
    private int ID;
    private int numRows;
    private int numSeats;
    private double maxPrice;
    private double minPrice;
    private Ticket[][] seats;

    // Default constructor
    public Section() {
        this.ID = 0;
        this.numRows = 0;
        this.numSeats = 0;
        this.maxPrice = 0.0;
        this.minPrice = 0.0;
        this.seats = new Ticket[0][0];
    }

    // Copy constructor
    public Section(Section section) {
        this.ID = section.ID;
        this.numRows = section.numRows;
        this.numSeats = section.numSeats;
        this.maxPrice = section.maxPrice;
        this.minPrice = section.minPrice;
        this.seats = new Ticket[section.numRows][section.numSeats];

        // Deep copy of the 2D array of tickets
        for (int i = 0; i < section.numRows; i++) {
            for (int j = 0; j < section.numSeats; j++) {
                this.seats[i][j] = new Ticket(section.seats[i][j]);
            }
        }
    }

    // Parameterized constructor
    public Section(int ID, int numRows, int numSeats, double maxPrice, double minPrice) {
        this.ID = ID;
        this.numRows = numRows;
        this.numSeats = numSeats;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.seats = new Ticket[numRows][numSeats];

        // Initialize the 2D array of tickets with the given parameters.
        for (int i = 1; i <= numRows; i++) {
            for (int j = 1; j <= numSeats; j++) {
                Ticket ticket;
                switch (i) {
                    case 1:
                        ticket = new Ticket(ID, i, j, maxPrice);
                        break;
                    case 2:
                        ticket = new Ticket(ID, i, j, (maxPrice*80)/100);
                        break;
                    default:
                        Random random = new Random();
                        ticket = new Ticket(ID, i, j, random.nextDouble(minPrice, maxPrice));
                        break;
                }
                // Assign the ticket to the 2D array of tickets.
                this.seats[i-1][j-1] = ticket;
            }
        }
    }

    // Getters and setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public Ticket[][] getSeats() {
        return seats;
    }

    public void setSeats(Ticket[][] seats) {
        this.seats = seats;
    }

    // It checks every ticket in the section and returns the number of available tickets.
    public int getAvailableTicketNumber() {
        int availableTickets = 0;
        for (Ticket[] seatRow : seats) {
            for (Ticket ticket : seatRow) {
                if (!ticket.isReserved()) {
                    availableTickets++;
                }
            }
        }
        return availableTickets;
    }

    // It checks every ticket in the section and returns the number of reserved tickets.
    public double getRevenue() {
        double revenue = 0;
        for (Ticket[] seatRow : seats) {
            for (Ticket ticket : seatRow) {
                if (ticket.isReserved()) {
                    revenue += ticket.getPrice();
                }
            }
        }
        return revenue;
    }

    // It returns the most expensive ticket in the section by checking every ticket in the section.
    public Ticket getTheMostExpensiveTicket() {
        Ticket mostExpensiveTicket = new Ticket();
        for (Ticket[] seatRow : seats) {
            for (Ticket ticket : seatRow) {
                if (ticket.isReserved() && ticket.getPrice() > mostExpensiveTicket.getPrice()) {
                    mostExpensiveTicket = ticket;
                }
            }
        }
        // It return a copy of the most expensive ticket.
        return new Ticket(mostExpensiveTicket);
    }

 }
