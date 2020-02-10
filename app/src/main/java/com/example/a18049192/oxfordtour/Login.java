package com.example.a18049192.oxfordtour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

public class Login extends AppCompatActivity {

    private static final int SIGNUP_REQUEST_CODE = 1;
    static public String emailEntered;
    static public String passwordEntered;
    private EditText editText;
    private  EditText passText;
    private boolean userFound;
    private static int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText = findViewById(R.id.emailEnteredText);
        passText = findViewById(R.id.passwordEntered);

        Button signup = findViewById(R.id.Signup);
        signup.setOnClickListener(new View.OnClickListener(){
            //loads the page for the Ashmolean Museum from the first button on the page.
            @Override
            public void onClick(View v) {
                Intent signupPage = new Intent(v.getContext(), Signup.class);
                startActivityForResult(signupPage, Login.getSignupRequestCode());
            }
        });



        final Button login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                j=0;
                emailEntered = editText.getText().toString();
                passwordEntered = passText.getText().toString();
                for (User i : MainPage.allUsers){
                    if (!(i.getEmail().toLowerCase().equals(emailEntered.toLowerCase()))){
                        j+=1;
                    }
                    else {
                        userFound=true;
                        break;
                    }
                }
                if (userFound){
                    //Check password entered against database password
                    if (passwordEntered.equals(MainPage.allUsers.get(j).getPassword())) {
                        //Assign database values for logged in user into static public variables.
                        Signup.firstname = MainPage.allUsers.get(j).getFirstname();
                        Signup.surname = MainPage.allUsers.get(j).getSurname();
                        Signup.email = MainPage.allUsers.get(j).getEmail();
                        System.out.println(Signup.email);
                        Signup.age = MainPage.allUsers.get(j).getAge();
                        Signup.password = MainPage.allUsers.get(j).getPassword();
                        //Set user to logged in
                        MainPage.setLoggedin(true);
                        //Send message to screen
                        Toast.makeText(getApplicationContext(),"Logged in as "+Signup.email, Toast.LENGTH_LONG).show();
                        //Restart Mainpage
                        Intent intent = new Intent(v.getContext(), MainPage.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Invalid email/password", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"User not found", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGNUP_REQUEST_CODE && resultCode == RESULT_OK){

            //Code to insert user
            final String user_id = UUID.randomUUID().toString();
            User user = new User(user_id, data.getStringExtra(Signup.USER_ADDED),
                    Signup.surname, Signup.email, Signup.age, Signup.password);
            MainPage.userViewModel.insert(user);

            Toast.makeText(getApplicationContext(),R.string.saved,Toast.LENGTH_LONG).show();
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(),R.string.not_saved, Toast.LENGTH_LONG).show();
        }
    }

    public static int getSignupRequestCode(){
        return SIGNUP_REQUEST_CODE;
    }

}