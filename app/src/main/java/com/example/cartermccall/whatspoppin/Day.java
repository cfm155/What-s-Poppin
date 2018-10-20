package com.example.cartermccall.whatspoppin;

import java.util.LinkedList;

public class Day{
    private LinkedList<Event> dailyEvents = new LinkedList<Event>();

    public void addEvent(Event event){
        dailyEvents.add(event);
    }

}