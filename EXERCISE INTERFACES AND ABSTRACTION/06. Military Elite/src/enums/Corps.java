package enums;

public enum Corps {
    Airforces,
    Marines;

    public static boolean isValidCorp(String corp){
        if(!Corps.Airforces.name().equals(corp) && !Corps.Marines.name().equals(corp)){
            return false;
        }
        return true;
    }
}
