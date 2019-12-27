package com.example.moblieprogrammingproject;

import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    EditText id,name;
    ListView lstvew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        id = findViewById(R.id.id);
        name=findViewById(R.id.name);
        lstvew= findViewById(R.id.listview);
    }
    DBconnection db = new DBconnection(this);
    public void save(View view) {


        db.insertUser(Integer.parseInt(id.getText().toString()),name.getText().toString());


    }

    public void delete(View view) {
        db.deleteUser(Integer.parseInt(id.getText().toString()));
    }

    public void update(View view) {
        db.updateUser(Integer.parseInt(id.getText().toString()),name.getText().toString());
    }

    public void list(View view) {
        ArrayList<String> res = db.getUsers();
        lstvew.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,res));

    }



    public void save2(View view) {

        boolean res=  db.insertUserAuto(Integer.parseInt(id.getText().toString()),name.getText().toString());
        if (!res)
            Toast.makeText(this,"record inserted before",Toast.LENGTH_LONG).show();
    }


    public void list2(View view) {
        Cursor res = db.getUsers2();


    }
}