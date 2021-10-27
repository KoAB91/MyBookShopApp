package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBookByAuthor_FirstName(String name);

    @Query("from Book where title like :parameter or author.firstName like :parameter or author.lastName like :parameter")
    List<Book> findBookByParameter(String parameter);

    @Query("from Book")
    List<Book> customFindAllBooks();
}
