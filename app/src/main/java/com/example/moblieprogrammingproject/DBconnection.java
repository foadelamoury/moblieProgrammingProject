package com.example.moblieprogrammingproject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBconnection extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notes_db.db";
    private static final int DATABASE_VERSION = 1;


    public DBconnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table notes (ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,DESCRIPTION TEXT,AUTHOR TEXT,PRICE INTEGER DEFAULT 0,TIMESTAMP DATETIME DEFAULT CURRENT_TIMESTAMP)");
        String tableUsersCreate = "CREATE TABLE Users (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Username VARCHAR(50) NOT NULL,"+
                "WALLET INTEGER DEFAULT 0);"
                ;
        db.execSQL(tableUsersCreate);
        String tableUserBookCreate = "CREATE TABLE USERBOOKS (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +"USERID INTEGER NOT NULL,"+"BOOKID INTEGER NOT NULL,"+"FOREIGN KEY(USERID) REFERENCES Users(ID),"+"FOREIGN KEY(BOOKID) REFERENCES notes(ID));" ;
        db.execSQL(tableUserBookCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS notes");
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS USERBOOKS");

        onCreate(db);
    }

    public void insertUser(String name) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT INTO Users (Username) VALUES('" + name +"');";

        db.execSQL(query);
        db.close();



    }

    public boolean insertUserAuto(String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Username", name);

        long resultID = db.insert("Users", null, values);
        db.close();
        return resultID > -1;
    }

    public ArrayList<String> getUsers() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM Users";
        Cursor result = db.rawQuery(query, null);
        ArrayList<String> res = new ArrayList<>();
        if (result.moveToFirst()) {
            do {
                int id = result.getInt(0);
                String name = result.getString(1);


                res.add(String.valueOf(id));
                res.add(name);


            } while (result.moveToNext());
        }
        db.close();
        return res;
    }

    public Cursor getUsers2() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM Users";
        Cursor result = db.rawQuery(query, null);

        db.close();
        return result;
    }

    public boolean updateUser(int id, String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Username", name);
        int res = db.update("Users", values, "ID = ?", new String[]{String.valueOf(id)});
        db.close();
        return res > 0;
    }

    public boolean deleteUser(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int res = db.delete("Users", "ID = ?", new String[]{String.valueOf(id)});
        db.close();
        return res > 0;
    }

}
