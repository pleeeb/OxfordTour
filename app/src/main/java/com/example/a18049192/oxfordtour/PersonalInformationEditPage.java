package com.example.a18049192.oxfordtour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalInformationEditPage extends AppCompatActivity {
    EditText firstname;
    EditText lastname;
    EditText age;
    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information_edit_page);

        firstname = findViewById(R.id.EditFirstname);
        lastname = findViewById(R.id.EditLastname);
        age = findViewById(R.id.EditAge);
        email = findViewById(R.id.EditEmail);
        password = findViewById(R.id.EditPassword);

        Button Save_Button = findViewById(R.id.SaveDetailsButton);
        Save_Button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Signup.firstname = firstname.getText().toString();
                Signup.surname = lastname.getText().toString();
                Signup.age = age.getText().toString();
                Signup.email = email.getText().toString();
                Signup.password = password.getText().toString();
                finish();
            }
        });
    }
}