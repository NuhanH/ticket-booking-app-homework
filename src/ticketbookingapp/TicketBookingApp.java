package src.ticketbookingapp;
import java.io.IOException;
import src.fileaccess.FileIO;
import src.ticketbooking.Customer;
import src.ticketbooking.Query;
import src.ticketbooking.Venue;

/**
 * TicketBookingApp class is the main class of the application.
 * This class is the entry point of the application.
 * It prints the queries to the console.
 * @author Mert Deniz Ertekin 310201103
 * @author Nuhan Berke Hallaç 300201019
 */

public class TicketBookingApp {

    /**
     * Main method of the application.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Venue venue = new Venue();
        FileIO fileIO = new FileIO();
        final String PATH_STRING = "resources/customers.csv";

        // This is the highest paid customer object.
        Customer customer = fileIO.readFile(PATH_STRING, venue);

        TicketBookingApp app = new TicketBookingApp();
        app.printQueries(venue, customer);
    }

    /**
     * Method to print the queries to the console.
     * It should print the outputs in the following order:
     * 1. Section with the highest revenue
     * 2. Seat occupancies of each section
     * 3. Total revenue of the venue
     * 4. Occupancy rate of the venue
     * 5. Highest paying customer's ticket information
     * 6. The most expensive ticket in the venue
     * @param venue Venue object
     * @param customer Customer object
     */
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