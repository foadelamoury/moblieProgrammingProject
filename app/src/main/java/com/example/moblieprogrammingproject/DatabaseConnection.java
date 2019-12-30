package com.example.moblieprogrammingproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseConnection extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "notes_db.db";
    public static final String TABLE_NAME = "notes";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TITLE";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "AUTHOR";
    public static final String COL_5 = "TIMESTAMP";

String[] columnNames ={COL_1,COL_2,COL_3,COL_4};

    public DatabaseConnection(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,DESCRIPTION TEXT,AUTHOR TEXT,TIMESTAMP DATETIME DEFAULT CURRENT_TIMESTAMP)");
//        String tableUsersCreate = "CREATE TABLE Users (" +
//                "ID INTEGER PRIMARY KEY," +
//                "Username VARCHAR(50) NOT NULL);" ;
//        db.execSQL(tableUsersCreate);
//        String tableUserBookCreate = "CREATE TABLE USERBOOKS (" +
//                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +"USERID INTEGER NOT NULL,"+"BOOKID INTEGER NOT NULL,"+"FOREIGN KEY(USERID) REFERENCES Users(ID),"+"FOREIGN KEY(BOOKID) REFERENCES notes(ID));" ;
//        db.execSQL(tableUserBookCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
//        db.execSQL("DROP TABLE IF EXISTS Users");
//        db.execSQL("DROP TABLE IF EXISTS USERBOOKS");
//
//        onCreate(db);
    }

    public boolean insertData(String title,String description,String author) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_2,title);
//        contentValues.put(COL_3,description);
//        contentValues.put(COL_4,author);
//
//        long result = db.insert(TABLE_NAME,null ,contentValues);
//        if(result == -1)
//            return false;
//        else
//            return true;

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,title);
        values.put(COL_3,description);
        values.put(COL_4,author);

        long resultID =  db.insert(TABLE_NAME,null ,values);
        db.close();
        return resultID > -1;
    }
    public void insertData2(String title, String description, String author) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT INTO ,'"+TABLE_NAME+"', (TITLE,DESCRIPTION,AUTHOR) VALUES(" + title + ",'" + description +"','" + author +"');";


        db.execSQL(query);
        db.close();


    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


    public Cursor getBookPage(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        title = "\'"+title+"\'";
        Log.i("title",title);

        Cursor res = db.rawQuery("select * from "+TABLE_NAME +" WHERE TITLE = "+title, null);
        return res;
    }
    //testing something


    public boolean updateData(String id,String title,String description,String author) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,title);
        contentValues.put(COL_3,description);
        contentValues.put(COL_4,author);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}