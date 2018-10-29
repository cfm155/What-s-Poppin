package com.example.cartermccall.whatspoppin;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class EventActivity extends AppCompatActivity {
    private TextView title;
    private TextView day;
    private TextView time;
    private TextView where;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        title = (TextView) findViewById(R.id.eventTitle);
        day = findViewById(R.id.eventDay);
        time = findViewById(R.id.eventTime);
        where = findViewById(R.id.eventWhere);

        Realm realm = Realm.getDefaultInstance();
        String id = getIntent().getStringExtra("event");
        Event event = realm.where(Event.class).equalTo("id", id).findFirst();
        title.setText(event.getTitle());
        day.setText(event.getDate());
        time.setText(event.getTime());
        where.setText(event.getLocation());

    }



}
