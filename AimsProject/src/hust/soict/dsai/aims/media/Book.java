package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Tác giả đã tồn tại trong danh sách.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Tác giả không tồn tại trong danh sách.");
        }
    }

    @Override
    public String toString() {
        return "Book [id=" + getId() + ", title=" + getTitle() + ", category=" + getCategory() + ", cost=" + getCost() + ", authors=" + authors + "]";
    }
}
