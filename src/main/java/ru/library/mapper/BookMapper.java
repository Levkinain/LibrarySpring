package ru.library.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.library.entity.Book;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book(resultSet.getInt(Book.INS), resultSet.getString(Book.NAME_BOOK), resultSet.getString(Book.AUTHOR_BOOK));
        return book;
    }
}
