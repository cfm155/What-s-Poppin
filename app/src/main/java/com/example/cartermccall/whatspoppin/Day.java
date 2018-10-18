package com.example.cartermccall.whatspoppin;

import java.util.LinkedList;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Day extends RealmObject {
    @PrimaryKey
    private LinkedList<Event> dailyEvents = new LinkedList<Event>();


}
