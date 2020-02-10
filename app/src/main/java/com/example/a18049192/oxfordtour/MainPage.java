package com.example.a18049192.oxfordtour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Entity;


import java.util.List;
import java.util.UUID;

public class MainPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int SIGNUP_REQUEST_CODE = 1;
    public static UserViewModel userViewModel;
    private static boolean loggedin = false;
    public static List<User> allUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, Signup.class);
                startActivityForResult(intent, SIGNUP_REQUEST_CODE);
            }
        });*/

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.userInfo().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                allUsers = users;
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        //Change Signup/Login button to Account Info after login.
        if (loggedin){
            Menu menu = navigationView.getMenu();
            MenuItem signup_login = menu.findItem(R.id.nav_signup);
            signup_login.setTitle("Account Info");
        }
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGNUP_REQUEST_CODE && resultCode == RESULT_OK){

            //Code to insert user
            final String user_id = UUID.randomUUID().toString();
            User user = new User(user_id, data.getStringExtra(Signup.USER_ADDED),
                    Signup.surname, Signup.email, Signup.age, Signup.password);
            userViewModel.insert(user);

            Toast.makeText(getApplicationContext(),R.string.saved,Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),R.string.not_saved, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_events) {
            Intent intent = new Intent(this, EventsPage.class);
            startActivity(intent);
        } else if (id == R.id.nav_places) {
            Intent intent = new Intent(this, PlacesPageMenu.class);
            startActivity(intent);
        } else if (id == R.id.nav_map) {
            Intent intent = new Intent(this, MapsPage.class);
            startActivity(intent);
        } else if (id == R.id.nav_ratings) {
            Intent intent = new Intent(this, Ratings.class);
            startActivity(intent);
        } else if (id == R.id.nav_signup) {
            if (loggedin){
                //Insert code to link to account page.
            }
            else {
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
            }

        /*} else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
            return true;
        }

    public static void setLoggedin(boolean log){loggedin = log; }



    public static int getSignupRequestCode(){
        return SIGNUP_REQUEST_CODE;
    }
}

