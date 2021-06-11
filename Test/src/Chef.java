import java.util.concurrent.Exchanger;

public class Chef implements Runnable {

    private final Exchanger<Meal> mealExchanger;

    public Chef(Exchanger<Meal> mealExchanger) {
        this.mealExchanger = mealExchanger;
    }
    public void run() {
        for (int i = 0; i < Restaurant.ORDERS_TOTAL; i++) {
            try {
                Meal receivedMeal = mealExchanger.exchange(null);
                receivedMeal.cook();
                receivedMeal.showResult();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
