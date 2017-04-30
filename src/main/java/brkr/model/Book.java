package brkr.model;

public class Book {

    private String author;
    private String title;
    private int chapter;

    public Book(String author, String title) {
        this(author, title, 1);
    }

    public Book(String author, String title, int chapter) {
        this.author = author;
        this.title = title;
        this.chapter = chapter;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getChapter() {
        return chapter;
    }
}
