package com.example.moblieprogrammingproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    public static String message="sir";
    ListView listView;
    EditText id,name;
    DBHelper db2;
    SQLiteOpenHelper sqLiteOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db2= new DBHelper(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ChatFragment()).commit();

            navigationView.setCheckedItem(R.id.nav_chat);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public  void GoToBook(View view){

        Toast.makeText(this,"Testing101",Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, Main2Activity.class);
//        if( TextUtils.isEmpty(editName.getText())){
//
//            editName.setError( "Name is required!" );}
//        else{
        message="sir";
//                            editName.getText().toString();
        i.putExtra("personName", message);
        startActivity(i);
//        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MessageFragment()).commit();
                break;
            case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChatFragment()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_book:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BookFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public static class SharedPref {
        private static final String MY_PREFS = "myPrefs";
        private static SharedPref mInstance;
        private static Context mCtx;

        private SharedPref(Context context) {
            mCtx = context;
        }

        public static synchronized SharedPref getmInstance(Context context) {
            if (mInstance == null) {
                mInstance = new SharedPref(context);
            }
            return mInstance;
        }

        public boolean saveUserInfo(String id, String name) {
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("", id);
            editor.putString("name", message);
            editor.apply();
            return true;
        }

        public String getId() {
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
            return sharedPreferences.getString("user_id", null);
        }

        public String getName() {
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
            return sharedPreferences.getString("name", null);
        }

        public void clearSession() {
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
            sharedPreferences.edit().clear().apply();
        }

    }


}



