package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void cdclick(View view){
        Intent intent = new Intent(MainMenu.this, ClothDepository.class);
        startActivity(intent);
    }

    public void osclick(View view){
        Intent intent = new Intent(MainMenu.this, OrderStatus.class);
        startActivity(intent);
    }

    public void coclick(View view){
        Intent intent = new Intent(MainMenu.this, CancelOrder.class);
        startActivity(intent);
    }

    public void orclick(View view){
        Intent intent = new Intent(MainMenu.this, OrderHistory.class);
        startActivity(intent);
    }

    public void fbclick(View view){
        Intent intent = new Intent(MainMenu.this, Feedback.class);
        startActivity(intent);
    }

    public void hdclick(View view){
        Intent intent = new Intent(MainMenu.this, HelpDesk.class);
        startActivity(intent);
    }

}
