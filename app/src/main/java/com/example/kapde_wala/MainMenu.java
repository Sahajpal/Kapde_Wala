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

    public void pudclick(View view){
        Intent intent = new Intent(MainMenu.this, PickUpDate.class);
        startActivity(intent);
    }

    public void doaclick(View view){
        Intent intent = new Intent(MainMenu.this, DropOffAvailability.class);
        startActivity(intent);
    }

    public void lrclick(View view){
        Intent intent = new Intent(MainMenu.this, LaundryRecord.class);
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
