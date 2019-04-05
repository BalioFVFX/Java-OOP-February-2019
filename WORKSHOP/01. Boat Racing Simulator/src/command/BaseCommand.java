package command;

public abstract class BaseCommand implements Command {
    private String[] data;

    public BaseCommand(String[] data) {
        this.data = data;
    }

    protected String[] getData(){
        return this.data;
    }
}
