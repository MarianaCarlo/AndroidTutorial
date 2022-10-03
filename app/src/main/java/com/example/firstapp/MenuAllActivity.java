package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuAllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_all);
    }

    public void sendCheckbox(View view) {
        Intent myintent = new Intent(this, CheckboxActivity.class);
        startActivity(myintent);
    }

    public void sendRelative(View view) {
        Intent myintent = new Intent(this, RelativeActivity.class);
        startActivity(myintent);
    }

    public void sendLinear(View view) {
        Intent myintent = new Intent(this, LinearActivity.class);
        startActivity(myintent);
    }

    public void sendConstraint(View view) {
        Intent myintent = new Intent(this, ConstraintActivity.class);
        startActivity(myintent);
    }

    public void sendImages(View view) {
        Intent myintent = new Intent(this, ImagesActivity.class);
        startActivity(myintent);
    }

    public void sendListView(View view) {
        Intent myintent = new Intent(this, ListViewActivity.class);
        startActivity(myintent);
    }

    public void sendDifferentXML(View view) {
        Intent myintent = new Intent(this, DifferentXMLActivity.class);
        startActivity(myintent);
    }

    public void sendMaterialDesign(View view) {
        Intent myintent = new Intent(this, MaterialDesignActivity.class);
        startActivity(myintent);
    }

    public void sendRecyclerView(View view) {
        Intent myintent = new Intent(this, RecyclerViewActivity.class);
        startActivity(myintent);
    }

    public void sendConnectionSql(View view) {
        Intent myintent = new Intent(this, ConectionSQLActivity.class);
        startActivity(myintent);
    }

    public void sendConnectionSQLite(View view) {
        Intent myintent = new Intent(this, TutorialSQLiteActivity.class);
        startActivity(myintent);
    }
}