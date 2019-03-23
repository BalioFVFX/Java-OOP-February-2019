package p02_identity;

public class UserImpl implements p02_identity.interfaces.User {

    private String email;
    private String password;
    private String passwordHash;

    public UserImpl(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPasswordHash() {
        return this.passwordHash;
    }

    public String getPassword(){
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
