package models;

import interfaces.AddRemovable;
import models.base.Collection;

public class AddRemoveCollection extends Collection implements AddRemovable {

    public AddRemoveCollection() {
    }

    @Override
    public int add(String element) {
        if(!super.hasCapacity()){
            return -1;
        }

        super.items.add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        if(super.items.isEmpty()){
            return null;
        }
        return super.items.remove(super.items.size() - 1);
    }
}
