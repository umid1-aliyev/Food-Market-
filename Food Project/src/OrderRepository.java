import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void showOrders() {

        if (orders.isEmpty()) {
            System.out.println("No orders.");
            return;
        }

        for (Order order : orders) {
            System.out.println(order);
            System.out.println("-----------------------");
        }
    }
}