package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;
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
    TextView id, os, shirt, tshirt, pajama, jean, pant, bedsheet, towel;
    String enroll = ApplicationData.ENROLMENT;
    private RecyclerView OrderList;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        id = (TextView) findViewById(R.id.id);
        os = (TextView) findViewById(R.id.os);
        shirt = (TextView) findViewById(R.id.shirt);
        tshirt = (TextView) findViewById(R.id.tshirt);
        pajama = (TextView) findViewById(R.id.pajama);
        jean = (TextView) findViewById(R.id.jean);
        pant = (TextView) findViewById(R.id.pant);
        bedsheet = (TextView) findViewById(R.id.bedsheet);
        towel = (TextView) findViewById(R.id.towel);

        JSONObject post_dict = new JSONObject();
        String url = ApplicationData.SERVER_IP+ ApplicationData.USER_STATUS;
        try {
            post_dict.put("enrolment", enroll);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SendJsonDataToServer x = new SendJsonDataToServer();

        try {
            String response = x.execute(String.valueOf(post_dict),url).get();
            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONObject order = jsonObject.getJSONObject("order");
                System.out.println(jsonObject);
                System.out.println(order);
                id.setText(String.valueOf(order.getInt("id")));
                os.setText(order.getString("order_status"));
                shirt.setText(String.valueOf(order.getInt("shirt_count")));
                tshirt.setText(String.valueOf(order.getInt("tshirt_count")));
                pajama.setText(String.valueOf(order.getInt("pajama_count")));
                jean.setText(String.valueOf(order.getInt("jeans_count")));
                pant.setText(String.valueOf(order.getInt("pant_count")));
                bedsheet.setText(String.valueOf(order.getInt("bedsheet_count")));
                towel.setText(String.valueOf(order.getInt("towel_count")));
            }catch (JSONException err) {
                Log.d("Error", err.toString());
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
