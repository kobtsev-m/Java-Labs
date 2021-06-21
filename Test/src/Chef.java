public class Chef extends Thread {

    private final Restaurant restaurant;
    private final Meal meal;

    public Chef(Restaurant restaurant, Meal meal) {
        this.restaurant = restaurant;
        this.meal = meal;
    }
    void cook() {
        try {
            Thread.sleep(100L * meal.getWeight());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true) {
            cook();
            synchronized (meal) {
                meal.notify();
                System.out.print("Chef cooked meal, time: ");
                System.out.println(100L * meal.getWeight() + "ms");
                if (restaurant.getOrders() == restaurant.getTotalOrders() - 1) {
                    break;
                }
                try {
                    meal.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
