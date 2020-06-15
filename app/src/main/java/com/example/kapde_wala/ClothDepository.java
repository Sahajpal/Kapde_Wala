package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ClothDepository extends AppCompatActivity {
    int shirt, tshirt, pajama, jean, pant, bedsheet, towel;
    EditText Shirt, Tshirt, Pajama, Jean, Pant, Bedsheet, Towel;
    String enroll = ApplicationData.ENROLMENT;
    AlertDialog alertDialog;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_depository);
        Shirt = (EditText) findViewById(R.id.shirt);
        Tshirt = (EditText) findViewById(R.id.tshirt);
        Pajama = (EditText) findViewById(R.id.pajama);
        Jean = (EditText) findViewById(R.id.jean);
        Pant = (EditText) findViewById(R.id.pant);
        Bedsheet = (EditText) findViewById(R.id.bedsheet);
        Towel = (EditText) findViewById(R.id.towel);
        context = this;
    }

    public void sendDataToServer(View view) throws ExecutionException, InterruptedException {
        shirt = ConvertStringToInt(Shirt.getText().toString());
        tshirt = ConvertStringToInt(Tshirt.getText().toString());
        pajama = ConvertStringToInt(Pajama.getText().toString());
        jean = ConvertStringToInt(Jean.getText().toString());
        pant = ConvertStringToInt(Pant.getText().toString());
        bedsheet = ConvertStringToInt(Bedsheet.getText().toString());
        towel = ConvertStringToInt(Towel.getText().toString());

        JSONObject post_dict = new JSONObject();
        try{
            post_dict.put("enrolment", enroll);
            post_dict.put("shirt", shirt);
            post_dict.put("tshirt", tshirt);
            post_dict.put("pajamas", pajama);
            post_dict.put("jeans", jean);
            post_dict.put("pants", pant);
            post_dict.put("bedsheets", bedsheet);
            post_dict.put("towels", towel);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(post_dict.length()>0){
            String url = ApplicationData.SERVER_IP+ ApplicationData.USER_CREATE_ORDER;
            SendJsonDataToServer x = new SendJsonDataToServer();
            String response = x.execute(String.valueOf(post_dict), url).get();
            System.out.println("RESPONSE: "+ response);
            try {
                System.out.println("ENROLMENT: "+enroll);
                JSONObject jsonObject = new JSONObject(response);
                alertDialog = new AlertDialog.Builder(context).create();
                if(jsonObject.getString("status").equals("success")) {
                    alertDialog.setTitle("Order Creation");
                    alertDialog.setMessage("Success");
                    alertDialog.show();
                } else {
                    alertDialog.setTitle("Failed");
                    alertDialog.setMessage(jsonObject.getString("message"));
                    alertDialog.show();
                }

            }catch (Exception err) {
                Log.d("Error", err.toString());
            }
        }
    }


    int ConvertStringToInt(String str) {
        return isStrBlank(str) ? 0 : Integer.parseInt(str);
    }
    boolean isStrBlank(String str) {
        if(str.equals("") || str == null) {
            return true;
        } else {
            return false;
        }
    }
}
