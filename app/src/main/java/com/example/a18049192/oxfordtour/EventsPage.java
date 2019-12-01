package com.example.a18049192.oxfordtour;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static com.example.a18049192.oxfordtour.R.array.Oxford_Boxing_Championships;
import static com.example.a18049192.oxfordtour.R.id.Beacon_Festival;

public class EventsPage<Spinner3, Spinner4, Spinner2, Spinner1> extends AppCompatActivity {

    private int Oxford_Literary_Festival;
    private int Milton_Impossible;

    public EventsPage() {
        super();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_page);


        Spinner mySpinner = findViewById(R.id.Oxford_Boxing);

        ArrayAdapter <String> myAdapter = new ArrayAdapter<String>(EventsPage.this,android.R.
                layout.simple_dropdown_item_1line,
                getResources().getStringArray(Oxford_Boxing_Championships));

        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner.setAdapter(myAdapter);


        View mySpinner1 = findViewById(Beacon_Festival);

        ArrayAdapter <String> myAdapter = new ArrayAdapter<String>(EventsPage.this,android.R.
                layout.simple_dropdown_item_1line,
                getResources().getStringArray(R.array.Beacon_Festival));

        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner1.setAdapter(myAdapter);


        View mySpinner2 = findViewById(Oxford_Literary_Festival);

        ArrayAdapter <String> myAdapter = new ArrayAdapter<String>(EventsPage.this, android.R.
                layout.simple_dropdown_item_1line,
                getResources(). getStringArray(R.array.Oxford_Literary_Festival));

        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner2.setAdapter(myAdapter);


        View mySpinner3 = findViewById(Milton_Impossible);

        ArrayAdapter <String> myAdapter = new ArrayAdapter<String>(EventsPage.this, android.R.
                layout.simple_dropdown_item_1line,
                getResources(). getStringArray(R.array.Milton_Impossible));

        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner3.setAdapter(myAdapter);


        View mySpinner4 = findViewById(We_will_rock_you);

        ArrayAdapter <String> myAdapter = new ArrayAdapter<String>(EventsPage.this, android.R.
                layout.simple_dropdown_item_1line,
                getResources(). getStringArray(R.array.We_will_rock_you));

        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner4.setAdapter(myAdapter);



    }
}
