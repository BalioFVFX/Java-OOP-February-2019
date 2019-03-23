package p02_identity.interfaces;

public interface User {
    String getEmail();
    String getPasswordHash();
    String getPassword();
    void setPassword(String password);
    void setPasswordHash(String hashPassword);
}
