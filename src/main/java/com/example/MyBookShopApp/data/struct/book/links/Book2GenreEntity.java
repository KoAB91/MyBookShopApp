package com.example.MyBookShopApp.data.struct.book.links;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.struct.genre.GenreEntity;

import javax.persistence.*;

@Entity
@Table(name = "book2genre")
public class Book2GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", columnDefinition = "INT NOT NULL")
    private Book book;

    @OneToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", columnDefinition = "INT NOT NULL")
    private GenreEntity genre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }
}
