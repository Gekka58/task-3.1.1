package web.boot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.boot.model.User;
import web.boot.repository.UserRepository;

import java.util.List;

@Repository
public class DaoUserImp implements DaoUser{

    final UserRepository userRepository;

    @Autowired
     public DaoUserImp(UserRepository userRepository) {
      this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

}