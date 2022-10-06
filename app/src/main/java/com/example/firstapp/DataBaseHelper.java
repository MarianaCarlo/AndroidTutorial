package com.example.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String PERSONS_TABLE = "PERSONS_TABLE";
    public static final String COLUMN_PERSON_NAME = "PERSON_NAME";
    public static final String COLUMN_PERSON_AGE = "PERSON_AGE";
    public static final String COLUMN_ACTIVE_PERSON = "ACTIVE_PERSON";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "persons.db", null, 1);
    }

    //this is called the first time a database is accessed. There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + PERSONS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PERSON_NAME + " TEXT, " + COLUMN_PERSON_AGE + " INT, " + COLUMN_ACTIVE_PERSON + " BOOL) ";
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

    public List<PersonModel> getEveryone(){
        List<PersonModel> returnList = new ArrayList<>();

        //get data from the database
        String queryString = "SELECT * FROM " + PERSONS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        //Cursor is the result set
        Cursor cursor = db.rawQuery(queryString, null);

        //cursor.moveToFirst returns a true if there were items selected
        if (cursor.moveToFirst()) {
            //loop through the cursor (result set) and create new customer objects. Put then into the return list
            do {
                int personID = cursor.getInt(0);
                String personName = cursor.getString(1);
                int personAge = cursor.getInt(2);
                boolean personActive = cursor.getInt(3) == 1 ? true: false; //ternary operation

                PersonModel newPerson = new PersonModel(personID, personName, personAge, personActive);
                returnList.add(newPerson);

            } while (cursor.moveToNext()); //this should be move to the next

        } else {
            //failure, do not add anything to the list
        }

        //close both the cursor and the db when done.
        cursor.close();
        db.close();

        return returnList;
    }

    public boolean deleteOne(PersonModel personModel) {
        //finds personModel in the database, if it founds, delete and return true.
        //if is not found, then return false
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + PERSONS_TABLE + " WHERE " + COLUMN_ID + " = " + personModel.getId();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }
    }
}
