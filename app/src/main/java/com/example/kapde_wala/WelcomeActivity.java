package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    Button bot;
    Animation button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        bot =(Button)findViewById(R.id.bot);
        button = AnimationUtils.loadAnimation(this, R.anim.button);
        bot.setAnimation(button);

        ImageView img1 = (ImageView)findViewById(R.id.pa);
        Animation aniFade1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.per);
        img1.startAnimation(aniFade1);

        ImageView img = (ImageView)findViewById(R.id.tm);
        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.tap);
        img.startAnimation(aniFade);

        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}

