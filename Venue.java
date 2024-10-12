public class Venue {
    private Section[] sections;

    public Venue() {
        Section section1 = new Section(1, 10, 60, 100.0, 50.0);
        Section section2 = new Section(2, 10, 60, 200.0, 100.0);
        Section section3 = new Section(3, 10, 60, 300.0, 150.0);
        Section section4 = new Section(4, 10, 60, 400.0, 200.0);
        this.sections = new Section[]{section1, section2, section3, section4};
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
        return sections;
    }

    public void setSections(Section[] sections) {
        this.sections = sections;
    }
    
    public int getAvailableTickets() {
        int availableTickets = 0;
        for (Section section : sections) {
            for (Ticket ticket : section.getSeats()) {
                if (!ticket.isReserved()) {
                    availableTickets++;
                }
            }
        }
        return availableTickets;
    }

    public Ticket getTicket(int sectionNumber, int rowNumber, int seatNumber) {
        for (Section section : sections) {
            if (section.getSectionNumber() == sectionNumber) {
                return section.getSeat(rowNumber, seatNumber);
            }
        }
        return null;
    }
}
