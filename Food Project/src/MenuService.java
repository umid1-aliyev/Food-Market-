import java.util.Scanner;

public class MenuService {

    private FoodService foodService;
    private OrderService orderService;
    private User user;

    public MenuService(FoodService foodService,
                       OrderService orderService,
                       User user) {

        this.foodService = foodService;
        this.orderService = orderService;
        this.user = user;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("Balance : " + user.getBalance());

            System.out.println();
            System.out.println("1. Show Menu");
            System.out.println("2. Buy Food");
            System.out.println("3. My Foods");
            System.out.println("4. My Orders");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    foodService.showMenu();

                    break;

                case 2:

                    foodService.showMenu();

                    System.out.print("Choose food : ");

                    int food = sc.nextInt();

                    foodService.buyFood(user, food);

                    break;

                case 3:

                    for (Food f : user.getInventory()) {

                        System.out.println(f.getName());

                    }

                    break;

                case 4:

                    orderService.showOrders();

                    break;

                case 0:

                    return;

                default:

                    System.out.println("Wrong choice.");

            }

        }

    }

}