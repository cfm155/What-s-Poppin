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
        final ArrayList<Event> events = new ArrayList<Event>();
        final ArrayList<Day> days = new ArrayList<Day>();
        System.out.println(Calendar.getInstance().getTime());

        Event event1 = new Event();
        event1.setTitle("Swine and Psalms");
        event1.setDate("October 30");
        event1.setLocation("A cornfield");

        Event event2 = new Event();
        event2.setTitle("Less Swine, More Psalms");
        event2.setDate("October 31");
        event2.setLocation("A cornfield over");

        events.add(event1);
        events.add(event2);

        Day monday = new Day();
        monday.setDay(" Monday \n November 5 ");
        monday.addEvent(event1);
        monday.addEvent(event2);

        Day tuesday = new Day();
        tuesday.setDay(" Tuesday \n October 30 ");
        tuesday.addEvent(event2);

        Day wednesday = new Day();
        wednesday.setDay(" Wednesday \n October 31 ");

        Day thursday = new Day();
        thursday.setDay(" Thursday \n November 1 ");

        Day friday = new Day();
        friday.setDay(" Friday \n November 2 ");

        Day saturday = new Day();
        saturday.setDay(" Saturday \n November 3 ");

        Day sunday = new Day();
        sunday.setDay(" Sunday \n November 4 ");

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
