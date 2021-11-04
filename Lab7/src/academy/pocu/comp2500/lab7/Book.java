package academy.pocu.comp2500.lab7;

public final class Book {
    private final String title;
    private final Author author;
    private final int publicationDate;
    private final Genre genre;

    public Book(String title, Author author, int publicationDate, Genre genre) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.genre = genre;
    }

    public String toString() {
        return String.format("%s [%s]", this.title, this.author.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Book) || this.hashCode() != obj.hashCode()) {
            return false;
        }
        Book book = (Book) obj;

        return this.title.equals(book.title) && this.author.equals(book.author) && this.publicationDate == book.publicationDate && this.genre == book.genre;
    }

    public int hashCode() {
        return this.title.hashCode() ^ this.publicationDate ^ this.author.hashCode() + this.genre.hashCode();
    }
}
