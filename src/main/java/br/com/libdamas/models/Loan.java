package br.com.libdamas.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "LOANS_TB")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date loanDate;

    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @Column
    @Convert(converter = org.hibernate.type.YesNoConverter.class)
    private boolean closed;

    @Column
    @Convert(converter = org.hibernate.type.YesNoConverter.class)
    private boolean overdue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_User_id")
    private User user;

    public Loan() {
    }

    public Loan(Long id, Date loanDate, Date returnDate, boolean closed, boolean overdue, User user) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.closed = closed;
        this.overdue = overdue;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Loan [id=" + id + ", loanDate=" + loanDate + ", returnDate=" + returnDate + ", closed=" + closed
                + ", overdue=" + overdue + ", user=" + user + "]";
    }

}
