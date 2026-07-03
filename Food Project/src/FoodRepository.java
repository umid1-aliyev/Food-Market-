import java.util.ArrayList;
import java.util.List;

public class FoodRepository {

    private List<Food> foods = new ArrayList<>();

    public FoodRepository() {

        foods.add(new Food("Burger",10,5));
        foods.add(new Food("Pizza",15,3));
        foods.add(new Food("Kebab",12,4));
        foods.add(new Food("Cola",3,10));
        foods.add(new Food("Fries",4,8));
    }

    public List<Food> getFoods() {
        return foods;
    }

    public Food getFood(int index) {
        return foods.get(index);
    }
}