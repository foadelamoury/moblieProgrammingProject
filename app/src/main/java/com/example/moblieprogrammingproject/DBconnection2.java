package com.example.moblieprogrammingproject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBconnection2 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notes_db";
    private static final int DATABASE_VERSION = 1;


    public DBconnection2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableUsersCreate = "CREATE TABLE USERBOOKS (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FOREIGN KEY(user_id) REFERENCES Users(_id),"+"FOREIGN KEY(book_id) REFERENCES notes(_id));" ;
        sqLiteDatabase.execSQL(tableUsersCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {


    }

//    public void insertUserBook(int id, String name) {
//        SQLiteDatabase db = getWritableDatabase();
//        String query = "INSERT INTO Users (ID, Username) VALUES(" + id + ",'" + name +"');";
//
//        db.execSQL(query);
//        db.close();
//
//
//
//    }

    public boolean insertUserBookAuto(int id, int userId,int bookId) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", userId);
        values.put("book_id", bookId);

        long resultID = db.insert("USERBOOKS", null, values);
        db.close();
        return resultID > -1;
    }

    public ArrayList<Integer> getUsers() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM USERBOOKS";
        Cursor result = db.rawQuery(query, null);
        ArrayList<Integer> res = new ArrayList<>();
        if (result.moveToFirst()) {
            do {
                int id = result.getInt(0);
                int userId = result.getInt(1);
                int bookId = result.getInt(1);


                res.add(id);
                res.add(userId);
                res.add(bookId);

            } while (result.moveToNext());
        }
        db.close();
        return res;
    }

    public Cursor getUsers2() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM USERBOOKS";
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
        int res = db.delete("USERBOOKS", "ID = ?", new String[]{String.valueOf(id)});
        db.close();
        return res > 0;
    }

}
