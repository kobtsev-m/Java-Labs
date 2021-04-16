package commands;

import view.View;

public class Init extends AbstractCommand {
    public Init(String[] args) {
        super(args);
    }
    @Override
    public void execute() {
        int w = Integer.parseInt(args[1]);
        int h = Integer.parseInt(args[2]);
        View view = new View(w, h);
        view.drawField();
    }
}
