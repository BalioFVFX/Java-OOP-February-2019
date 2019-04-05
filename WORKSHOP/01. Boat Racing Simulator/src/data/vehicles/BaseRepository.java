package data.vehicles;

import exception.DuplicateModelException;
import exception.NonExistantModelException;
import model.boat.Unique;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseRepository <T extends Unique>{

    private Set<T> data;

    public BaseRepository() {
        this.data = new HashSet<>();
    }

    public void addEntry(T entry) throws DuplicateModelException {
        if (data.contains(entry)) {
            throw new DuplicateModelException("Item with the same model already exists in the database.");
        }
        this.data.add(entry);
    }

    public T findByModel(String model) throws NonExistantModelException {
        T entry = this.data.stream().filter(e -> e.getModel().equals(model)).findFirst().orElse(null);

        if(entry == null){
            throw new NonExistantModelException("Item with the given model does not exist in the database.");
        }

        return entry;
    }

    protected Set<T> getData() {
        return data;
    }
}
