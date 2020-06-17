package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {
     private static EditText username;
     EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.enno);
        password = (EditText) findViewById(R.id.password);

    }

    public void click(View view) throws ExecutionException, InterruptedException, JSONException {
        String Username = username.getText().toString();
        String Password = password.getText().toString();
        JSONObject post_dict = new JSONObject();
        String url = ApplicationData.SERVER_IP+ ApplicationData.USER_LOGIN;
        try {
            post_dict.put("username", Username);
            post_dict.put("password", Password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SendJsonDataToServer x = new SendJsonDataToServer();
        String response = x.execute(String.valueOf(post_dict),url).get();
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(response);
            System.out.println(jsonObject);
            if(jsonObject.get("status").equals("success")) {
                Login();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(),"Error: Check details",Toast.LENGTH_LONG);
                toast.show();
            }
        } catch (JSONException err) {
            Log.d("Error", err.toString());
        }

    }

    public void Login(){
        Intent intent = new Intent(LoginActivity.this, MainMenu.class);
        ApplicationData.ENROLMENT = username.getText().toString();
        startActivity(intent);

    }
    public static String getData(){
        return String.valueOf(username);
    }

}


