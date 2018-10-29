package com.example.cartermccall.whatspoppin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private Context context;
    private ArrayList<Event> events;
    private RecyclerViewClickListener mListener;

    public EventAdapter(Context context, ArrayList<Event> dataSet, RecyclerViewClickListener clickListener) {
        this.context = context;
        this.events = dataSet;
        this.mListener = clickListener;
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleView;
        public TextView dateView;
        public TextView locationView;
        public ImageView poppinView;
        private RecyclerViewClickListener mListener;
        public EventViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            titleView = v.findViewById(R.id.title_view);
            dateView = v.findViewById(R.id.date_view);
            locationView = v.findViewById(R.id.distance_view);
            poppinView = v.findViewById(R.id.poppin_image);
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
        return events.size();
    }

    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.event_cell, parent, false);
        EventViewHolder vh = new EventViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.titleView.setText(events.get(position).getTitle());
        holder.dateView.setText(events.get(position).getDate());
        holder.locationView.setText(events.get(position).getLocation());
        if(events.get(position).getRating() < 34){
            holder.poppinView.setImageResource(R.drawable.unpopped);
        }
        else if(events.get(position).getRating() < 67){
            holder.poppinView.setImageResource(R.drawable.half_popped);
        }
    }

}
