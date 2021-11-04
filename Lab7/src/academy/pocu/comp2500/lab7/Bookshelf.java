package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public final class Bookshelf {
    private final int maxBookCount;
    private ArrayList<Book> books = new ArrayList<>();

    public Bookshelf(int maxBookCount) {
        this.maxBookCount = maxBookCount;
    }

    public boolean add(Book book) {
        if (book == null) {
            return false;
        }

        books.add(book);

        return true;
    }

    public boolean remove(Book book) {
        if (book == null || !books.contains(book)) {
            return false;
        }

        return books.remove(book);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Book) || this.hashCode() != obj.hashCode()) {
            return false;
        }

        Bookshelf bookShelf = (Bookshelf) obj;

        if (this.maxBookCount != bookShelf.maxBookCount || this.books.size() != bookShelf.books.size()) {
            return false;
        }

        for (Book book : this.books) {
            int i = 0;
            if (!(book.equals(bookShelf.books.get(i++)))) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        int hash = 0;

        for (Book book : books) {
            hash += hash * 31 + book.hashCode();
        }

        return hash + this.books.size();
    }
}
