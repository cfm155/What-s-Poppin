package com.example.cartermccall.whatspoppin;

import java.util.ArrayList;
import java.util.LinkedList;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Week extends RealmObject {
    @PrimaryKey
    private String id;

    //Week contains an ArrayList of Days
    private ArrayList<Day> week = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
