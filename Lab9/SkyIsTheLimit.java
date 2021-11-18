package academy.pocu.comp2500.lab9;

import java.util.Collection;

public class SkyIsTheLimit implements IEvent {
    private int priceCut;

    public SkyIsTheLimit(int priceCut) {
        this.priceCut = priceCut;
    }

    public int getTotalPrice(Collection<Book> books) {
        int sum = 0;
        int most = 0;
        int secondMost = 0;

        for (Book book : books) {
            int price = book.getPrice();

            if (price >= most) {
                most = price;
            } else if (price >= secondMost) {
                secondMost = price;
            }

            sum += price;
        }

        if (sum < priceCut || books.size() < 5) {
            return sum;
        }

        double result = sum - (most + secondMost) / 2.0;

        return (int) result;
    }
}
