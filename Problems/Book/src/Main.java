import java.util.Arrays;

class Book {
    final String title;
    final int yearOfPublishing;
    final String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = Arrays.copyOf(authors, authors.length);
    }
}