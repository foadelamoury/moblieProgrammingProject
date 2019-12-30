package com.example.moblieprogrammingproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    TextView Book,bookDescription,bookAuther;
    DatabaseConnection myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Book = (TextView) findViewById(R.id.bookName);
        bookDescription = (TextView) findViewById(R.id.bookDescription);
        bookAuther = (TextView) findViewById(R.id.bookAuthor);

        myDb = new DatabaseConnection(this);
        Book.setText(getIntent().getStringExtra("bookName"));

        viewBookPage();


    }

    public void viewBookPage() {
        String BookName=(String)Book.getText();
        Cursor res = myDb.getBookPage(BookName);
        Toast.makeText(Main4Activity.this,BookName,Toast.LENGTH_LONG).show();

        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Name :"+ res.getString(1)+"\n");
            buffer.append("Surname :"+ res.getString(2)+"\n");
            buffer.append("Marks :"+ res.getString(3)+"\n\n");
            bookDescription.setText(res.getString(2));

            bookAuther.setText(res.getString(3));
        }

        // Show all data
        showMessage("Data",buffer.toString());
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
