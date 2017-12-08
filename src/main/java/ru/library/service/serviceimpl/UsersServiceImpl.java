package ru.library.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.library.dao.daoimpl.UsersDaoImp;
import ru.library.entity.User;
import ru.library.service.Services;


import java.util.List;

@Service
public class UsersServiceImpl implements Services {

    private UsersDaoImp usersDao;
   // @Autowired
   // private PasswordEncoder passwordEncoder;

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

    public boolean usernameExists(Object o) {

        if (usersDao.isExist(o)) {
            return true;
        } else {
            return false;
        }
    }

    /*public User registerNewUserAccount ( final MyUserDto accountDto) throws Exception {
            if (usernameExists(accountDto.getUsername())) {
                throw new Exception("There is an account with that username: " + accountDto.getUsername());
            }
            final User user = new User();

            user.setUsername(accountDto.getUsername());
            user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
            return myUserDAO.save(user);
        }


    }*/

    @Override
    public void insert(Object o) {
        usersDao.insert(o);
    }

    public void delete(Object o) {
        usersDao.delete(o);
    }

    public void update(Object o) {
        usersDao.update(o);
    }
}
