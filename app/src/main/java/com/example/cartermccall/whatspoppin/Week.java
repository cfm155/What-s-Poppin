
// package com.example.cartermccall.whatspoppin;

// import java.util.ArrayList;

// import io.realm.RealmList;
// import io.realm.RealmObject;
// import io.realm.annotations.PrimaryKey;

// public class Week extends RealmObject {
//     @PrimaryKey
//     private String id = "calendarWeek";
//     private String day;

//     //Week contains an ArrayList of Days
//     private RealmList<Day> week = new RealmList<>();

//     public String getId() {
//         return id;
//     }

//     public void setId(String id) {
//         this.id = id;
//     }

//     public String getDay() {
//         return day;
//     }

//     public void setDay(String day) {
//         this.day = day;
//     }

//     public void listAdd(Day day, int pos){
//         week.add(pos, day);
//     }

//     public Day listGet(int pos){
//         return week.get(pos);
//     }

//     public void listReplace(int pos, Day day){
//         week.set(pos, day);
//     }
// }
