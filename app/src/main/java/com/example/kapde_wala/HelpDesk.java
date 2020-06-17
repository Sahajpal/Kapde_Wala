package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HelpDesk extends AppCompatActivity {

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_help_desk);
            Button email1 = (Button) findViewById(R.id.email1);
            Button email2 = (Button) findViewById(R.id.email2);
            Button call1 = (Button) findViewById(R.id.call1);
            Button call2 = (Button) findViewById(R.id.call2);

            email1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "Raghav2011rv@gmail.com", null));
                    startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                }
            });
            email2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "itsyaboiassmo@gmail.com", null));
                    startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                }
            });
            call1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialContactPhone("9646930030");
                }
            });
            call2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialContactPhone("9582053821");
                }
            });
        }

        private void dialContactPhone ( final String phoneNumber){
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
        }
}

