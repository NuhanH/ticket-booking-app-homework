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

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public boolean isReserved() {
        return bookingStatus;
    }
}
