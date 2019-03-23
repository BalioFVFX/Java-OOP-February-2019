package p02_identity;

import p02_identity.interfaces.Database;
import p02_identity.interfaces.User;


import java.util.ArrayList;
import java.util.List;

public class Repository implements Database {

    List<User> users;

    public Repository() {
        this.users = new ArrayList<>();
    }

    @Override
    public User register(String username, String password) {
        User userImpl = new UserImpl(username, password);
        users.add(userImpl);
        return userImpl;
    }

    @Override
    public User login(String username, String password) {
        return this.users.stream().filter(u -> u.getEmail().equals(username) && u.getPassword().equals(password)).findFirst().orElse(null);
    }

    @Override
    public Iterable<User> getAllUsersOnline() {
        return users;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserByName(String name) {
        return users.stream().filter(u -> u.getEmail().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void updatePassword(User user) {
        users.stream().filter(u -> u.getEmail().equals(user.getEmail())).findFirst().orElse(null).setPassword(user.getPassword());
    }
}
