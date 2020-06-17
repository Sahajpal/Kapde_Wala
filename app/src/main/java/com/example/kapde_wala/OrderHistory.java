package com.example.kapde_wala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class OrderHistory extends AppCompatActivity {
//    TextView id, os, shirt, tshirt, pajama, jean, pant, bedsheet, towel;
    String enroll = ApplicationData.ENROLMENT;
    private RecyclerView OrderList;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        RecyclerView rvHistory = (RecyclerView) findViewById(R.id.orderHistory);
        rvHistory.setHasFixedSize(true);


        JSONObject post_dict = new JSONObject();
        String url = ApplicationData.SERVER_IP+ ApplicationData.USER_HISTORY;
        try {
            post_dict.put("enrolment", enroll);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SendJsonDataToServer x = new SendJsonDataToServer();
        JSONArray order = new JSONArray();
        try {
            String response = x.execute(String.valueOf(post_dict),url).get();
            try {
                JSONObject jsonObject = new JSONObject(response);
                order = jsonObject.getJSONArray("orders");
//                System.out.println(jsonObject);
//                System.out.println(order);
            }catch (JSONException err) {
                Log.d("Error", err.toString());
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MyAdapter adapter = new MyAdapter(order);
        rvHistory.setAdapter(adapter);
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        rvHistory.addItemDecoration(itemDecoration);
        rvHistory.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            @Override
            public void onTouchEvent(RecyclerView recycler, MotionEvent event) {
                // Handle on touch events here

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recycler, MotionEvent event) {
                return false;
            }

        });

    }
}
