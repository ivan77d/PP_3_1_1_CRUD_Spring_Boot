package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDao.userList();
    }

    @Override
    @Transactional
    public User userById(int id) {
        return userDao.userById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
userDao.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User updateUser) {
userDao.update(updateUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
userDao.delete(id);
    }
}
