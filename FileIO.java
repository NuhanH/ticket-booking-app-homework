import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileIO {
    private static String name;
    private static int numBookedTickets;
    private static int customerNumber = 0;
    private static Customer customerWithHighestTotalPrice = new Customer();
    
    public static Customer readFile(String pathString, Venue venue) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathString))) {
            String line;

            boolean isFirstLine = true; // Add this flag
            while ((line = reader.readLine()) != null) {
                if (!isFirstLine) {
                    StringTokenizer tokenizer = new StringTokenizer(line , ",");

                    int i = 0;
                    while (tokenizer.hasMoreTokens()) {
                        String token = tokenizer.nextToken();
                        if (i==0) {
                            name = token;
                        } else  {
                            numBookedTickets = Integer.parseInt(token);
                        }
                        i++;
                    }

                    // Create a new Customer object
                    Customer customer = new Customer(name, numBookedTickets);
                    customer.reserveTickets(venue);

                    if (customer.getTotalPrice() > customerWithHighestTotalPrice.getTotalPrice()) {
                        customerWithHighestTotalPrice = customer;
                    }

                }
                isFirstLine = false;
            }
        } catch (IOException e) {
            // Handle the exception here
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    
    return customerWithHighestTotalPrice;
    }
}
