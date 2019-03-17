public abstract class Character<T> implements GameObject<T> {

    private String username;
    private String characterType;
    private int level;
    private Number specialPoints;
    private T hashedPassword;

    public Character(String username, String characterType, int level, Number specialPoints) {
        this.setUsername(username);
        this.setCharacterType(characterType);
        this.setLevel(level);
        this.setSpecialPoints(specialPoints);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getCharacterType() {
        return this.characterType;
    }

    @Override
    public Number getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public T getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public void setHashedPassword(T password) {
        this.hashedPassword = password;
    }

    private void setUsername(String username){
        this.username = username;
    }


    private void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    private void setSpecialPoints(Number specialPoints) {
        this.specialPoints = specialPoints;
    }

    @Override
    public String toString() {
        return String.format("%s | %s -> %s",
                "\"" + this.getUsername() + "\"",
                "\"" + this.getHashedPassword() + "\"",
                this.getCharacterType());
    }
}
