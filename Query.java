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

    
}
