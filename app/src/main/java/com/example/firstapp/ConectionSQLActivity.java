package com.example.firstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConectionSQLActivity extends AppCompatActivity {

    EditText name, contact, dateB;
    Button readButton,insertButton, updateButton, deleteButton ;
    DBHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conection_sqlactivity);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dateB = findViewById(R.id.dateB);

        insertButton =  findViewById(R.id.btnInsert);
        readButton =  findViewById(R.id.btnRead);
        updateButton =  findViewById(R.id.btnUpdate);
        deleteButton =  findViewById(R.id.btnDelete);

        database = new DBHelper(this);

        //INSERT
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dateB.getText().toString();

                Boolean checkInsertData = database.insertUserData(nameTXT, contactTXT, dobTXT);
                if (checkInsertData == true) {
                    Toast.makeText(ConectionSQLActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ConectionSQLActivity.this, "Not Inserted!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //UPDATE
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dateB.getText().toString();

                Boolean checkUpdateData = database.updateUserData(nameTXT, contactTXT, dobTXT);
                if (checkUpdateData == true) {
                    Toast.makeText(ConectionSQLActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ConectionSQLActivity.this, "Not Updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //DELETE
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();

                Boolean checkDeleteData = database.deleteUserData(nameTXT);
                if (checkDeleteData == true) {
                    Toast.makeText(ConectionSQLActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ConectionSQLActivity.this, "Not Deleted!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //READ
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = database.readUserData();
                if(res.getCount() == 0){
                    Toast.makeText(ConectionSQLActivity.this, "No entries exist!", Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name:" + res.getString(0) + "\n");
                    buffer.append("Contact:" + res.getString(1) + "\n");
                    buffer.append("Date of Birth:" + res.getString(2) + "\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(ConectionSQLActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });


    }
}