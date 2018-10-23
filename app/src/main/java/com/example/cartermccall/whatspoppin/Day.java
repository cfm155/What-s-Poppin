package com.example.cartermccall.whatspoppin;

import java.util.LinkedList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Day extends RealmObject {
    @PrimaryKey
    private String id;

    private RealmList<Event> dailyEvents = new RealmList<Event>();

    public void addEvent(Event event){
        dailyEvents.add(event);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}