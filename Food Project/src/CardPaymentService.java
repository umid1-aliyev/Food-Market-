public class CardPaymentService implements PaymentService {

    @Override
    public boolean pay(User user, double amount) {

        if(user.getBalance() >= amount){

            user.withdraw(amount);

            return true;
        }

        return false;
    }
}