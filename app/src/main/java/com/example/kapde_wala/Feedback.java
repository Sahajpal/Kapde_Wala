package com.example.kapde_wala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        final EditText to = (EditText) findViewById(R.id.sendTo);
        final EditText subject = (EditText) findViewById(R.id.subject);
        final EditText message = (EditText) findViewById(R.id.emailText);

        Button send = (Button) findViewById(R.id.sendEmail);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toS = to.getText().toString();
                String subS = subject.getText().toString();
                String mesS = message.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                //email.putExtra(Intent.EXTRA_EMAIL, toS);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] {toS});
                email.putExtra(Intent.EXTRA_SUBJECT, subS);
                email.putExtra(Intent.EXTRA_TEXT, mesS);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose app to send email"));

            }
        });

    }
}
