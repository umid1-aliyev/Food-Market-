import java.time.LocalDateTime;

public class Order {

    private Food food;
    private double price;
    private LocalDateTime orderTime;
    private OrderStatus status;

    public Order(Food food) {
        this.food = food;
        this.price = food.getPrice();
        this.orderTime = LocalDateTime.now();
        this.status = OrderStatus.COMPLETED;
    }

    public Food getFood() {
        return food;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Food: " + food.getName() +
                "\nPrice: " + price +
                "\nTime: " + orderTime +
                "\nStatus: " + status;
    }
}