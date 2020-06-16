package com.example.kapde_wala;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

public class MyAdapter extends
        RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private JSONArray list;

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View historyView = inflater.inflate(R.layout.my_list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(context, historyView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
//        Contact contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView idTextView = holder.idTextView;
        try {
            idTextView.setText(String.valueOf(list.getJSONObject(position).getInt("id")));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TextView statusTextView = holder.statusTextView;
        try {
            statusTextView.setText(list.getJSONObject(position).getString("order_status"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TextView updatedTextView = holder.updatedTextView;
        try {
            updatedTextView.setText(list.getJSONObject(position).getString("updatedAt"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.length();
    }

    public MyAdapter(JSONArray lst) {
        this.list = lst;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView idTextView;
        public TextView statusTextView;
        public TextView updatedTextView;
        private Context context;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(Context context, View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            this.context = context;
            idTextView = (TextView) itemView.findViewById(R.id.id_recycler);
            statusTextView = (TextView) itemView.findViewById(R.id.status_recycler);
            updatedTextView = (TextView) itemView.findViewById(R.id.updated_recycler);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            System.out.println("PRESSED AT: "+position);
            Intent intent = new Intent(context, OrderDetail.class);
            try {
                OrderDetail.setData(list.getJSONObject(position));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            context.startActivity(intent);
        }
    }
}