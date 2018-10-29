package com.example.cartermccall.whatspoppin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {
    private Context context;
    private ArrayList<Day> days;
    private String events;
    private RecyclerViewClickListener mListener;

    public CalendarAdapter(Context context, ArrayList<Day> dataSet, RecyclerViewClickListener clickListener) {
        this.context = context;
        this.days = dataSet;
        this.mListener = clickListener;
    }

    public static class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView dayView;
        public TextView eventView;
        public TextView locationView;
        private RecyclerViewClickListener mListener;
        public CalendarViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            dayView = v.findViewById(R.id.day_view);
            eventView = v.findViewById(R.id.event_view);
            mListener = listener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public int getItemCount(){
        return days.size();
    }

    @Override
    public CalendarAdapter.CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.day_cell, parent, false);
        CalendarViewHolder vh = new CalendarViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(CalendarViewHolder holder, int position) {
        if(days.get(position).getDailyEvents().size() == 0){
            events = "No events for " + days.get(position).getDay();
        }
        else{
            events = days.get(position).getDailyEvents().get(0).getTitle();
            for(int i = 1; i < days.get(position).getDailyEvents().size(); i++){
                events += "\n" + days.get(position).getDailyEvents().get(i).getTitle();
            }
        }
        holder.dayView.setText(days.get(position).getDay());
        holder.eventView.setText(events);
    }

}
