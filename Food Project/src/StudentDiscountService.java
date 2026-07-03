public class StudentDiscountService implements DiscountService {

    @Override
    public double applyDiscount(double price) {

        return price * 0.90;

    }

}