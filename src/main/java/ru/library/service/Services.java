package ru.library.service;

import java.util.List;

public interface Services <T> {
    public void insert(T t);
    public void delete(T t);
    public void update(T t);
    public List<T> getAll();
}
