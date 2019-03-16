package models.base;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private static final int maxSize = 100;
    protected List<String> items;

    public Collection() {
        this.items = new ArrayList<>();
    }

    protected boolean hasCapacity(){
        return this.items.size() < maxSize;
    }
}
