package com.example.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table UserDetails(name TEXT primary key, contact TEXT, dateOfBirth TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists UserDetails");
    }

    public Boolean insertUserData(String name, String contact, String dateB) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("dateOfBirth", dateB);

        long result = database.insert("UserDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateUserData(String name, String contact, String dateB) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dateOfBirth", dateB);
        Cursor cursor = database.rawQuery("SELECT * FROM UserDetails where name = ?", new String[] {name});
        if (cursor.getCount() > 0) {
            long result = database.update("UserDetails",  contentValues, "name =?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }


    }

    public Boolean deleteUserData(String name) {
        SQLiteDatabase database = this.getWritableDatabase();


        Cursor cursor = database.rawQuery("SELECT * FROM UserDetails where name = ?", new String[] {name});
        if (cursor.getCount() > 0) {
            long result = database.delete("UserDetails", "name =?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }


    }


    public Cursor readUserData() {
        SQLiteDatabase database = this.getWritableDatabase();


        Cursor cursor = database.rawQuery("SELECT * FROM UserDetails ", null);
        return cursor;
    }
}
