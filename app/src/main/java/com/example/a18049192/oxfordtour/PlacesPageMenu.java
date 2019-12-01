package com.example.a18049192.oxfordtour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PlacesPageMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_page_menu);

        Button landmarks_button = findViewById(R.id.Landmarks);
        landmarks_button.setOnClickListener(new View.OnClickListener(){
            //loads the places page (which is now the landmarks page) from the first button on the page.
            @Override
            public void onClick(View v) {
                Intent landmarks_page = new Intent(v.getContext(), PlacesPage.class);
                startActivity(landmarks_page);
            }
        });

        Button restaurants_button = findViewById(R.id.Restaurants);
        restaurants_button.setOnClickListener(new View.OnClickListener(){
            //loads the restaurants page.
            @Override
            public void onClick(View v) {
                Intent restaurants_page = new Intent(v.getContext(), RestaurantsPage.class);
                startActivity(restaurants_page);
            }
        });
    }
}
