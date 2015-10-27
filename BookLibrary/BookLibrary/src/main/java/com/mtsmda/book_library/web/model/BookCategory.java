package com.mtsmda.book_library.web.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "book_categories")
public class BookCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_category_id", nullable = false, unique = true)
    private Integer bookCategoryId;

    @Column(name = "book_category_name", nullable = false, unique = true)
    private String bookCategoryName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_category_id", nullable = false)
    private BookSubCategory bookSubCategory;

    public BookCategory() {

    }

    public Integer getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Integer bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public String getBookCategoryName() {
        return bookCategoryName;
    }

    public void setBookCategoryName(String bookCategoryName) {
        this.bookCategoryName = bookCategoryName;
    }

    public BookSubCategory getBookSubCategory() {
        return bookSubCategory;
    }

    public void setBookSubCategory(BookSubCategory bookSubCategory) {
        this.bookSubCategory = bookSubCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookCategory that = (BookCategory) o;

        if (bookCategoryId != null ? !bookCategoryId.equals(that.bookCategoryId) : that.bookCategoryId != null)
            return false;
        if (bookCategoryName != null ? !bookCategoryName.equals(that.bookCategoryName) : that.bookCategoryName != null)
            return false;
        return !(bookSubCategory != null ? !bookSubCategory.equals(that.bookSubCategory) : that.bookSubCategory != null);

    }

    @Override
    public int hashCode() {
        int result = bookCategoryId != null ? bookCategoryId.hashCode() : 0;
        result = 31 * result + (bookCategoryName != null ? bookCategoryName.hashCode() : 0);
        result = 31 * result + (bookSubCategory != null ? bookSubCategory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "bookCategoryId=" + bookCategoryId +
                ", bookCategoryName='" + bookCategoryName + '\'' +
                ", bookSubCategory=" + bookSubCategory +
                '}';
    }
}