package src.ticketbookingapp;
import java.io.IOException;
import src.fileaccess.FileIO;
import src.ticketbooking.Customer;
import src.ticketbooking.Query;
import src.ticketbooking.Venue;

public class TicketBookingApp {
    public static void main(String[] args) throws IOException {
        Venue venue = new Venue();
        FileIO fileIO = new FileIO();
        final String PATH_STRING = "resources/customers.csv";
        Customer customer = fileIO.readFile(PATH_STRING, venue);

        TicketBookingApp app = new TicketBookingApp();
        app.printQueries(venue, customer);
    }

    private void printQueries(Venue venue, Customer customer) {
        Query query = new Query();
        query.getSectionWithHighestRevenue(venue);
        query.showSectionOccupancies(venue);
        query.getTotalRevenue(venue);
        query.getOccupancyRate(venue);
        query.getHighestPayingCustomerTickets(customer);
        query.getTheMostExpensiveTicket(venue);
    }
}