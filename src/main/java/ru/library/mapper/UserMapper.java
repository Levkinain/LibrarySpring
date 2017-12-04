package ru.library.mapper;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import ru.library.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>{
    private final static Logger logger = Logger.getLogger(UserMapper.class);

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(resultSet.getString(User.LOGIN), resultSet.getString(User.PASSWORD));
        return user;
    }
}