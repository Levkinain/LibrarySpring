package ru.library.dao;

import java.util.List;

public interface Dao<T> {

    public static final String  SELECT  = "SELECT ";
    public static final String FROM = " FROM ";
    public static final String SELECT_ALL_FROM = "SELECT * FROM ";
    public static final String  WHERE  = " WHERE ";

    public static final String  O_N  = " ON ";


    public static final String INSERT_INTO = "INSERT INTO ";
    public static final String UPDATE = "UPDATE ";
    public static final String DELETE_FROM = "DELETE FROM ";


    public static final String VALUES = " VALUES";
    public static final String SET =" SET ";

    public static final String ORDER_BY =  " ORDER BY ";
    public static final String DESC = " DESC ";

    public static final String COMMA = ", ";
    public static final String OPEN_BRACKET = " (";
    public static final String CLOSE_BRACKET = ") ";

    public static final String PARAM = " = ?";
    public static final String LIST_PARAM2 = "(?, ?)";
    public static final String LIST_PARAM3 = "(?, ?, ?)";
    public static final String IS = " = ";
    public static final String DOT = ".";

    public static final String LEFT_JOIN = " LEFT JOIN ";


    public void insert(T t);
    public void delete(T t);
    public void update(T t);
    public List<T> getAll();

}




