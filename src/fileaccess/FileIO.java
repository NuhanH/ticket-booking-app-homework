package src.fileaccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import src.ticketbooking.Customer;
import src.ticketbooking.Venue;

/**
 This is our fileIO class. We read customers.csv data source file and 
 create a customer object for each line in the file. We reserve tickets 
 for each customer and keep track of the customer with the highest total 
 price for using it in queries.
*/

public class FileIO {
    private String name;
    private int numBookedTickets;
    private Customer customerWithHighestTotalPrice = new Customer();
    
    /**
     * This method reads the customers.csv file and creates a customer object for each line in the file.
     * It reserves tickets for each customer and keeps track of the customer with the highest total price.
     * @param pathString The path of the file to be read.
     * @param venue The venue object to reserve tickets.
     * @return The customer object with the highest total price.
     */

    public Customer readFile(String pathString, Venue venue) throws IOException {

        /** We used buffered reader to read the file line by line and StringTokenizer to split the line 
           into tokens in a while loop.
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(pathString))) {
            String line;

            boolean isFirstLine = true; // We skip the first line of the file which is the header.
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

                    // Create a customer object for each line in the file and reserve tickets for the customer.
                    Customer customer = new Customer(name, numBookedTickets);
                    customer.reserveTickets(venue);

                    // Keep track of the customer with the highest total price.
                    if (customer.getTotalPrice() > customerWithHighestTotalPrice.getTotalPrice()) {
                        customerWithHighestTotalPrice = customer;
                    }

                }
                isFirstLine = false;
            }
        } catch (IOException e) {
            // Print error message if an exception occurs.
            System.err.println("Error reading file: " + e.getMessage());
        }
        
    // Return the customer object with the highest total price.
        Customer copyCustomer = new Customer(customerWithHighestTotalPrice);

    return copyCustomer;
    }
}
