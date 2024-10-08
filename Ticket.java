public class Ticket {
    private int sectionNumber;
    private int rowNumber;
    private int seatNumber;
    private double price;
    private boolean bookingStatus;

    public Ticket() {
        this.sectionNumber = 0;
        this.rowNumber = 0;
        this.seatNumber = 0;
        this.price = 0.0;
        this.bookingStatus = false;
    }

    public Ticket(Ticket ticket) {
        this.sectionNumber = ticket.sectionNumber;
        this.rowNumber = ticket.rowNumber;
        this.seatNumber = ticket.seatNumber;
        this.price = ticket.price;
        this.bookingStatus = ticket.bookingStatus;
    }

    public Ticket(int sectionNumber, int rowNumber, int seatNumber, double price) {
        this.sectionNumber = sectionNumber;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.price = price;
        this.bookingStatus = false;
    }
}
