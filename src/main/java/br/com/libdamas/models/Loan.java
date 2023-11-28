package br.com.libdamas.models;

import java.util.List;
import java.util.Date;

public class Loan {
    private long id;
    private User ownerUser;
    private Book borrowedBook;
    private List<Book> userBooks;
    private Date loanDate;
    private Date returnDate;
    private boolean closed;
    private boolean overdue;

    public Loan() {
    }

    public Loan(long id, User ownerUser, Book borrowedBook, List<Book> userBooks, Date loanDate, Date returnDate,
            boolean closed, boolean overdue) {
        this.id = id;
        this.ownerUser = ownerUser;
        this.borrowedBook = borrowedBook;
        this.userBooks = userBooks;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.closed = closed;
        this.overdue = overdue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(User ownerUser) {
        this.ownerUser = ownerUser;
    }

    public Book getBorrowenBook() {
        return borrowedBook;
    }

    public void setBorrowenBook(Book borrowenBook) {
        this.borrowedBook = borrowenBook;
    }

    public List<Book> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<Book> userBooks) {
        this.userBooks = userBooks;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    @Override
    public String toString() {
        return "Loan [id=" + id + ", ownerUser=" + ownerUser + ", borrowedBook=" + borrowedBook + ", userBooks="
                + userBooks + ", loanDate=" + loanDate + ", returnDate=" + returnDate + ", closed=" + closed
                + ", overdue=" + overdue + "]";
    }

}
