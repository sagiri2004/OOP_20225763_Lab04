package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    public static int nbDigitalVideoDiscs = 0;

    // Constructor 1
    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, "", 0, 0, "");
    }

    // Constructor 2
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    // Constructor 3
    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, "");
    }

    @Override
    public String getDirector() {
        return super.getDirector();  
    }

    @Override
    public void setDirector(String director) {
        super.setDirector(director); 
    }

    @Override
    public int getLength() {
        return super.getLength();  
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);  
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " mins: " + getCost() + " $";
    }

    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }

    public static int getTotalDVDs() {
        return nbDigitalVideoDiscs;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}