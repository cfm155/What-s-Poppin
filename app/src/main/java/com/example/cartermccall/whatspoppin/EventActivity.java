package com.example.cartermccall.whatspoppin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {
    private TextView title;
    private TextView date;
    private TextView location;
    private TextView description;
    private TextView rating;
    private Button voteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        voteButton = (Button) findViewById(R.id.vote_button);
        title = (TextView) findViewById(R.id.textView);
        date = (TextView) findViewById(R.id.event_date);
        location = (TextView) findViewById(R.id.event_location);
        description = (TextView) findViewById(R.id.event_description);
        rating = (TextView) findViewById(R.id.event_rate);


        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ThanksActivity.class);
                startActivity(intent);
            }
        });

        Event event = (Event) getIntent().getSerializableExtra("event");
        title.setText(event.getTitle());
        date.setText(event.getDate() + ", " + event.getTime());
        location.setText(event.getLocation());
        description.setText(event.getDescription());
        rating.setText(" " + event.getRating() + "% of people say it's poppin' ");
    }
}
