package com.lls.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books", schema = "hibernate", catalog = "")
public class BooksEntity {
    private int bookId;
    private String bookName;
    private int bookCounts;
    private String detail;
    private String creator;

    @Id
    @Column(name = "bookID", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "bookName", nullable = false, length = 100)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "bookCounts", nullable = false)
    public int getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(int bookCounts) {
        this.bookCounts = bookCounts;
    }

    @Basic
    @Column(name = "detail", nullable = false, length = 255)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "creator", nullable = true, length = 255)
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooksEntity that = (BooksEntity) o;
        return bookId == that.bookId && bookCounts == that.bookCounts && Objects.equals(bookName, that.bookName) && Objects.equals(detail, that.detail) && Objects.equals(creator, that.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, bookCounts, detail, creator);
    }
}
