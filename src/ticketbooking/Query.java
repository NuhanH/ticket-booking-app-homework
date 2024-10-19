package src.ticketbooking;

// Query class is responsible for executing queries on the Venue and Customer objects and printing the results.

public class Query {

    /**  Method to get the section with the highest revenue and print the result by 
       calling the getRevenue() method of the Section class and comparing the revenue of each section.
     * @param venue The venue object to find the section with the highest revenue.
     */ 
    public void getSectionWithHighestRevenue(Venue venue) {
        double maxRevenue = 0;
        int sectionNumber = 0;
        for (Section section : venue.getSections()) {
            if (section.getRevenue() > maxRevenue) {
                maxRevenue = section.getRevenue();
                sectionNumber = section.getID();
            }
        }
        System.out.println("\nSection that has the highest revenue is: " + sectionNumber + " with revenue: " + maxRevenue);
    }

    /**  
     * Method to get the total revenue of the venue by calling the getRevenue() method of every 
       section in the venue and adding them up.
     * @param venue The venue object to calculate the total revenue.
    */
    public void getTotalRevenue(Venue venue) {
        double totalRevenue = 0;
        for (Section section : venue.getSections()) {
            totalRevenue += section.getRevenue();
        }

        System.out.println("\nTotal revenue is: " + totalRevenue);
    }

    /**  
     * Method to get the occupancy rate of the venue by calling the getAvailableTicketNumber() and 
       getTotalTicketNumber() methods of the Venue class and calculating the occupancy rate.
     * @param venue The venue object to calculate the occupancy rate.
    */
    public void getOccupancyRate(Venue venue) {
        double availableTicketNumber = venue.getAvailableTicketNumber();
        double totalTicketNumber = venue.getTotalTicketNumber();
        double occupancyRate = ((totalTicketNumber-availableTicketNumber)/totalTicketNumber)*100.00;

        System.out.println("\nOccupancy rate is: " + occupancyRate + "%");
    }

    /**  
     * Method to show the seat occupancies of each section in the venue by calling the isReserved() method of the Ticket class.
     * The method prints 'X' for reserved seats and 'O' for available seats.
     * @param venue The venue object to show the seat occupancies.
    */
    public void showSectionOccupancies(Venue venue) {
        for (Section section : venue.getSections()) {

            // Title of the output.
            System.out.println("\nSeat occupancies of Section " + section.getID() + ": ");
            for (int i = 0; i < section.getNumRows(); i++) {
                String row = "";
                for (int j = 0; j < section.getNumSeats(); j++) {
                    if (section.getSeats()[i][j].isReserved()) {
                        row += "X ";
                    } else {
                        row += "O ";
                    }
                }
                System.out.println(row);
            }
        }
    }

    /**  
     * Method to get the highest paying customer's tickets by calling the getBookedTickets() method of the Customer class.
     * @param customer The customer object to get the highest paying customer's tickets.
    */
    public void getHighestPayingCustomerTickets(Customer customer) {
            String customerName;
            customerName = customer.getName();

            System.out.println("\nCustomer with the highest total price is " + customerName + ":");

            int i = 1;
            for (Ticket ticket : customer.getBookedTickets()) {
                System.out.println("Ticket " + i + ": " + "Section: " + ticket.getSectionNumber() + " Row: " + ticket.getRowNumber() + " Seat: " + ticket.getSeatNumber() + " Price: " + ticket.getPrice());
                i++;
            }
        }
    
    /**
     * Method to get the most expensive ticket by calling the getTheMostExpensiveTicket() method of every Section class 
       and comparing the prices of the tickets.
     * @param venue The venue object to get the most expensive ticket.
     */
    public void getTheMostExpensiveTicket(Venue venue) {
        Ticket mostExpensiveTicket = new Ticket();
        for (Section section : venue.getSections()) {
            Ticket ticket = section.getTheMostExpensiveTicket();
            if (mostExpensiveTicket.getPrice() < ticket.getPrice()) {
                mostExpensiveTicket = ticket;
            } 
        }
        System.out.println("\nThe most expensive ticket is: " + mostExpensiveTicket.getPrice() + "\n");
    }
}