package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(User user);
    void remove(Long id);
    User getUserById(Long id);
    List<User> listUsers();
}