package br.com.libdamas.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKS_TB")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;

    @Column(length = 100)
    private String author;

    @Column(length = 4)
    private String year;

    @Column(length = 100)
    private String genre;

    @Column
    @Convert(converter = org.hibernate.type.YesNoConverter.class)
    private boolean available;

    @ManyToMany(mappedBy = "books")
    private List<Loan> loans;

    public Book() {
    }

    public Book(Long id, String title, String author, String year, String genre, boolean available, List<Loan> loans) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.available = available;
        this.loans = loans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Loan> getLoan() {
        return loans;
    }

    public void setLoan(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", genre=" + genre
                + ", available=" + available + ", loans=" + loans + "]";
    }

}
