public class Section {
    private int ID;
    private int numRows;
    private int numSeats;
    private double maxPrice;
    private double minPrice;
    private Ticket[] seats;

    public Section() {
        this.ID = 0;
        this.numRows = 0;
        this.numSeats = 0;
        this.maxPrice = 0.0;
        this.minPrice = 0.0;
        this.seats = new Ticket[0];
    }

    public Section(Section section) {
        this.ID = section.ID;
        this.numRows = section.numRows;
        this.numSeats = section.numSeats;
        this.maxPrice = section.maxPrice;
        this.minPrice = section.minPrice;
        this.seats = new Ticket[section.seats.length];
        for (int i = 0; i < section.seats.length; i++) {
            this.seats[i] = new Ticket(section.seats[i]);
        }
    }

    public Section(int ID, int numRows, int numSeats, double maxPrice, double minPrice) {
        this.ID = ID;
        this.numRows = numRows;
        this.numSeats = numSeats;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.seats = new Ticket[numRows * numSeats];
        for (int i = 0; i < numRows * numSeats; i++) {
            this.seats[i] = new Ticket();
        }
    }
 }
