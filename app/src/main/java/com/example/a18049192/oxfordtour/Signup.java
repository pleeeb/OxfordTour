package com.example.a18049192.oxfordtour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    public static final String USER_ADDED = "new_user";

    private EditText firstNameNewUser;
    private EditText surnameNewUser;
    private EditText emailNewUser;
    private EditText ageNewUser;
    private EditText passwordNewUser;

    public static String id;
    public static String firstname;
    public static String surname;
    public static String email;
    public static String age;
    public static String password;
    public static boolean isTG = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firstNameNewUser = findViewById(R.id.firstNameText);
        surnameNewUser = findViewById(R.id.surnameText);
        emailNewUser = findViewById(R.id.emailText);
        ageNewUser = findViewById(R.id.ageText);
        passwordNewUser = findViewById(R.id.passwordText);

        CheckBox tgCheckbox = findViewById(R.id.checkBox);
        tgCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isTG=!isTG;
            }
        });

        Button button = findViewById(R.id.SaveButton);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent resultIntent = new Intent();

                //If any fields are empty return to mainpage and say user creation failed.
                if (TextUtils.isEmpty(firstNameNewUser.getText())||
                TextUtils.isEmpty(surnameNewUser.getText())||
                TextUtils.isEmpty(emailNewUser.getText())||
                TextUtils.isEmpty(ageNewUser.getText())||
                TextUtils.isEmpty(passwordNewUser.getText())){
                    setResult(RESULT_CANCELED, resultIntent);
                }
                //Save user input into variables and return to main page with result.
                else {
                    firstname = firstNameNewUser.getText().toString();
                    surname = surnameNewUser.getText().toString();
                    email = emailNewUser.getText().toString();
                    age = ageNewUser.getText().toString();
                    password = passwordNewUser.getText().toString();
                    resultIntent.putExtra(USER_ADDED, firstname);
                    setResult(RESULT_OK, resultIntent);
                }

                finish();
            }
        });
    }
}
