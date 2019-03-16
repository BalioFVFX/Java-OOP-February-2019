package models;

import interfaces.MyList;
import models.base.Collection;

public class MyListImpl extends Collection implements MyList {

    public MyListImpl() {
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
        return super.items.remove(0);
    }


    public int getUsed() {
        return super.items.size();
    }

}
