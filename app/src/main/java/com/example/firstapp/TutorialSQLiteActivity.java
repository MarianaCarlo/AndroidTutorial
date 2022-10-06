package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class TutorialSQLiteActivity extends AppCompatActivity {

    //references to buttons and other controls on the layout
    Button buttonView, buttonAdd;
    EditText editName, editAge;
    Switch switchActivePerson;
    ListView listPersons;
    ArrayAdapter personArrayAdapter;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_sqlite);

        buttonView = findViewById(R.id.btnViewAll);
        buttonAdd = findViewById(R.id.btnAdd);
        editName = findViewById(R.id.namePerson);
        editAge = findViewById(R.id.agePerson);
        switchActivePerson = findViewById(R.id.switchActiveUser);
        listPersons = findViewById(R.id.listPersons);

        dataBaseHelper = new DataBaseHelper(TutorialSQLiteActivity.this);
        ShowPersonsOnListView(dataBaseHelper);


        //button listeners for the add and view all buttons
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PersonModel personModel;

                try {
                    personModel = new PersonModel(-1, editName.getText().toString(), Integer.parseInt(editAge.getText().toString()), switchActivePerson.isChecked());
                    Toast.makeText(TutorialSQLiteActivity.this, personModel.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(TutorialSQLiteActivity.this, "Error creting person", Toast.LENGTH_SHORT).show();
                    personModel = new PersonModel(-1, "error", 0, false);
                }

                DataBaseHelper  dataBaseHelper = new DataBaseHelper(TutorialSQLiteActivity.this);

                //ANADIENDO UN NUEVO PERSON
                Boolean success = dataBaseHelper.addOne(personModel);
                Toast.makeText(TutorialSQLiteActivity.this, "Success " + success, Toast.LENGTH_SHORT).show();


                ShowPersonsOnListView(dataBaseHelper);
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(TutorialSQLiteActivity.this);

                ShowPersonsOnListView(dataBaseHelper);

                //Toast.makeText(TutorialSQLiteActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void ShowPersonsOnListView(DataBaseHelper dataBaseHelper2) {
        personArrayAdapter = new ArrayAdapter<PersonModel>(TutorialSQLiteActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper2.getEveryone());
        listPersons.setAdapter(personArrayAdapter);
    }
}