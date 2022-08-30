package web.boot.service;

import web.boot.model.User;

import java.util.List;

public interface MyService {

    List<User> findAll();

    User findById(int id);

    void updateUser(User user);

    void saveUser(User user);

    void deleteById(int id);
}
