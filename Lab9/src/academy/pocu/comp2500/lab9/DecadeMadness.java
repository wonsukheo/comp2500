package academy.pocu.comp2500.lab9;

import java.util.Collection;
import java.util.HashMap;

public class DecadeMadness implements IEvent {
    public DecadeMadness() {
    }

    public int getTotalPrice(Collection<Book> books) {
        double sum = 0;
        HashMap<String, Integer> decade = new HashMap<>();

        for (Book book : books) {
            String pYear = Integer.toString(book.getPublishedYear());
            pYear = pYear.substring(0, 3);

            if (decade.containsKey(pYear)) {
                decade.replace(pYear, decade.get(pYear) + 1);
            } else {
                decade.put(pYear, 1);
            }
        }

        for (Book book : books) {
            String pYear = Integer.toString(book.getPublishedYear());
            pYear = pYear.substring(0, 3);

            if (decade.get(pYear) > 1) {
                sum += book.getPrice() * 0.8f;
            } else {
                sum += book.getPrice();
            }
        }

        return (int) sum;
    }
}
