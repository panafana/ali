package com.example.vergth.chi_menu_layout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Ypoloipo extends AppCompatActivity {


    public float vesoda, veksoda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ypoloipo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView ypol = (TextView) findViewById(R.id.textView8);
        SharedPreferences sp = getSharedPreferences("storage", Ypoloipo.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


        vesoda = getIntent().getFloatExtra("vesoda", 0);
        veksoda = getIntent().getFloatExtra("veksoda", 0);

        float out = sp.getFloat("ypoloipo", -1);

        float ypolfinal = vesoda - veksoda + out;
        editor.putFloat("ypoloipo", ypolfinal);
        editor.commit();

        ypol.setText(Float.toString(ypolfinal));
        if( ypolfinal<20.0){
            Toast.makeText(Ypoloipo.this, "Το υπόλοιό σας είναι χαμηλό!",
                    Toast.LENGTH_LONG).show();
        }


    }
}
