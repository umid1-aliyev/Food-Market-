public class NoDiscountService implements DiscountService {

    @Override
    public double applyDiscount(double price) {
        return price;
    }

}