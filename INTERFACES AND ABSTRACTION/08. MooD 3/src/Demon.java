public class Demon extends Character<Integer> implements GameObject<Integer>{

    private static String CHARACTER_TYPE = "Demon";

    public Demon(String username, int level, Double specialPoints) {
        super(username, CHARACTER_TYPE, level, specialPoints);
        this.setHashedPassword(this.getUsername().length() * 217);
    }


    @Override
    public String toString() {
        return String.format("%s%n%s", super.toString(), super.getSpecialPoints().doubleValue() * super.getLevel());
    }
}
