import java.util.concurrent.Exchanger;

public class Restaurant {

    static int ORDERS_TOTAL = 10;

    void open() {
        Exchanger<Meal> mealExchanger = new Exchanger<>();
        new Thread(new Waiter(mealExchanger)).start();
        new Thread(new Chef(mealExchanger)).start();
    }
}
