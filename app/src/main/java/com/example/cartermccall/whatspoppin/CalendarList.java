package com.example.cartermccall.whatspoppin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarList extends Fragment {

    private RecyclerView calendarList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter calendarAdapter;

    public CalendarList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar_list, container, false);

        calendarList = (RecyclerView) view.findViewById(R.id.calendar_list);
        final ArrayList<Day> days = new ArrayList<Day>();
        System.out.println(Calendar.getInstance().getTime());

        Event event = new Event();
        event.setTitle("Free Wine Tasting");
        event.setDate("October 31");
        event.setTime("5:00-8:00 pm");
        event.setLocation("Vino 209 Wine Cafe");
        event.setRating(50);

        Event event1 = new Event();
        event1.setTitle("Halloween Freak Out!");
        event1.setDate("October 31");
        event1.setTime("8:00-12:00 am");
        event1.setLocation("Des Moines Social Club");
        event1.setRating(99.9);

        Event event4 = new Event();
        event4.setTitle("Deep Release Yoga Workshop");
        event4.setDate("Every Week Day");
        event4.setTime("11:00-1:00 pm");
        event4.setLocation("Wellmark YMCA");
        event4.setDescription("Join popular YMCA yoga instructor Kelby A. for this deep dive into your personal yoga practice. Whether you are looking to start a personal practice or extend your current routine Kelby will help you realign your energetic system, new your mind and restore your body.");
        event4.setRating(50);

        Day monday = new Day();
        monday.setDay(" Monday \n November 5 ");
        monday.addEvent(event4);
        monday.addEvent(EventList.events.get(4));
        monday.addEvent(EventList.events.get(1));


        Day tuesday = new Day();
        tuesday.setDay(" Tuesday \n October 30 ");
        tuesday.setDailyEvents(EventList.events);

        Day wednesday = new Day();
        wednesday.setDay(" Wednesday \n October 31 ");
        wednesday.addEvent(event);
        wednesday.addEvent(event4);
        wednesday.addEvent(event1);

        Day thursday = new Day();
        thursday.setDay(" Thursday \n November 1 ");
        thursday.addEvent(event4);
        thursday.addEvent(EventList.events.get(4));
        thursday.addEvent(EventList.events.get(5));

        Day friday = new Day();
        friday.setDay(" Friday \n November 2 ");
        friday.addEvent(event4);
        friday.addEvent(EventList.events.get(4));
        friday.addEvent(EventList.events.get(2));
        friday.addEvent(EventList.events.get(6));

        Day saturday = new Day();
        saturday.setDay(" Saturday \n November 3 ");
        saturday.addEvent(EventList.events.get(0));
        saturday.addEvent(EventList.events.get(5));
        saturday.addEvent(EventList.events.get(2));

        Day sunday = new Day();
        sunday.setDay(" Sunday \n November 4 ");
        sunday.addEvent(EventList.events.get(1));
        sunday.addEvent(EventList.events.get(6));
        sunday.addEvent(EventList.events.get(4));

        days.add(tuesday);
        days.add(wednesday);
        days.add(thursday);
        days.add(friday);
        days.add(saturday);
        days.add(sunday);
        days.add(monday);

        layoutManager = new LinearLayoutManager(getContext());
        calendarList.setLayoutManager(layoutManager);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Day day = (Day) days.get(position);
                Intent intent = new Intent(view.getContext(), DayActivity.class);
                intent.putExtra("day", (Serializable)day);
                startActivity(intent);

            }
        };

        calendarAdapter = new CalendarAdapter(getContext(),days,listener);
        calendarList.setAdapter(calendarAdapter);

        return view;
    }

}
