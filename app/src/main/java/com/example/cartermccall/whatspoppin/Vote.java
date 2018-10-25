package com.example.cartermccall.whatspoppin;

import io.realm.RealmObject;

public class Vote extends RealmObject {
    private boolean isItPoppin;
    private User owner;

    public boolean isItPoppin() {
        return isItPoppin;
    }

    public void setItPoppin(boolean itPoppin) {
        isItPoppin = itPoppin;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
