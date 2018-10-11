package com.example.cartermccall.whatspoppin;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        textView = (TextView) findViewById(R.id.textView);

        Event event = (Event) getIntent().getSerializableExtra("event");
        textView.setText(event.getTitle());
    }
}
