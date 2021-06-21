public class Restaurant {

    private final int TOTAL_ORDERS = 5;
    private int orders;

    public int getTotalOrders() {
        return TOTAL_ORDERS;
    }
    public int getOrders() {
        return orders;
    }
    public void increaseOrders() {
        orders++;
    }
    void open() {
        Meal currentOffer = new Meal();
        Waiter waiter = new Waiter(this, currentOffer);
        Chef chef = new Chef(this, currentOffer);
        waiter.start();
        chef.start();
        try {
            waiter.join();
            chef.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
