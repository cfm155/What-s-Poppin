package com.example.cartermccall.whatspoppin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private Context context;
    private ArrayList<Event>events;

    public EventAdapter(Context context, ArrayList<Event> dataSet) {
        this.context = context;
        this.events = dataSet;
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;
        public TextView dateView;
        public TextView locationView;
        public EventViewHolder(View v) {
            super(v);
            titleView = v.findViewById(R.id.title_view);
            dateView = v.findViewById(R.id.date_view);
            locationView = v.findViewById(R.id.location_view);
        }
    }

    @Override
    public int getItemCount(){
        return events.size();
    }

    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_cell, parent, false);
        EventViewHolder vh = new EventViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.titleView.setText(events.get(position).getTitle());
        holder.dateView.setText(events.get(position).getDate());
        holder.locationView.setText(events.get(position).getLocation());
    }

}
