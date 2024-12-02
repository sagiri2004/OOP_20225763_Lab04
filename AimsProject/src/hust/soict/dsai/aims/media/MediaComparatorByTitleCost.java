package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        return titleComparison != 0 ? titleComparison : Float.compare(m2.getCost(), m1.getCost());
    }
}

