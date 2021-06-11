public class Meal {

    private final int weight;
    private double cookResult;

    public Meal(int weight) {
        this.weight = weight;
    }
    void cook() {
        for (int i = 0; i < weight; i++) {
            cookResult += Math.sin(Math.exp(i));
        }
    }
    void showResult() {
        System.out.println("Meal is cooked, result: " + cookResult);
    }
}
