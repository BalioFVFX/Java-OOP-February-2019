public class PriceCalculator {
    public static double calculate(Reservation reservation) {
        double price = reservation.getPricePerDay() * reservation.getSeason().getValue();
        price *= reservation.getNumberOfDays();

        price = reservation.getDiscountType().calculateDiscount(price);

        return price;
    }
}
