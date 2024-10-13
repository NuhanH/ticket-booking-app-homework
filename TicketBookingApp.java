import java.io.IOException;

public class TicketBookingApp {
    static String pathString = "resources/customers.csv";
    static Customer customer;
    
    public static void main(String[] args) throws IOException {
        Venue venue = new Venue();
        customer = FileIO.readFile(pathString, venue);

        Query query = new Query();
        query.getSectionWithHighestRevenue(venue);
        query.getTotalRevenue(venue);
        query.getOccupancyRate(venue);
        query.getCustomerWithHighestTotalPrice(customer);
        query.getTheMostExpensiveTicket(venue);
    }
}