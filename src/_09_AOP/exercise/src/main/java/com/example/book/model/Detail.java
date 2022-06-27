package com.example.book.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Detail {
    @Id
    private String borrowCode;

    @ManyToOne
    @JoinColumn(name = "book_name", referencedColumnName = "id")
    private Book book;

    public Detail(String borrowCode, Book book) {
        this.borrowCode = borrowCode;
        this.book = book;
    }

    public Detail() {
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
