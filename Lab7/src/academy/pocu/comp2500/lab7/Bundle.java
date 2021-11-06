package academy.pocu.comp2500.lab7;

import java.util.HashMap;

public final class Bundle {
    private final String name;
    private HashMap<Book, Integer> bookSet = new HashMap<>();
    private int count;

    public Bundle(String name) {
        this.name = name;
        count = 0;
    }

    public boolean add(Book book) {
        if (book == null || count == 4) {
            return false;
        }

        if (bookSet.containsKey(book)) {
            bookSet.put(book, bookSet.get(book) + 1);
        } else {
            bookSet.put(book, 1);
        }

        count++;
        return true;
    }

    public boolean remove(Book book) {
        if (book == null || !(bookSet.containsKey(book))) {
            return false;
        }

        if (bookSet.get(book) == 1) {
            bookSet.remove(book);
        } else {
            bookSet.put(book, bookSet.get(book) - 1);
        }

        count--;
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Bundle) || this.hashCode() != obj.hashCode()) {
            return false;
        }

        Bundle bundle = (Bundle) obj;

        if (!(this.name.equals(bundle.name)) && this.bookSet.size() != bundle.bookSet.size()) {
            return false;
        }

        for (Book book : this.bookSet.keySet()) {
            if (this.bookSet.get(book) != bundle.bookSet.get(book)) {
                return false;
            }
        }

        return true;
    }


    public int hashCode() {
        int hash = 0;

        int i = 0;

        for (Book book : this.bookSet.keySet()) {
            hash = hash * 31 + book.hashCode() * i++;
        }

        return hash + this.name.hashCode();
    }
}
