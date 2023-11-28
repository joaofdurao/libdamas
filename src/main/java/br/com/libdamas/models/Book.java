package br.com.libdamas.models;

public class Book {
    private long id;
    private char title;
    private char author;
    private char year;
    private char genre;
    private boolean available;
    private User currentOwner;

    public Book() {
    }

    public Book(long id, char title, char author, char year, char genre, boolean available, User currentOwner) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.available = available;
        this.currentOwner = currentOwner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getTitle() {
        return title;
    }

    public void setTitle(char title) {
        this.title = title;
    }

    public char getAuthor() {
        return author;
    }

    public void setAuthor(char author) {
        this.author = author;
    }

    public char getYear() {
        return year;
    }

    public void setYear(char year) {
        this.year = year;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(User currentOwner) {
        this.currentOwner = currentOwner;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", genre=" + genre
                + ", available=" + available + ", currentOwner=" + currentOwner + "]";
    }

}
