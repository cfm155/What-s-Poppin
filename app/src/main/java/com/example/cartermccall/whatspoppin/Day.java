package com.example.cartermccall.whatspoppin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Day implements Serializable {


    private String day;

    private ArrayList<Event> dailyEvents = new ArrayList<Event>();

    public void addEvent(Event event){
        dailyEvents.add(event);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<Event> getDailyEvents() {
        return dailyEvents;
    }

    public void setDailyEvents(ArrayList<Event> dailyEvents) {
        this.dailyEvents = dailyEvents;
    }

}