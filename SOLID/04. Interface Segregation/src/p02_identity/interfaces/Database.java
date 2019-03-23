package p02_identity.interfaces;

public interface Database {

    User register(String username, String password);
    User login(String username, String password);
    Iterable<User> getAllUsersOnline();
    Iterable<User> getAllUsers();
    User getUserByName(String name);
    void updatePassword(User user);
}
