package academy.pocu.comp2500.lab7;

import java.util.HashSet;

public final class Bundle {
    private final String name;
    private HashSet<Book> bookSet = new HashSet<>();

    public Bundle(String name) {
        this.name = name;
    }

    public boolean add(Book book) {
        if (book == null) {
            return false;
        }

        return this.bookSet.add(book);
    }

    public boolean remove(Book book) {
        if (book == null || !bookSet.contains(book)) {
            return false;
        }

        return bookSet.remove(book);
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

        return this.bookSet.containsAll(bundle.bookSet);
    }


    public int hashCode() {
        int hash = 0;

        int i = 0;

        for (Book book : this.bookSet) {
            hash = hash * 31 + book.hashCode() * i++;
        }

        return hash + this.name.hashCode();
    }
}
