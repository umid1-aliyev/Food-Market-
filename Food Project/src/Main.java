import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User(100);

        FoodRepository foodRepository = new FoodRepository();

        PaymentService paymentService = new CardPaymentService();

        OrderRepository orderRepository = new OrderRepository();

        OrderService orderService =
                new OrderServiceImpl(orderRepository);

        ReceiptService receiptService = new ReceiptService();

        DiscountService discountService =
                new NoDiscountService();

        FoodService foodService =
                new FoodServiceImpl(
                        foodRepository,
                        paymentService,
                        orderService,
                        receiptService,
                        discountService
                );

        while (true) {

            try {

                System.out.println("\nBalance : " + user.getBalance());

                System.out.println("\n1. Show Menu");
                System.out.println("2. Buy Food");
                System.out.println("3. My Foods");
                System.out.println("4. Order History");
                System.out.println("0. Exit");

                System.out.print("Choice : ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        foodService.showMenu();

                        break;

                    case 2:

                        foodService.showMenu();

                        System.out.print("Choose food : ");

                        int foodChoice = sc.nextInt();

                        foodService.buyFood(user, foodChoice);

                        break;

                    case 3:

                        System.out.println("===== MY FOODS =====");

                        if (user.getInventory().isEmpty()) {

                            System.out.println("No food purchased.");

                        } else {

                            for (Food food : user.getInventory()) {

                                System.out.println(food.getName());

                            }

                        }

                        break;

                    case 4:

                        orderService.showOrders();

                        break;

                    case 0:

                        System.out.println("Good Bye!");

                        return;

                    default:

                        System.out.println("Wrong choice.");

                }

            } catch (FoodNotFoundException |
                     OutOfStockException |
                     InsufficientBalanceException e) {

                System.out.println(e.getMessage());

            } catch (Exception e) {

                System.out.println("Unexpected error.");

            }

        }

    }

}