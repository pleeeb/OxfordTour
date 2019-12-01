package com.example.a18049192.oxfordtour;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Ratings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button Place1button = findViewById(R.id.GoTo1);
        Place1button.setOnClickListener(new View.OnClickListener(){
            //loads the page for Christchurch from the second button on the page.
            @Override
            public void onClick(View v) {
                Intent p1page = new Intent(v.getContext(), AshmoleanMusuem.class);
                startActivity(p1page);
            }
        });
        Button Place2button = findViewById(R.id.GoTo2);
        Place2button.setOnClickListener(new View.OnClickListener(){
            //loads the page for Christchurch from the second button on the page.
            @Override
            public void onClick(View v) {
                Intent p2page = new Intent(v.getContext(), ChristChurch.class);
                startActivity(p2page);
            }
        });
        /*
        Button Place3button = findViewById(R.id.GoTo3);
        Place1button.setOnClickListener(new View.OnClickListener(){
            //loads the page for Christchurch from the second button on the page.
            @Override
            public void onClick(View v) {
                Intent p3page = new Intent(v.getContext(), MagdelanCollege.class);
                startActivity(p3page);
            }
        });  */

        Button Restaurant1button = findViewById(R.id.GoTo4);
        Restaurant1button.setOnClickListener(new View.OnClickListener(){
            //loads the page for Christchurch from the second button on the page.
            @Override
            public void onClick(View v) {
                Intent r1page = new Intent(v.getContext(), the_oxford_kitchen.class);
                startActivity(r1page);
            }
        });
        Button Restaurant2button = findViewById(R.id.GoTo5);
        Restaurant2button.setOnClickListener(new View.OnClickListener(){
            //loads the page for Christchurch from the second button on the page.
            @Override
            public void onClick(View v) {
                Intent r2page = new Intent(v.getContext(), Cherwell_Boathouse.class);
                startActivity(r2page);
            }
        });
        Button Restaurant3button = findViewById(R.id.GoTo6);
        Restaurant3button.setOnClickListener(new View.OnClickListener(){
            //loads the page for Christchurch from the second button on the page.
            @Override
            public void onClick(View v) {
                Intent r3page = new Intent(v.getContext(), No1ShipStreet.class);
                startActivity(r3page);
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
