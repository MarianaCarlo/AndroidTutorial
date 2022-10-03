package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MaterialDesignActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RelativeLayout parentRelative;
    private Button btnShowSnakBar;
    private MaterialCardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        //PARA EL BOTON FLOTANTE
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MaterialDesignActivity.this, "Fab click", Toast.LENGTH_SHORT).show();
            }
        });

        // PARA EL SNACKBAR
        parentRelative = findViewById(R.id.parentRelative);
        btnShowSnakBar = findViewById(R.id.btnShowSnakBar);

        btnShowSnakBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackbar();
            }
        });

        //PARA EL CARDVIEW
        cardView = findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MaterialDesignActivity.this, "Card clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showSnackbar() {
        Snackbar.make(parentRelative, "This is a snackBar", Snackbar.LENGTH_SHORT)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MaterialDesignActivity.this, "Retry clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.blueOcean))
                .setTextColor(Color.YELLOW)
                .show();
    }


}