package com.example.cartermccall.whatspoppin;

import java.util.ArrayList;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Week extends RealmObject {
    @PrimaryKey
    private ArrayList<Day> week = new ArrayList<Day>();


}
