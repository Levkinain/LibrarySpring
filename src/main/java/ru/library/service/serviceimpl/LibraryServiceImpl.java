package ru.library.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.library.dao.daoimpl.LibraryDaoImpl;
import ru.library.service.Services;

import java.util.List;

@Service
public class LibraryServiceImpl implements Services {

    private LibraryDaoImpl libraryDao;
    @Autowired
    public void setBooksDao(LibraryDaoImpl libraryDao) {
        this.libraryDao = libraryDao;
    }

    public List getAll(){
       return libraryDao.getAll();
    }

    public void insert(Object o) {
        libraryDao.insert(o);
    }

    public void delete(Object o) {
        libraryDao.delete(o);
    }

    public void update(Object o) {

        libraryDao.update(o);
    }
}
