public class Customer {
    String name;
    int numBookedTickets;
    Ticket[] bookedTickets;

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

    public Customer(String name) {
        this.name = name;
        this.numBookedTickets = 0;
        this.bookedTickets = new Ticket[0];
    }
}
