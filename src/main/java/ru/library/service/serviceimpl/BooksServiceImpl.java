package ru.library.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.library.dao.daoimpl.BooksDaoImpl;
import ru.library.entity.Book;
import ru.library.service.Services;

import java.util.List;
@Service
public class BooksServiceImpl implements Services {

  private BooksDaoImpl booksDao;
  @Autowired
  public void setBooksDao(BooksDaoImpl booksDao) {
      this.booksDao = booksDao;
  }

    public Book getBooksByIns (int ins) {
        return booksDao.getBooksByIns(ins);
    }

    public List<Book> getBooksByName(String nameBook) {
        return booksDao.getBooksByName(nameBook);
    }

    public List<Book> getBooksByAuthor(String authorBook) {
        return booksDao.getBooksByAuthor(authorBook);
    }

    public List getAll()
    {
        return booksDao.getAll();
    }
    public void insert(Object object) {
        booksDao.insert(object);
    }

    public void delete(Object object) {
        booksDao.delete(object);
    }

    public void update(Object object) {
        booksDao.update(object);
    }




}