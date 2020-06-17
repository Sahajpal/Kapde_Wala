package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class CancelOrder extends AppCompatActivity {
    String enroll = ApplicationData.ENROLMENT;
    TextView id2, enrol2, os2;
    Context context;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_order);
        context = this;

        id2 = (TextView) findViewById(R.id.id2);
        enrol2 = (TextView) findViewById(R.id.enrol2);
        os2 = (TextView) findViewById(R.id.os2);
        JSONObject post_dict = new JSONObject();
        String url = ApplicationData.SERVER_IP+ ApplicationData.USER_STATUS;
        try {
            post_dict.put("enrolment", enroll );
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
                id2.setText(String.valueOf(order.getInt("id")));
                os2.setText(order.getString("order_status"));
                enrol2.setText(order.getString("enrol_id"));

            }catch (JSONException err) {
                Log.d("Error", err.toString());
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancleorder(View view){
        alertDialog = new AlertDialog.Builder(context).create();

        try {
            SendCancelOrder();
            alertDialog.setTitle("Cancellation");
            alertDialog.setMessage("Success");
            alertDialog.show();

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void SendCancelOrder() throws ExecutionException, InterruptedException {
        JSONObject post_dict = new JSONObject();
        try{
            post_dict.put("enrolment", enroll);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(post_dict.length()>0){
            String url = ApplicationData.SERVER_IP+ApplicationData.USER_CANCEL_ORDER;
            SendJsonDataToServer x = new SendJsonDataToServer();
            String response = x.execute(String.valueOf(post_dict), url).get();
            System.out.println("RESPONSE: "+ response);
            try {
                JSONObject jsonObject = new JSONObject(response);
                System.out.println(jsonObject.getString("message"));

            }catch (JSONException err) {
                Log.d("Error", err.toString());
            }
        }
    }
}
