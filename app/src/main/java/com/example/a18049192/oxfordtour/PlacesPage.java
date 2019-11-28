package com.example.a18049192.oxfordtour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlacesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_page);

        Button ashmuseum = findViewById(R.id.AshMusButton);
        ashmuseum.setOnClickListener(new View.OnClickListener(){
            //loads the page for the Ashmolean Museum from the first button on the page.
            @Override
            public void onClick(View v) {
                Intent ashpage = new Intent(v.getContext(), AshmoleanMusuem.class);
                startActivity(ashpage);
            }
        });

        Button christbutton = findViewById(R.id.ChristChurch);
        christbutton.setOnClickListener(new View.OnClickListener(){
            //loads the page for Christchurch from the second button on the page.
            @Override
            public void onClick(View v) {
                Intent ph2page = new Intent(v.getContext(), ChristChurch.class);
                startActivity(ph2page);
            }
        });
        /*

        Button magdalenbutton = findViewById(R.id.MagdalenCollege);
        magdalenbutton.setOnClickListener(new View.OnClickListener(){
            //loads the page for the Ashmolean Museum from the first button on the page.
            @Override
            public void onClick(View v) {
                Intent ph3page = new Intent(this, MagdalenCollege.class);
                startActivity(ph3page);
            }
        });*/
    }
}
