import java.util.ArrayList;
import java.util.List;

public class User {

    private double balance;
    private List<Food> inventory;
    private List<Order> orders;

    public User(double balance) {
        this.balance = balance;
        this.inventory = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public List<Food> getInventory() {
        return inventory;
    }

    public void addFood(Food food) {
        inventory.add(food);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}