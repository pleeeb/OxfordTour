package com.example.a18049192.oxfordtour;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
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


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class MainPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static UserViewModel userViewModel;
    public static TGModelView tgModelView;
    private static boolean loggedin = false;
    public static List<User> allUsers;
    public static List<TG> allTG;
    public static ArrayList<String> obcSignup = new ArrayList<>();
    public static ArrayList<String> bfSignup = new ArrayList<>();
    public static ArrayList<String> olfSignup = new ArrayList<>();
    public static ArrayList<String> miSignup = new ArrayList<>();
    public static ArrayList<String> wwrySignup = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
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

        tgModelView = ViewModelProviders.of(this).get(TGModelView.class);
        tgModelView.TGInfo().observe(this, new Observer<List<TG>>() {
            @Override
            public void onChanged(List<TG> tgs) {
                allTG = tgs;
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

    private void setLocale (String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
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
        switch (id){
            case R.id.action_settings:
                Toast.makeText(this, "English Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.English_Selection:
                Toast.makeText(this, "English Selected", Toast.LENGTH_SHORT).show();
                setLocale("en");
                recreate();
                return true;
            case R.id.Japanese_Selection:
                Toast.makeText(this, "日本語を選びました", Toast.LENGTH_SHORT).show();
                setLocale("ja-rJP");
                recreate();
                return true;
            case R.id.log_out:
                loggedin=false;
                Signup.firstname="";
                Signup.surname="";
                Signup.email="";
                Signup.age="";
                Signup.password="";
                Signup.isTG=false;
                recreate();
        }

        //noinspection SimplifiableIfStatement
       //if (id == R.id.action_settings) {
       //    return true;
       //}

       //else if(id==R.id.log_out){
       //    loggedin=false;
       //    Signup.firstname="";
       //    Signup.surname="";
       //    Signup.email="";
       //    Signup.age="";
       //    Signup.password="";
       //    Signup.isTG=false;
       //    recreate();
       //}

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
            if (loggedin) {
                if (Login.isTGbox) {
                    Intent intentTG = new Intent(this, TourguidePersonalInformationPage.class);
                    startActivity(intentTG);
                } else {
                    Intent intent = new Intent(this, PersonalInformationPage.class);
                    startActivity(intent);
                }
            } else {
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
            }
        }
        else if(id == R.id.nav_Forum){
            Intent intent = new Intent(this, ForumPage.class);
            startActivity(intent);


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
    public static boolean getLoggedin(){return loggedin;}

}

