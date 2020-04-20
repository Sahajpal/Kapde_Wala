package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.enno);
        password = (EditText) findViewById(R.id.password);

    }

    public void click(View view) {
        String Username = username.getText().toString();
        String Password = password.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, Username, Password);
        if (backgroundWorker.result.equals("Login Success")) {
            Intent intent = new Intent(LoginActivity.this, MainMenu.class);
            startActivity(intent);
        }
    }
}


