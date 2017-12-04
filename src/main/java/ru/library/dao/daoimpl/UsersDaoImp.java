package ru.library.dao.daoimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.library.dao.Dao;

import ru.library.entity.User;
import ru.library.mapper.UserMapper;

import java.util.List;

@Repository
public class UsersDaoImp implements Dao {
    private static final Logger logger = Logger.getLogger(UsersDaoImp.class);

    public final JdbcTemplate jdbcTemplate;
    public static final String SQL_FIND_ALL_USERS_ASC = SELECT_ALL_FROM + User.TABLE_NAME + ORDER_BY + User.LOGIN;
    public static final String SQL_FIND_USERS_BY_LOGIN = SELECT_ALL_FROM + User.TABLE_NAME + WHERE + User.LOGIN + PARAM;
    public static final String USER_SQL_INSERT = INSERT_INTO + User.TABLE_NAME + OPEN_BRACKET + User.LOGIN + COMMA + User.PASSWORD + CLOSE_BRACKET + VALUES + LIST_PARAM2;
    public static final String USER_SQL_DELETE = DELETE_FROM + User.TABLE_NAME + WHERE + User.LOGIN + PARAM;
    public static final String SQL_BOOK_UPDATE = UPDATE + User.TABLE_NAME + SET + User.LOGIN + PARAM + COMMA + User.PASSWORD + PARAM + WHERE + User.LOGIN + PARAM;


    @Autowired
    public UsersDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAll() {

        return jdbcTemplate.query(SQL_FIND_ALL_USERS_ASC, new UserMapper());
    }

    public User findUserByLogin(String login) {

            return  jdbcTemplate.queryForObject(SQL_FIND_USERS_BY_LOGIN, new UserMapper(),login);
    }

    public boolean isExist(Object o) {
        User user = (User) o;
        findUserByLogin(user.getLogin());
        return true;
    }


    public void insert(Object o) {
        User user = (User) o;
        jdbcTemplate.update(USER_SQL_INSERT, user.getLogin(), user.getPassword());

    }

    public void delete(Object o) {
        User user = (User) o;
        jdbcTemplate.update(USER_SQL_DELETE, user.getLogin());
    }

    public void update(Object o) {
        User user = (User) o;
        jdbcTemplate.update(SQL_BOOK_UPDATE, user.getLogin());

    }
}
