package com.example.kapde_wala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends
        RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> list;

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View historyView = inflater.inflate(R.layout.recycler_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(historyView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
//        Contact contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.textView;
        textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public MyAdapter(List<String> lst) {
        this.list = lst;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView textView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view_recycler);
        }
    }
}