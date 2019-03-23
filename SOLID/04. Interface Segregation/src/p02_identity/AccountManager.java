package p02_identity;

import p02_identity.interfaces.Account;
import p02_identity.interfaces.Database;
import p02_identity.interfaces.User;

public class AccountManager implements Account {
    private static final boolean requireUniqueEmail = true;
    private static final int minRequiredPasswordLength = 4;
    private static final int maxRequiredPasswordLength = 12;
    private final Database database;



    public AccountManager(Database database) {
        this.database = database;
    }

    @Override
    public boolean getRequireUniqueEmail() {
        return this.requireUniqueEmail;
    }

    @Override
    public int getMinRequiredPasswordLength() {
        return this.minRequiredPasswordLength;
    }

    @Override
    public int getMaxRequiredPasswordLength() {
        return this.maxRequiredPasswordLength;
    }

    @Override
    public void changePassword(p02_identity.interfaces.User user) {
        if(!isValidPassword(user.getPassword())){
            return;
        }

        this.database.updatePassword(user);
    }

    public User register(String username, String password) {
        if(!isValidPassword(password)){
            return null;
        }
        return this.database.register(username, password);
    }

    public User login(String username, String password){
        return this.database.login(username, password);
    }

    public Iterable<User> getAllUsers(){
        return this.database.getAllUsers();
    }

    public Iterable<User> getOnlineUsers(){
        return this.database.getAllUsersOnline();
    }

    private boolean isValidPassword(String password){
        if (password.length() < getMinRequiredPasswordLength() || password.length() > getMaxRequiredPasswordLength()) {
            return false;
        }

        return true;
    }
}
