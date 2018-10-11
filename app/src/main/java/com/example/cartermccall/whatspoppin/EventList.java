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

import java.io.Serializable;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventList extends Fragment {

    private RecyclerView eventList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter eventAdapter;

    public EventList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);

        final ArrayList<Event> events = new ArrayList<Event>();
        eventList = (RecyclerView)view.findViewById(R.id.event_list);

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
        layoutManager = new LinearLayoutManager(getContext());
        eventList.setLayoutManager(layoutManager);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();
            }
        };



        eventAdapter = new EventAdapter(getContext(),events, listener);
        eventList.setAdapter(eventAdapter);

        return view;


    }

}
