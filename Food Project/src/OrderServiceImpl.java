public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addOrder(Order order) {
        repository.addOrder(order);
    }

    @Override
    public void showOrders() {
        repository.showOrders();
    }
}