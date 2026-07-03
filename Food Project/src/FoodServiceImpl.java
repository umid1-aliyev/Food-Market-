public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRepository;
    private PaymentService paymentService;
    private OrderService orderService;
    private ReceiptService receiptService;
    private DiscountService discountService;

    public FoodServiceImpl(FoodRepository foodRepository,
                           PaymentService paymentService,
                           OrderService orderService,
                           ReceiptService receiptService,
                           DiscountService discountService) {

        this.foodRepository = foodRepository;
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.receiptService = receiptService;
        this.discountService = discountService;
    }

    @Override
    public void showMenu() {

        System.out.println("========== MENU ==========");

        int i = 1;

        for (Food food : foodRepository.getFoods()) {

            System.out.println(i + ". " + food);

            i++;
        }

    }

    @Override
    public void buyFood(User user, int choice) {

        if (choice < 1 || choice > foodRepository.getFoods().size()) {
            throw new FoodNotFoundException("Food not found.");
        }

        Food food = foodRepository.getFood(choice - 1);

        if (food.getStock() <= 0) {
            throw new OutOfStockException(food.getName() + " is out of stock.");
        }

        double finalPrice = discountService.applyDiscount(food.getPrice());

        boolean paid = paymentService.pay(user, finalPrice);

        if (!paid) {
            throw new InsufficientBalanceException("Balance is not enough.");
        }

        food.decreaseStock();

        user.addFood(food);

        Order order = new Order(food);

        user.addOrder(order);

        orderService.addOrder(order);

        receiptService.printReceipt(order);

        System.out.println(food.getName() + " purchased successfully.");
    }
}