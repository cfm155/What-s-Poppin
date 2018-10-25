package com.example.cartermccall.whatspoppin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.RealmResults;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private Context context;
    private RealmResults<Week> weeks;
    private RecyclerViewClickListener mListener;

    public EventAdapter(Context context, RealmResults<Week> dataSet, RecyclerViewClickListener clickListener) {
        this.context = context;
        this.weeks = dataSet;
        this.mListener = clickListener;
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleView;
        public TextView dateView;
        public TextView locationView;
        private RecyclerViewClickListener mListener;
        public EventViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            titleView = v.findViewById(R.id.title_view);
            dateView = v.findViewById(R.id.date_view);
            locationView = v.findViewById(R.id.location_view);
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
        return weeks.get(0).listGet(0).getEventSize();
    }

    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_cell, parent, false);
        EventViewHolder vh = new EventViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        //Pos value is placeholder, replace with getDay function when complete
        holder.titleView.setText(weeks.get(0).listGet(0).getEvent(0).getTitle());
        holder.dateView.setText(weeks.get(0).listGet(0).getEvent(0).getDate());
        holder.locationView.setText(weeks.get(0).listGet(0).getEvent(0).getLocation());
    }

}
