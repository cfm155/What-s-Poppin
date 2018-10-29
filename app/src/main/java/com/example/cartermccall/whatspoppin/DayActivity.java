package com.example.cartermccall.whatspoppin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class DayActivity extends AppCompatActivity {
    private TextView textView;
    private RecyclerView dailyEvents;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter eventAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        textView = (TextView) findViewById(R.id.textView2);
        dailyEvents = (RecyclerView) findViewById(R.id.daily_events);

        final Day day = (Day) getIntent().getSerializableExtra("day");
        textView.setText(day.getDay());


        layoutManager = new LinearLayoutManager(getApplicationContext());
        dailyEvents.setLayoutManager(layoutManager);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Event event = (Event) day.getDailyEvents().get(position);
                Intent intent = new Intent(view.getContext(), EventActivity.class);
                intent.putExtra("event", (Serializable)event);
                startActivity(intent);

            }
        };

        eventAdapter = new EventAdapter(getApplicationContext(),day.getDailyEvents(), listener);
        dailyEvents.setAdapter(eventAdapter);


    }
}
