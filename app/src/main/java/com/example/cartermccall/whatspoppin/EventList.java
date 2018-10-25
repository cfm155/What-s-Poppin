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

import io.realm.Realm;
import io.realm.RealmResults;


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

        Realm realm = Realm.getDefaultInstance();


        if(realm.where(Week.class).findAll().size() == 0) {
            populateWeeks();
        }

        final RealmResults<Week> weeks = realm.where(Week.class).findAll();
        eventList = (RecyclerView)view.findViewById(R.id.event_list);

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



        eventAdapter = new EventAdapter(getContext(), weeks, listener);
        eventList.setAdapter(eventAdapter);

        return view;


    }

    //Offline placeholder for adding events to the server and creating the week object and its
    // contents
    public void populateWeeks() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                Week week = new Week();

                Day sunday, monday, tuesday, wednesday, thursday, friday, saturday;
                sunday = monday = tuesday = wednesday = thursday = friday = saturday = new Day();

                //sunday (0)
                Event event1 = new Event();
                event1.setTitle("Swine and Psalms");
                event1.setDate("October 30");
                event1.setLocation("A cornfield");
                event1.setTime("19:30");
                sunday.addEvent(event1);

                Event event2 = new Event();
                event2.setTitle("Less Swine, More Psalms");
                event2.setDate("October 31");
                event2.setLocation("A cornfield over");
                event2.setTime("20:20");
                sunday.addEvent(event2);

                //monday (1)

                //tuesday (2)

                //wednesday (3)

                //thursday (4)

                //friday (5)

                //saturday (6)

                //RealmUpdate

                week.listAdd(sunday, 0);
                week.listAdd(monday, 1);
                week.listAdd(tuesday, 2);
                week.listAdd(wednesday, 3);
                week.listAdd(thursday, 4);
                week.listAdd(friday, 5);
                week.listAdd(saturday, 6);

                realm.copyToRealmOrUpdate(week);
            }
        });
    }

}
