package com.example.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String PERSONS_TABLE = "PERSONS_TABLE";
    public static final String COLUMN_PERSON_NAME = "PERSON_NAME";
    public static final String COLUMN_PERSON_AGE = "PERSON_AGE";
    public static final String COLUMN_ACTIVE_PERSON = "ACTIVE_PERSON";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "persons.db", null, 1);
    }

    //this is called the first time a database is accessed. There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + PERSONS_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PERSON_NAME + " TEXT, " + COLUMN_PERSON_AGE + " INT, " + COLUMN_ACTIVE_PERSON + " BOOL) ";
        db.execSQL(createTableStatement);
    }

    //this is called if the database version number changes. It prevents previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean addOne(PersonModel personModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PERSON_NAME, personModel.getName());
        cv.put(COLUMN_PERSON_AGE, personModel.getAge());
        cv.put(COLUMN_ACTIVE_PERSON, personModel.isActive());

        long insert = db.insert(PERSONS_TABLE, null, cv);
        if (insert == -1){
            return false;
        } else {
            return true;
        }

    }
}
