package src.ticketbooking;
import java.util.Random;

public class Venue {
    private Section[] sections = new Section[4];

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

    public Venue(Venue venue) {
        this.sections = new Section[venue.sections.length];
        for (int i = 0; i < venue.sections.length; i++) {
            this.sections[i] = new Section(venue.sections[i]);
        }
    }

    // Bu kisim dusunulebilir.
    public Venue(Section[] sections) {
        this.sections = sections;
    }

    public Section[] getSections() {
        Section[] temp = new Section[sections.length];

        for (int i = 0; i < sections.length; i++) {
            temp[i] = new Section(sections[i]);
        }
        return temp;
    }

    public void setSections(Section[] sections) {
        this.sections = sections;
    }
    
    public int getTotalTicketNumber() {
        int totalTicketNumber = 0;
        for (Section section : sections) {
            totalTicketNumber += section.getNumRows()*section.getNumSeats();
        }

        return totalTicketNumber;
    }

    public int getAvailableTicketNumber() {
        int availableTickets = 0;
        for (Section section : sections) {
            availableTickets += section.getAvailableTicketNumber();
        }
        return availableTickets;
    }

}
