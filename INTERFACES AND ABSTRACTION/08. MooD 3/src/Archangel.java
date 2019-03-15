public class Archangel extends Character<String> implements GameObject<String>{
    private static String CHARACTER_TYPE = "Archangel";

    public Archangel(String username, int level, Integer specialPoints) {
        super(username, CHARACTER_TYPE, level, specialPoints);
        this.setHashedPassword(generatePassword());
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", super.toString(), super.getSpecialPoints().intValue() * super.getLevel());
    }


    private String generatePassword(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = stringBuilder.append(super.getUsername());
        stringBuilder = stringBuilder.reverse();
        stringBuilder = stringBuilder.append(super.getUsername().length() * 21);

        return stringBuilder.toString();
    }


}
