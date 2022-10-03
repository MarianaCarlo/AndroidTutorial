package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class TutorialSQLiteActivity extends AppCompatActivity {

    //references to buttons and other controls on the layout
    Button buttonView, buttonAdd;
    EditText editName, editAge;
    Switch SwitchActivePerson;
    ListView listPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_sqlite);

        buttonView = findViewById(R.id.btnViewAll);
        buttonAdd = findViewById(R.id.btnAdd);
        editName = findViewById(R.id.namePerson);
        editAge = findViewById(R.id.agePerson);
        SwitchActivePerson = findViewById(R.id.switchActiveUser);
        listPersons = findViewById(R.id.listPersons);

        //button listeners for the add and view all buttons
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TutorialSQLiteActivity.this, "Add button", Toast.LENGTH_SHORT).show();
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TutorialSQLiteActivity.this, "View button", Toast.LENGTH_SHORT).show();
            }
        });

    }
}