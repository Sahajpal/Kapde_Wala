package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class CancelOrder extends AppCompatActivity {

    String enroll = ApplicationData.ENROLMENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_order);
        try {
            SendCancelOrder();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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
