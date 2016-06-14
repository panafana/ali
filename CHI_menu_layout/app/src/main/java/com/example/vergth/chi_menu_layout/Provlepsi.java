package com.example.vergth.chi_menu_layout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Provlepsi extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public String eisodos ,eksodos;
    public float veisodos=0,veksodos=0,outpout;
    public EditText eisodosText,eksodosText;
    public  TextView out;
    public boolean next=true;
    private Timer timer;
    public Button miden;
    public SharedPreferences sp ;
    public SharedPreferences.Editor editor ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_provlepsi);
        miden = (Button) findViewById(R.id.miden);
        eisodosText = (EditText) findViewById(R.id.eisodos);
        eksodosText = (EditText) findViewById(R.id.eksodos);
        out = (TextView) findViewById(R.id.textView3);
        veisodos=0;
        sp  = getSharedPreferences("storage", Ypoloipo.MODE_PRIVATE);
        editor = sp.edit();

        outpout= sp.getFloat("output", -1);
        out.setText(Float.toString(outpout));

       // eisodosText.addTextChangedListener(eisodosWatcher);
       // eksodosText.addTextChangedListener(eksodosWatcher);


        miden.setOnClickListener(midenismos);

    }


    private View.OnClickListener midenismos = new View.OnClickListener() {
        public void onClick(View view) {


            if(eisodosText.getText().length() == 0)  {
                veisodos=0;
            }else{
                veisodos= Float.parseFloat((eisodosText.getText().toString()));
            }
            if(eksodosText.getText().length() == 0)   {
                veksodos=0;
            }else{
                veksodos = Float.parseFloat(eksodosText.getText().toString());
            }
            outpout+=veisodos;
               /* if (veisodos == 0) {
                    outpout = Float.parseFloat(eisodosText.getText().toString());
                    veisodos = outpout;
                }
                */


                outpout -= veksodos;
                editor.putFloat("output",outpout);
                editor.commit();
                out.setText(Float.toString(outpout));
                eksodosText.getText().clear();
                eisodosText.getText().clear();


            }

    };


/*
    final TextWatcher eisodosWatcher = new TextWatcher() {


        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {



            if(editable.length()!=0){

                veisodos= Float.parseFloat(eisodosText.getText().toString());
                outpout+= veisodos;
            }



        }
    };

    final TextWatcher eksodosWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(next==false){
                eksodosText.getText().clear();
                next=true;

            }

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(editable.length()!=0){

                veksodos= Float.parseFloat(eksodosText.getText().toString());
                outpout =outpout-veksodos;
                out.setText(Float.toString(outpout));

            }

        }
    };

*/

}
