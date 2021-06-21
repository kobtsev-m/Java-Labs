public class Waiter extends Thread {

    private final Restaurant restaurant;
    private final Meal meal;

    public Waiter(Restaurant restaurant, Meal meal) {
        this.restaurant = restaurant;
        this.meal = meal;
    }
    void bringOrder() {
        try {
            Thread.sleep(10L * meal.getWeight());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (restaurant.getOrders() < restaurant.getTotalOrders()) {
            System.out.println("Order " + (restaurant.getOrders() + 1));
            bringOrder();
            synchronized (meal) {
                meal.regenerateWeight();
                meal.notify();
                System.out.print("Waiter bring meal, time: ");
                System.out.println(10L * meal.getWeight() + "ms");
                try {
                    meal.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            restaurant.increaseOrders();
        }
    }
}
