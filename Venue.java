public class Venue {
    private Section[] sections;

    public Venue() {
        this.sections = new Section[0];
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

}
