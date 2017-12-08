package ru.library.dao.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.library.dao.Dao;
import ru.library.entity.Book;
import ru.library.entity.Library;
import ru.library.entity.User;
import ru.library.mapper.LibraryMapper;

import java.util.List;

@Repository
public class LibraryDaoImpl implements Dao {
    private final JdbcTemplate jdbcTemplate;

    public static final String SQL_BOOK_INSERT = INSERT_INTO + Library.TABLE_NAME + OPEN_BRACKET +  Library.BOOK +COMMA + Library.USER + CLOSE_BRACKET +  VALUES + LIST_PARAM2;
    public static final String SQL_BOOK_DELETE = DELETE_FROM + Library.TABLE_NAME + WHERE + Library.BOOK + PARAM;
    public static final String SQL_BOOK_UPDATE = UPDATE  + Library.TABLE_NAME + SET + Library.BOOK + PARAM + COMMA + Library.USER +  PARAM  +  WHERE + Library.BOOK + PARAM;

   // public static final String SQL_LIBRARY_SELECT_ALL = SELECT + Book.INS + COMMA + Book.NAME_BOOK + COMMA + Book.AUTHOR_BOOK + COMMA + User.LOGIN + COMMA +  User.PASSWORD + COMMA + Library.ID +
   public static final String SQL_LIBRARY_SELECT_ALL = SELECT_ALL_FROM + Book.TABLE_NAME + LEFT_JOIN +
                    Library.TABLE_NAME + O_N + Library.TABLE_NAME + DOT + Library.BOOK + IS + Book.TABLE_NAME + DOT + Book.INS +
            LEFT_JOIN + User.TABLE_NAME + O_N + Library.TABLE_NAME + DOT + Library.USER + IS + User.TABLE_NAME + DOT +  User.LOGIN +
            ORDER_BY + Book.TABLE_NAME+DOT+Book.AUTHOR_BOOK;

    @Autowired
    public LibraryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Library> getAll(){
      return  jdbcTemplate.query(SQL_LIBRARY_SELECT_ALL,new LibraryMapper());
    }
    public void insert(Object o) {
        Library library = (Library)o;
        jdbcTemplate.update(SQL_BOOK_INSERT,library.getUser().getLogin(),library.getBook().getINS());
    }

    public void delete(Object o) {
        Library library = (Library)o;
        jdbcTemplate.update(SQL_BOOK_DELETE,library.getBook().getINS());
    }

    public void update(Object o) {
        Library library = (Library)o;
        jdbcTemplate.update(SQL_BOOK_UPDATE,library.getBook().getINS());
    }
}


