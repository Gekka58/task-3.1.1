package web.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.boot.dao.DaoUser;
import web.boot.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MyServiceImp implements MyService {
    final DaoUser daoUser;
@Autowired
    public MyServiceImp(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return daoUser.findAll();
    }

    @Override
    @Transactional
    public User findById(int id) {
        return daoUser.findById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        daoUser.updateUser(user);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        daoUser.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        daoUser.deleteById(id);
    }

}