package com.example.a18049192.oxfordtour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonalInformationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information_page);

        Button Transport_Button = findViewById(R.id.DetailsEditTransportButton);
        Transport_Button.setOnClickListener(new View.OnClickListener() {
            //loads the EditDetailsPage
            @Override
            public void onClick(View v) {
                Intent PersonalInformationEditPage = new Intent(v.getContext(), PersonalInformationEditPage.class);
                startActivity(PersonalInformationEditPage);
            }
        });
    }
}
