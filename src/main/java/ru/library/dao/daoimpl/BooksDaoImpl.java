package ru.library.dao.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.library.dao.Dao;
import ru.library.entity.Book;
import ru.library.mapper.BookMapper;

import java.util.List;

@Repository
public class BooksDaoImpl implements Dao {

    public final JdbcTemplate jdbcTemplate;

    //public static final String SQL_FIND_ALL_BOOKS_ORDER_BY_AUTHOR = SELECT_ALL_FROM + Book.TABLE_NAME + ORDER_BY + Book.AUTHOR_BOOK ;
   // public static final String SQL_FIND_ALL_BOOKS_ORDER_BY_NAME = SELECT_ALL_FROM + Book.TABLE_NAME + ORDER_BY + Book.NAME_BOOK ;

    public static final String SQL_FIND_BOOKS = SELECT_ALL_FROM + Book.TABLE_NAME;

    public static final String SQL_FIND_BOOKS_BY_INS = SELECT_ALL_FROM + Book.TABLE_NAME + WHERE + Book.INS + PARAM;
    public static final String SQL_FIND_BOOKS_BY_NAME = SELECT_ALL_FROM + Book.TABLE_NAME + WHERE + Book.NAME_BOOK + PARAM;
    public static final String SQL_FIND_BOOKS_BY_AUTHOR = SELECT_ALL_FROM + Book.TABLE_NAME + WHERE + Book.AUTHOR_BOOK + PARAM;

    public static final String SQL_BOOK_INSERT = INSERT_INTO + Book.TABLE_NAME + OPEN_BRACKET +  Book.INS  + COMMA + Book.AUTHOR_BOOK  + COMMA + Book.NAME_BOOK + CLOSE_BRACKET +  VALUES + LIST_PARAM3;
    public static final String SQL_BOOK_DELETE = DELETE_FROM + Book.TABLE_NAME + WHERE + Book.INS + PARAM;
    public static final String SQL_BOOK_UPDATE = UPDATE  + Book.TABLE_NAME + SET + Book.INS + PARAM + COMMA + Book.AUTHOR_BOOK +  PARAM + COMMA + Book.NAME_BOOK  +  PARAM +  WHERE + Book.INS + PARAM;

    @Autowired
    public BooksDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book getBooksByIns(int ins) {
        return jdbcTemplate.queryForObject(SQL_FIND_BOOKS_BY_INS, new BookMapper(), ins);
    }

    public List<Book> getBooksByName(String nameBook) {
        return jdbcTemplate.query(SQL_FIND_BOOKS_BY_NAME, new BookMapper(), nameBook);
    }

    public List<Book> getBooksByAuthor(String authorBook) {
        return jdbcTemplate.query(SQL_FIND_BOOKS_BY_AUTHOR, new BookMapper(), authorBook);
    }

    public List getAll() {
        return jdbcTemplate.query(SQL_FIND_BOOKS, new BookMapper());
    }

    public void update(Object object) {
        Book book = (Book)object;
        jdbcTemplate.update(SQL_BOOK_UPDATE,book.getINS(),book.getAuthorBook(),book.getNameBook());
    }

    public void insert(Object object) {
        Book book = (Book)object;
        jdbcTemplate.update(SQL_BOOK_INSERT,book.getINS(),book.getAuthorBook(),book.getNameBook());
    }

    public void delete(Object object) {
        Book book = (Book)object;
        jdbcTemplate.update(SQL_BOOK_DELETE,book.getINS());

    }

}
