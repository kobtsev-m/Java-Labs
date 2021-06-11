import java.util.Random;
import java.util.concurrent.Exchanger;

public class Waiter implements Runnable {

    private final Exchanger<Meal> mealExchanger;

    public Waiter(Exchanger<Meal> mealExchanger) {
        this.mealExchanger = mealExchanger;
    }
    public void run() {
        for (int i = 0; i < Restaurant.ORDERS_TOTAL; i++) {
            int weight = new Random().nextInt(20) + 10;
            Meal meal = new Meal(weight);
            try {
                mealExchanger.exchange(meal);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
