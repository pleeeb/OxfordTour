package com.example.a18049192.oxfordtour;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_page);

        Button obc = findViewById(R.id.SignUp1);
        Button bf = findViewById(R.id.SignUp2);
        Button olf = findViewById(R.id.SignUp3);
        Button mi = findViewById(R.id.SignUp4);
        Button wwry = findViewById(R.id.SignUp5);

        obc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainPage.getLoggedin()) {
                    MainPage.obcSignup.add(Signup.email);
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            }
        });

        bf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainPage.getLoggedin()) {
                    MainPage.bfSignup.add(Signup.email);
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            }
        });

        olf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainPage.getLoggedin()) {
                    MainPage.olfSignup.add(Signup.email);
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            }
        });

        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainPage.getLoggedin()) {
                    MainPage.miSignup.add(Signup.email);
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            }
        });

        wwry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainPage.getLoggedin()) {
                    MainPage.wwrySignup.add(Signup.email);
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            }
        });

        if(MainPage.obcSignup.contains(Signup.email)){
            obc.setText("Signed up");
            obc.setClickable(false);
        }

        if(MainPage.bfSignup.contains(Signup.email)){
            bf.setText("Signed up");
            bf.setClickable(false);
        }

        if(MainPage.olfSignup.contains(Signup.email)){
            olf.setText("Signed up");
            olf.setClickable(false);
        }

        if(MainPage.miSignup.contains(Signup.email)){
            mi.setText("Signed up");
            mi.setClickable(false);
        }

        if(MainPage.wwrySignup.contains(Signup.email)){
            wwry.setText("Signed up");
            wwry.setClickable(false);
        }
    }


}
