import java.util.Random;

public class Section {
    private int ID;
    private int numRows;
    private int numSeats;
    private double maxPrice;
    private double minPrice;
    private Ticket[][] seats;

    public Section() {
        this.ID = 0;
        this.numRows = 0;
        this.numSeats = 0;
        this.maxPrice = 0.0;
        this.minPrice = 0.0;
        this.seats = new Ticket[0][0];
    }

    public Section(Section section) {
        this.ID = section.ID;
        this.numRows = section.numRows;
        this.numSeats = section.numSeats;
        this.maxPrice = section.maxPrice;
        this.minPrice = section.minPrice;
        this.seats = new Ticket[section.numRows][section.numSeats];
        for (int i = 0; i < section.numRows; i++) {
            for (int j = 0; j < section.numSeats; j++) {
                this.seats[i][j] = new Ticket(section.seats[i][j]);
            }
        }
    }

    public Section(int ID, int numRows, int numSeats, double maxPrice, double minPrice) {
        this.ID = ID;
        this.numRows = numRows;
        this.numSeats = numSeats;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.seats = new Ticket[numRows][numSeats];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numSeats; j++) {
                Ticket ticket;
                switch (i) {
                    case 0:
                        ticket = new Ticket(ID, i, j, maxPrice);
                        break;
                    case 1:
                        ticket = new Ticket(ID, i, j, (maxPrice*80)/100);
                        break;
                    default:
                        Random random = new Random();
                        ticket = new Ticket(ID, i, j, random.nextDouble(minPrice, maxPrice));
                        break;
                }
                this.seats[i][j] = ticket;
            }
        }
    }

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

    public void randomTicketPrice() {

    }
 }
