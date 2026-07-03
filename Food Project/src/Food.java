public class Food {

    private String name;
    private double price;
    private int stock;

    public Food(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock() {
        stock--;
    }

    @Override
    public String toString() {
        return name +
                " | Price: " + price +
                " | Stock: " + stock;
    }
}