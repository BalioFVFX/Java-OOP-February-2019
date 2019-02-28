import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] reservationArguments = bufferedReader.readLine().split("\\s+");

        double pricePerDay = Double.parseDouble(reservationArguments[0]);
        int numberOfDays = Integer.parseInt(reservationArguments[1]);
        Season season = Season.valueOf(reservationArguments[2]);
        DiscountType discountType = DiscountType.valueOf(reservationArguments[3]);
        Reservation reservation = new Reservation(pricePerDay, numberOfDays, season, discountType);

        System.out.printf("%.2f%n", PriceCalculator.calculate(reservation));
    }
}
