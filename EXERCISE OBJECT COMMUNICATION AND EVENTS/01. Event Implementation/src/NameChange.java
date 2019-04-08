import java.util.EventObject;

public class NameChange extends EventObject {

    private String changedName;

    public NameChange(Object object, String changedName) {
        super(object);
        ((Dispatcher)object).setName(changedName);
        this.changedName = changedName;
    }

    public String getChangedName() {
        return changedName;
    }


}
