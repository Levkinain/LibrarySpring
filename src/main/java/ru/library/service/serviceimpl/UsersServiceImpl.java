package ru.library.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.library.dao.daoimpl.UsersDaoImp;
import ru.library.entity.User;
import ru.library.service.Services;


import java.util.List;

@Service
public class UsersServiceImpl implements Services {

    private UsersDaoImp usersDao;

    @Autowired
    public void setUserDao(UsersDaoImp usersDao) {
        this.usersDao = usersDao;
    }

    public List<User> getAll() {
        return usersDao.getAll();
    }

    public User findUserByLogin(String login) {
        return usersDao.findUserByLogin(login);
    }

    public boolean insert(Object o) {

        if (!usersDao.isExist(o)) {
            usersDao.insert(o);
            return true;
        } else {
            return false;
        }
    }

    public void delete(Object o) {
        usersDao.delete(o);
    }

    public void update(Object o) {
        usersDao.update(o);
    }
}
