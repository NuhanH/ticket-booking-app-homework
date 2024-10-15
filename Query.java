public class Query {
    public void getSectionWithHighestRevenue(Venue venue) {
        double maxRevenue = 0;
        int sectionNumber = 0;
        for (Section section : venue.getSections()) {
            if (section.getRevenue() > maxRevenue) {
                maxRevenue = section.getRevenue();
                sectionNumber = section.getID();
            }
        }
        System.out.println("Section that has the highest revenue is: " + sectionNumber + " with revenue: " + maxRevenue);
    }

    public void getTotalRevenue(Venue venue) {
        double totalRevenue = 0;
        for (Section section : venue.getSections()) {
            totalRevenue += section.getRevenue();
        }

        System.out.println("Total revenue is: " + totalRevenue);
    }

    public void getOccupancyRate(Venue venue) {
        double availableTicketNumber = venue.getAvailableTicketNumber();
        double totalTicketNumber = venue.getTotalTicketNumber();
        double occupancyRate = ((totalTicketNumber-availableTicketNumber)/totalTicketNumber)*100.00;

        System.out.println("Occupancy rate is: " + occupancyRate + "%");
    }

    public void getCustomerWithHighestTotalPrice(Customer customer) {
            String customerName;
            double totalPrice;
            customerName = customer.getName();
            totalPrice = customer.getTotalPrice();

            System.out.println("Customer with the highest total price is: " + customerName + " with total price: " + totalPrice);
        }
    
    public void getTheMostExpensiveTicket(Venue venue) {
        Ticket mostExpensiveTicket = new Ticket();
        Ticket ticket = new Ticket();
        for (Section section : venue.getSections()) {
            ticket = section.getTheMostExpensiveTicket();
            if (mostExpensiveTicket.getPrice() < ticket.getPrice()) {
                mostExpensiveTicket = ticket;
            } 
        }
        System.out.println("The most expensive ticket is: " + mostExpensiveTicket.getPrice());
    }
}