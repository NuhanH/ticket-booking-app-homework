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
        System.out.println("\nSection that has the highest revenue is: " + sectionNumber + " with revenue: " + maxRevenue);
    }

    public void getTotalRevenue(Venue venue) {
        double totalRevenue = 0;
        for (Section section : venue.getSections()) {
            totalRevenue += section.getRevenue();
        }

        System.out.println("\nTotal revenue is: " + totalRevenue);
    }

    public void getOccupancyRate(Venue venue) {
        double availableTicketNumber = venue.getAvailableTicketNumber();
        double totalTicketNumber = venue.getTotalTicketNumber();
        double occupancyRate = ((totalTicketNumber-availableTicketNumber)/totalTicketNumber)*100.00;

        System.out.println("\nOccupancy rate is: " + occupancyRate + "%");
    }

    public void showSectionOccupancies(Venue venue) {
        for (Section section : venue.getSections()) {
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
    
    public void getTheMostExpensiveTicket(Venue venue) {
        Ticket mostExpensiveTicket = new Ticket();
        Ticket ticket = new Ticket();
        for (Section section : venue.getSections()) {
            ticket = section.getTheMostExpensiveTicket();
            if (mostExpensiveTicket.getPrice() < ticket.getPrice()) {
                mostExpensiveTicket = ticket;
            } 
        }
        System.out.println("\nThe most expensive ticket is: " + mostExpensiveTicket.getPrice() + "\n");
    }
}