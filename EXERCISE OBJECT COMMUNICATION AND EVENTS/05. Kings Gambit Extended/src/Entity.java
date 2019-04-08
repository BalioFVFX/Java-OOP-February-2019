import java.util.Objects;

public abstract class Entity implements Defensible{
    private String name;
    private OnSoldierKilledListener onSoldierKilledListener;

    public Entity(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected OnSoldierKilledListener getOnSoldierKilledListener() {
        return this.onSoldierKilledListener;
    }

    public void setOnSoldierKilledListener(OnSoldierKilledListener onSoldierKilledListener){
        this.onSoldierKilledListener = onSoldierKilledListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
