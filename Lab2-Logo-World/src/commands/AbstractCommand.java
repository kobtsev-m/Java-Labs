package commands;

public abstract class AbstractCommand {
    protected String[] args;
    public AbstractCommand(String[] args) {
        this.args = args;
    }
    public abstract void execute();
}
