package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    User showUserByID(int id);

    void deleteUserById(long id);

    void addUser(User user);

    void editUser(User user);


    User getUserById(long id);
}



    