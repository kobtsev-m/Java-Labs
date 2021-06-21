import java.util.Random;

public class Meal {

    private final Random random;
    private int weight;

    public Meal() {
        this.random = new Random();
        regenerateWeight();
    }
    public int getWeight() {
        return weight;
    }
    public void regenerateWeight() {
        this.weight = random.nextInt(20) + 10;
    }
}
