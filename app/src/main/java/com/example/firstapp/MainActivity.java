package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView showName;
    private EditText editName;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnHello2:
                //System.out.println("Hello");

                Toast.makeText(this, "This is a toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSend:
                showName.setText("Your name is " + editName.getText().toString());
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello2 = findViewById(R.id.btnHello2);
        /*btnHello2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hello");
            }
        });*/
        btnHello2.setOnClickListener(this);

        //para edit
        editName = findViewById(R.id.editTxtName);
        showName = findViewById(R.id.textName);
        Button btnShow = findViewById(R.id.btnSend);
        btnShow.setOnClickListener(this);

    }

    public void onBtnClick(View view){
        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText("Hello again");
    }

    public void sendMenuAll(View view) {
        Intent myintent = new Intent(this, MenuAllActivity.class);
        startActivity(myintent);
    }

}