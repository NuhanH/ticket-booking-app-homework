import java.io.IOException;

public class TicketBookingApp {
    private static final String PATH_STRING = "resources/customers.csv";
    static Customer customer;
    
    public static void main(String[] args) throws IOException {
        Venue venue = new Venue();
        customer = FileIO.readFile(PATH_STRING, venue);

        Query query = new Query();
        query.getSectionWithHighestRevenue(venue);
        query.getTotalRevenue(venue);
        query.getOccupancyRate(venue);
        query.getCustomerWithHighestTotalPrice(customer);
        query.getTheMostExpensiveTicket(venue);
    }
}