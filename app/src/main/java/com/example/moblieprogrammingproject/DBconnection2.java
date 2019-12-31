package com.example.moblieprogrammingproject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class DBconnection2 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notes_db.db";
    private static final int DATABASE_VERSION = 1;


    public DBconnection2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String tableUserBookCreate = "CREATE TABLE USERBOOKS (" +
//                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +"USERID INTEGER NOT NULL,"+"BOOKID INTEGER NOT NULL,"+"FOREIGN KEY(USERID) REFERENCES Users(ID),"+"FOREIGN KEY(BOOKID) REFERENCES notes(ID));" ;
//        sqLiteDatabase.execSQL(tableUserBookCreate);
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

    public boolean insertUserBookAuto(String userId,String bookId) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("USERID", Integer.parseInt(userId));
        values.put("BOOKID", Integer.parseInt(bookId));

        long resultID = db.insert("USERBOOKS", null, values);
        db.close();
        return resultID > -1;
    }

    public ArrayList<String> getUserBook() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM USERBOOKS";
        Cursor result = db.rawQuery(query, null);
        ArrayList<String> res = new ArrayList<>();
        if (result.moveToFirst()) {
            do {
                int id = result.getInt(0);
                int userId = result.getInt(1);
                int bookId = result.getInt(2);


                res.add(String.valueOf(id));
                res.add(String.valueOf(userId));
                res.add(String.valueOf(bookId));

            } while (result.moveToNext());
        }
        db.close();
        return res;


//        SQLiteDatabase db = getReadableDatabase();
//        String query = "SELECT * FROM Users";
//        Cursor result = db.rawQuery(query, null);
//        ArrayList<String> res = new ArrayList<>();
//        if (result.moveToFirst()) {
//            do {
//                int id = result.getInt(0);
//                String name = result.getString(1);
//
//                res.add(String.valueOf(id));
//                res.add(name);
//
//            } while (result.moveToNext());
//        }
//        db.close();
//        return res;
    }

    public Cursor getBookPageData(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        title = "\'"+title+"\'";

        Cursor res = db.rawQuery("select * from notes WHERE TITLE = "+title, null);
        return res;
    }

    public Cursor getUserBook2() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM USERBOOKS";
        Cursor result = db.rawQuery(query, null);

        db.close();
        return result;
    }

    public boolean updateUserBook(int id, String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Username", name);
        int res = db.update("Users", values, "ID = ?", new String[]{String.valueOf(id)});
        db.close();
        return res > 0;
    }

    public boolean deleteUserBook(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int res = db.delete("USERBOOKS", "ID = ?", new String[]{String.valueOf(id)});
        db.close();
        return res > 0;
    }

}
