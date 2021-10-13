package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookDTO> getBooksData() {
        List<BookDTO> books = jdbcTemplate.query("SELECT b.*, a.first_name || ' ' || a.last_name as name " +
                                                     "FROM books AS b " +
                                                     "JOIN authors AS a " +
                                                     "ON b.authorId = a.id", (ResultSet rs, int rowNum) -> {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setAuthor(rs.getString("name"));
            bookDTO.setTitle(rs.getString("title"));
            bookDTO.setPriceOld(rs.getString("priceOld"));
            bookDTO.setPrice(rs.getString("price"));
            return bookDTO;
        });
        return new ArrayList<>(books);
    }

    public List<BookDTO> getFilteredBooksData(String parameter) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("parameter", "%" + parameter + "%");
        List<BookDTO> books = jdbcTemplate.query("SELECT b.*, a.first_name || ' ' || a.last_name as name " +
                "FROM books AS b " +
                "JOIN authors AS a " +
                "ON b.authorId = a.id " +
                "WHERE b.title LIKE :parameter OR a.first_name LIKE :parameter OR a.last_name LIKE :parameter",
                parameterSource,
                (ResultSet rs, int rowNum) -> {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setAuthor(rs.getString("name"));
            bookDTO.setTitle(rs.getString("title"));
            bookDTO.setPriceOld(rs.getString("priceOld"));
            bookDTO.setPrice(rs.getString("price"));
            return bookDTO;
        });
        return new ArrayList<>(books);
    }
}
