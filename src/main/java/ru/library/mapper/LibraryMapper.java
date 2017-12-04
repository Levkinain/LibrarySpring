package ru.library.mapper;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import ru.library.entity.Book;
import ru.library.entity.Library;
import ru.library.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class LibraryMapper implements RowMapper<Library>
    {
        private static final Logger logger = Logger.getLogger(LibraryMapper.class);
    public Library mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book(resultSet.getInt(Book.INS), resultSet.getString(Book.NAME_BOOK), resultSet.getString(Book.AUTHOR_BOOK));
        User user = new User(resultSet.getString(User.LOGIN), resultSet.getString(User.PASSWORD));
        Library library = new Library(book,user,resultSet.getInt(Library.ID));
        logger.info(user.toString() +" " + book.toString());
        return library;
    }
}
