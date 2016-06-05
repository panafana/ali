package com.example.vergth.chi_menu_layout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    public String esoda ,eksoda;
    public float vesoda,veksoda;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button submit = (Button) findViewById(R.id.submit);
        EditText esodaText = (EditText) findViewById(R.id.editText);
        EditText eksodaText = (EditText) findViewById(R.id.editText2);

      submit.setOnClickListener(new View.OnClickListener() {

            EditText esodaText = (EditText) findViewById(R.id.editText);
            EditText eksodaText = (EditText) findViewById(R.id.editText2);
            public void onClick(View view) {
                // Get references from the views
                if(esodaText.getText().length()!=0 && eksodaText.getText().length()!=0) {
                // Get the actual usable values of views
                esoda  = (esodaText.getText().toString());
                eksoda = (eksodaText.getText().toString());

                    vesoda = Float.valueOf(esoda);
                    veksoda = Float.valueOf(eksoda);

                    Intent i = new Intent(getApplicationContext(), Ypoloipo.class);
                    i.putExtra("vesoda", vesoda);
                    i.putExtra("veksoda", veksoda);
                    startActivity(i);
                }else{
                    return;
                }

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(MainActivity.this, "search pressed",
                        Toast.LENGTH_LONG).show();
                return true;

            case R.id.settings:
                Toast.makeText(MainActivity.this, "settings pressed",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.first:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(MainActivity.this, "first selected",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.second:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(MainActivity.this, "second selected",
                        Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    public void startBasketball(View view) {
        startActivity(new Intent(this, Ypoloipo.class));
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.vergth.chi_menu_layout/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);



    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.vergth.chi_menu_layout/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
