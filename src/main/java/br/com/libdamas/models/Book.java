package br.com.libdamas.models;

public class Book {
    private long id;
    private char title;
    private char author;
    private char year;
    private char genre;
    private boolean avaible;
    private User currentOwner;

    public Book(long id, char title, char author, char year, char genre, boolean avaible, User currentOwner) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.avaible = avaible;
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

    public boolean isAvaible() {
        return avaible;
    }

    public void setAvaible(boolean avaible) {
        this.avaible = avaible;
    }

    public User getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(User currentOwner) {
        this.currentOwner = currentOwner;
    }

}
