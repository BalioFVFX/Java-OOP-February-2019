import java.lang.instrument.IllegalClassFormatException;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {
        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }

        Ferrari ferrari = new Ferrari("Bat Giorgi");
        Car ferrariCar = new Ferrari("Dinko");

        System.out.println(ferrari.toString());
        System.out.println(ferrariCar.toString());
    }
}
