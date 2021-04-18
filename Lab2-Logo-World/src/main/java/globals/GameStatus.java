package globals;

public class GameStatus {
    public GameStatusCode code;
    public String message;
    public GameStatus(GameStatusCode code, String message) {
        this.code = code;
        this.message = message;
    }
}
