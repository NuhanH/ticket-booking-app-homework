package src.ticketbooking;
import java.util.Random;

/**
 * Venue class represents the venue of the event. It contains an array of Section objects.
 * The Venue class is responsible for creating the sections of the venue and keeping track 
   of the total number of tickets and available tickets. 
 */

public class Venue {
    private Section[] sections = new Section[4];

    // Default constructor
    public Venue() {
        Random random = new Random();
        double finalMaxPrice = 0;
        double finalMinPrice = 0;
        int i = 0;
            for(double maxPrice = 5001; maxPrice >= 3500; maxPrice -= 500) {
                finalMaxPrice = random.nextDouble(maxPrice-1000, maxPrice);
                finalMinPrice = random.nextDouble(maxPrice-2000, maxPrice-1001);
                Section section = new Section(i, 10, 60, finalMaxPrice, finalMinPrice);
                sections[i] = section;
                i++;
        }
    }

    // Copy constructor
    public Venue(Venue venue) {
        this.sections = new Section[venue.sections.length];
        for (int i = 0; i < venue.sections.length; i++) {
            this.sections[i] = new Section(venue.sections[i]);
        }
    }

    // Parameterized constructor
    public Venue(Section[] sections) {
        this.sections = sections;
    }

    // Getters and Setters
    public Section[] getSections() {
        return sections;
    }

    public void setSections(Section[] sections) {
        this.sections = sections;
    }
    
    // Method to get the total ticket number by summing the total number of seats in each section.
    public int getTotalTicketNumber() {
        int totalTicketNumber = 0;
        for (Section section : sections) {
            totalTicketNumber += section.getNumRows()*section.getNumSeats();
        }
        return totalTicketNumber;
    }

    // Method to get the available ticket number by summing the available number of seats in each section.
    public int getAvailableTicketNumber() {
        int availableTickets = 0;
        for (Section section : sections) {
            availableTickets += section.getAvailableTicketNumber();
        }
        return availableTickets;
    }

}
