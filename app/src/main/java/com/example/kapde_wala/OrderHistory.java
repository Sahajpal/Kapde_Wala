package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class OrderHistory extends AppCompatActivity {
    //TextView id, os, shirt, tshirt, pajama, jean, pant, bedsheet, towel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter orderList;
    private RecyclerView.LayoutManager layoutManager;
    String enroll = ApplicationData.ENROLMENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        recyclerView = (RecyclerView) findViewById(R.id.orderHistory);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        String[] a = {"Hello", "World"};
        // specify an adapter (see also next example)
        MyAdapter adapter = new MyAdapter(a);
        recyclerView.setAdapter(adapter);

        //id = (TextView) findViewById(R.id.id);
        //os = (TextView) findViewById(R.id.os);
        //shirt = (TextView) findViewById(R.id.shirt);
        //tshirt = (TextView) findViewById(R.id.tshirt);
        //pajama = (TextView) findViewById(R.id.pajama);
        //jean = (TextView) findViewById(R.id.jean);
        //pant = (TextView) findViewById(R.id.pant);
        //bedsheet = (TextView) findViewById(R.id.bedsheet);
        //towel = (TextView) findViewById(R.id.towel);

    }
}
