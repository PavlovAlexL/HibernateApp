package dao;

import models.Auto;
import models.User;

import java.util.List;

public interface UserDao {

    void save(User user);
    void update(User user);
    void delete(User user);
    User findById(int id);
    Auto findAutoById(int id);
    List<User> findAll();

}
