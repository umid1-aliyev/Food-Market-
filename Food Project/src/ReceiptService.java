public class ReceiptService {

    public void printReceipt(Order order) {

        System.out.println("========== RECEIPT ==========");
        System.out.println("Food   : " + order.getFood().getName());
        System.out.println("Price  : " + order.getPrice());
        System.out.println("Time   : " + order.getOrderTime());
        System.out.println("Status : " + order.getStatus());
        System.out.println("=============================");
    }
}