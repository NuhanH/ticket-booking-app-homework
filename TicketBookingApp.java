import java.io.IOException;

public class TicketBookingApp {
    static String pathString = "resources/customers.csv";
    
    public static void main(String[] args) throws IOException {
        Venue venue = new Venue();
        FileIO.readFile(pathString, venue);
        Query query = new Query();
        query.getSectionWithHighestRevenue(venue);
        query.getTotalRevenue(venue);
    }
}