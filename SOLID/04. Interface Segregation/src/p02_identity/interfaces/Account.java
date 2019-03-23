package p02_identity.interfaces;

public interface Account {
    boolean getRequireUniqueEmail();
    int getMinRequiredPasswordLength();
    int getMaxRequiredPasswordLength();
    void changePassword(User user);

}
