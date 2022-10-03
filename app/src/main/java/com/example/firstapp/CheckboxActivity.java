package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {

    private CheckBox checkBoxHarry, checkBoxJoker, checkBoxMatrix;
    private RadioGroup rgMaritalStatus;
    private ProgressBar progressBar;
    private ProgressBar progressBarHorizontal;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        //INSTANCIAR LOS CHECKBOX
        checkBoxHarry = findViewById(R.id.checkboxHarry);
        checkBoxJoker = findViewById(R.id.checkboxJoker);
        checkBoxMatrix = findViewById(R.id.checkboxMatrix);

        //INSTANCIAR LOS REDGROUP
        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);

        //INSTANCIAR PROGRESSBAR
        progressBar = findViewById(R.id.progressBar);
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < 10; i++){
                    progressBarHorizontal.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();
        int progress = progressBarHorizontal.getProgress();

        //Cada vez que cambie, se notará por este metodo
        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rbMarried:
                        Toast.makeText(CheckboxActivity.this, "You are married", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(CheckboxActivity.this, "You are Single", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbInRel:
                        Toast.makeText(CheckboxActivity.this, "You are in a relationship", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        break;
                }
            }
        });

        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(CheckboxActivity.this, "You have watched Harry Potter!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CheckboxActivity.this, "You need to watch Harry Potter!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}