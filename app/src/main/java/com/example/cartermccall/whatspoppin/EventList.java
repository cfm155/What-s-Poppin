package com.example.cartermccall.whatspoppin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.Calendar;
import java.io.Serializable;
import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class EventList extends Fragment {

    private RecyclerView eventList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter eventAdapter;
    final static ArrayList<Event> events = new ArrayList<Event>();

    public EventList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);


        eventList = (RecyclerView)view.findViewById(R.id.event_list);

        System.out.println(Calendar.getInstance().getTime());

        Event event1 = new Event();
        event1.setTitle("Swine and Psalms");
        event1.setDate("October 30");
        event1.setTime("7:00-10:00 pm");
        event1.setLocation("A cornfield");
        event1.setDescription("Do you like ham? Do you like psalms? Join us at your local cornfield for a revolutionary blend of both!");
        event1.setRating(93.4);


        Event event2 = new Event();


        event2.setTitle("Beggar's Night in Greater Des Moines");
        event2.setDate("October 30");
        event2.setTime("6:00-8:00 pm");
        event2.setLocation("Your neighborhood");
        event2.setDescription("Trick or Treat!!");
        event2.setRating(85.8);

        Event event3 = new Event();


        event3.setTitle("Horror Movie Trivia");
        event3.setDate("October 30");
        event3.setTime("7:00-9:00 pm");
        event3.setLocation("Wisco Grub and Pub");
        event3.setRating(70);

        Event event4 = new Event();
        event4.setTitle("Deep Release Yoga Workshop");
        event4.setDate("Every Week Day");
        event4.setTime("11:00-1:00 pm");
        event4.setLocation("Wellmark YMCA");
        event4.setDescription("Join popular YMCA yoga instructor Kelby A. for this deep dive into your personal yoga practice. Whether you are looking to start a personal practice or extend your current routine Kelby will help you realign your energetic system, new your mind and restore your body.");
        event4.setRating(50);

        Event event5 = new Event();
        event5.setTitle("Focaccia Bread");
        event5.setDate("October 30");
        event5.setTime("6:00-8:00 pm");
        event5.setLocation("Historic East Village");
        event5.setRating(35);

        Event event6 = new Event();
        event6.setTitle("Bingo By the Beat");
        event6.setDate("October 30");
        event6.setTime("7:30-9:30 pm");
        event6.setLocation("Lime Lounge");
        event6.setRating(20);

        Event event7 = new Event();
        event7.setTitle("Historic Skills Classes");
        event7.setDate("October 30");
        event7.setTime("7:30-9:30 pm");
        event7.setLocation("Living History Farms");
        event7.setRating(15);



        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);
        events.add(event5);
        events.add(event6);
        events.add(event7);


        layoutManager = new LinearLayoutManager(getContext());
        eventList.setLayoutManager(layoutManager);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                    Event event = (Event) events.get(position);
                    Intent intent = new Intent(view.getContext(), EventActivity.class);
                    intent.putExtra("event", (Serializable)event);
                    startActivity(intent);

            }
        };



        eventAdapter = new EventAdapter(getContext(),events, listener);
        eventList.setAdapter(eventAdapter);

        return view;


    }

}
