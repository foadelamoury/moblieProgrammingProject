package com.example.moblieprogrammingproject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBconnection extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notes_db";
    private static final int DATABASE_VERSION = 1;


    public DBconnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableUsersCreate = "CREATE TABLE Users (" +
                "ID INTEGER PRIMARY KEY," +
                "Username VARCHAR(50) NOT NULL);" ;
        sqLiteDatabase.execSQL(tableUsersCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {


    }

    public void insertUser(int id, String name) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT INTO Users (ID, Username) VALUES(" + id + ",'" + name +"');";

        db.execSQL(query);
        db.close();



    }

    public boolean insertUserAuto(int id, String name ) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", id);
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
