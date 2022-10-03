package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DifferentXMLActivity extends AppCompatActivity {

    private TextView txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_xmlactivity);
        txtHello = findViewById(R.id.txtHello);
        txtHello.setText(R.string.hello);
    }

    //Ctrñ + O para ver todos los metodos que se puede hacer

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings_menu:
                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.alarm_menu:
                Toast.makeText(this, "Alarm selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}