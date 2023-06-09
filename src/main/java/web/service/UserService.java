package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User showUserByID(int id);

    void deleteUserById(int id);

    void addUser(User user);

    void editUser(User user);
}