package com.example.moblieprogrammingproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    TextView Book,bookDescription,bookAuther;
    Button buttonAddData,buttonViewData;
    EditText editId,editUserId,editBookId;

    DatabaseConnection myDatabase;
    DBconnection2 myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        editId = (EditText) findViewById(R.id.TheId);
        editUserId = (EditText) findViewById(R.id.UserId);
        editBookId = (EditText) findViewById(R.id.BookId);

        Book = (TextView) findViewById(R.id.bookName);

        bookDescription = (TextView) findViewById(R.id.bookDescription);
        bookAuther = (TextView) findViewById(R.id.bookAuthor);
        buttonAddData= (Button)findViewById(R.id.buttonAddData);
                buttonViewData = (Button)findViewById(R.id.buttonShowData);

        myDb = new DBconnection2(this);
        myDatabase=new DatabaseConnection(this);
        Book.setText(getIntent().getStringExtra("bookName"));

        viewBookPageData();


    }
    public  void AddData() {
        buttonAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertUserBookAuto(editId.getText().toString(),
                                editUserId.getText().toString(),
                                editBookId.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(Main4Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main4Activity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void viewBookPageData() {
        String BookName=(String)Book.getText();
        Cursor res =  myDatabase.getBookPage(BookName);
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

    public void viewUserBookTable(View view) {



                        Cursor res = (Cursor) myDb.getUserBook();

                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("userId :"+ res.getString(1)+"\n");
                            buffer.append("bookId :"+ res.getString(2)+"\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());



    }


    public void addUserBookData(View view)
    {
        boolean isInserted = myDb.insertUserBookAuto(editId.getText().toString(),
                editUserId.getText().toString(),
                editBookId.getText().toString() );
        if(isInserted == true)
            Toast.makeText(Main4Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(Main4Activity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
    }

        private void showMessage(String title, String Message) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(Message);
            builder.show();
        }
    }



