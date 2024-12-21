package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Disc extends Media {
    private int length;       // Độ dài của đĩa (số phút)
    private String director;  // Đạo diễn của đĩa

    // Constructor của lớp Disc
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);  // Gọi constructor của lớp Media
        this.length = length;
        this.director = director;
    }

    // Getter và Setter cho biến length (Độ dài)
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Getter và Setter cho biến director (Đạo diễn)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Phương thức toString để trả về thông tin của Disc
    @Override
    public String toString() {
        return "Disc [Title=" + getTitle() + ", Category=" + getCategory() + ", Director=" + director + ", Length=" + length + " minutes, Cost=" + getCost() + " $]";
    }

    // Phương thức play để mô phỏng việc phát đĩa
    @Override
    public void play() throws PlayerException {
        if (length <= 0) {
            throw new PlayerException("Invalid Disc length.");
        }
        System.out.println("Playing Disc: " + getTitle());
        System.out.println("Director: " + director);
        System.out.println("Length: " + length + " minutes");
    }
}
