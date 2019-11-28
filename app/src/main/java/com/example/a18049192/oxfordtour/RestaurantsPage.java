package com.example.a18049192.oxfordtour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RestaurantsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_page);

        Button the_oxford_kitchen_button = findViewById(R.id.OxfordKitchen);
        the_oxford_kitchen_button.setOnClickListener(new View.OnClickListener(){
            //loads the Oxford Kitchen page.
            @Override
            public void onClick(View v) {
                Intent the_oxford_kitchen_page = new Intent(v.getContext(), the_oxford_kitchen.class);
                startActivity(the_oxford_kitchen_page);
            }
        });

        Button cherwell_boathouse_button = findViewById(R.id.CherwellBoathouse);
        cherwell_boathouse_button.setOnClickListener(new View.OnClickListener(){
            //loads the Cherwell Boathouse page.
            @Override
            public void onClick(View v) {
                Intent cherwell_boathouse_page = new Intent(v.getContext(), Cherwell_Boathouse.class);
                startActivity(cherwell_boathouse_page);
            }
        });

        Button shipstreet_button = findViewById(R.id.No1ShipStreet);
        shipstreet_button.setOnClickListener(new View.OnClickListener(){
            //loads the No1 Ship Street page.
            @Override
            public void onClick(View v) {
                Intent shipstreet_page = new Intent(v.getContext(), No1ShipStreet.class);
                startActivity(shipstreet_page);
            }
        });
    }
}
