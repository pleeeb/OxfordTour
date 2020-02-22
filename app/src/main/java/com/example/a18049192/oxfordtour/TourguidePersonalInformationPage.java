package com.example.a18049192.oxfordtour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TourguidePersonalInformationPage extends AppCompatActivity {
    TextView firstname;
    TextView lastname;
    TextView age;
    TextView email;
    TextView password;



        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tourguide_personal_information_page);

            if (Signup.isTG) {
                firstname = findViewById(R.id.User_Firstname_Display);
                lastname = findViewById(R.id.User_Lastname_Display);
                age = findViewById(R.id.User_Age_Display);
                email = findViewById(R.id.User_Email_Display);
                password = findViewById(R.id.User_Password_Display);
                //display user information//
                firstname.setText(Signup.firstname);
                lastname.setText(Signup.surname);
                age.setText(Signup.age);
                email.setText(Signup.email);
                password.setText(Signup.password);

                Button Transport_Button = findViewById(R.id.DetailsEditTransportButton);
                Transport_Button.setOnClickListener(new View.OnClickListener() {
                    //loads the EditDetailsPage for tour guide
                    @Override
                    public void onClick(View v) {
                        Intent TourguidePersonalInformationEditPage = new Intent(v.getContext(), TourguidePersonalInformationEditPage.class);
                        startActivity(TourguidePersonalInformationEditPage);
                    }
                });
            }
        }
}