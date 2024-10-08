import java.io.IOException;

public class TicketBookingApp {
    static String pathString = "resources/customers.csv";
    public static void main(String[] args) throws IOException {
        FileIO.readFile(pathString);
    }
}