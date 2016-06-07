package com.example.vergth.chi_menu_layout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
        SharedPreferences s= PreferenceManager.
                getDefaultSharedPreferences(this);


        String warnS=s.getString("warn","0");
        float warn=0;
        if(warnS.length()>0){
            warn= Float.valueOf(warnS);
        }
        vesoda = getIntent().getFloatExtra("vesoda", 0);
        veksoda = getIntent().getFloatExtra("veksoda", 0);

        float out = sp.getFloat("ypoloipo", -1);

        float ypolfinal = vesoda - veksoda + out;
        editor.putFloat("ypoloipo", ypolfinal);
        editor.commit();

        ypol.setText(Float.toString(ypolfinal));
        if( ypolfinal<warn){
            Toast.makeText(Ypoloipo.this, "Το υπόλοιό σας είναι χαμηλό!",
                    Toast.LENGTH_LONG).show();
        }


    }
}
