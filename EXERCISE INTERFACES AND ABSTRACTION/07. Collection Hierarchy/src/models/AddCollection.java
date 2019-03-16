package models;

import interfaces.Addable;
import models.base.Collection;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String element) {
        if(!super.hasCapacity()){
            return -1;
        }
        super.items.add(element);
        return super.items.size() - 1;
    }
}
