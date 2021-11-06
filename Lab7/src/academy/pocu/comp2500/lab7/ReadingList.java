package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public final class ReadingList {
    private final String name;
    private ArrayList<Book> bookList = new ArrayList<>();

    public ReadingList(String name) {
        this.name = name;
    }

    public void add(Book book) {
        bookList.add(book);
    }

    public boolean remove(Book book) {
        return bookList.remove(book);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        int i = 1;

        for (Book book : bookList) {
            sb.append(String.format("%d. %s%s", i++, book.toString(), System.lineSeparator()));
        }

        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Book) || this.hashCode() != obj.hashCode()) {
            return false;
        }

        ReadingList readingList = (ReadingList) obj;

        if (!(this.name.equals(readingList.name)) || this.bookList.size() != readingList.bookList.size()) {
            return false;
        }

        int i = 0;

        for (Book book : this.bookList) {
            if (!(book.equals(readingList.bookList.get(i++)))) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        int hash = 0;

        int i = 0;

        for (Book book : this.bookList) {
            hash = hash * 31 + book.hashCode() * i++;
        }

        return hash + this.name.hashCode();
    }
}
