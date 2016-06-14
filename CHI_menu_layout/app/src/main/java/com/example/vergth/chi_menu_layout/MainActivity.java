package com.example.vergth.chi_menu_layout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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

    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit = (Button) findViewById(R.id.submit);
        Button provlepsi = (Button) findViewById(R.id.provlepsi);
        EditText esodaText = (EditText) findViewById(R.id.editText);
        EditText eksodaText = (EditText) findViewById(R.id.editText2);
        Button next = (Button) findViewById(R.id.next);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





      submit.setOnClickListener(new View.OnClickListener() {

            EditText esodaText = (EditText) findViewById(R.id.editText);
            EditText eksodaText = (EditText) findViewById(R.id.editText2);
            public void onClick(View view) {
                // Get references from the views
                if(esodaText.getText().length()!=0 || eksodaText.getText().length()!=0) {
                // Get the actual usable values of views
                    if(esodaText.getText().length()==0){
                        vesoda=0;
                    }else{
                        esoda  = (esodaText.getText().toString());
                        vesoda = Float.valueOf(esoda);
                    }

                    if(eksodaText.getText().length()==0){
                        veksoda=0;
                    }else{
                        eksoda = (eksodaText.getText().toString());
                        veksoda = Float.valueOf(eksoda);
                    }






                    Intent i = new Intent(getApplicationContext(), Ypoloipo.class);
                    i.putExtra("vesoda", vesoda);
                    i.putExtra("veksoda", veksoda);
                    esodaText.getText().clear();
                    eksodaText.getText().clear();
                    startActivity(i);
                }else{
                    return;
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), Ypoloipo.class);
                startActivity(i);
            }
        }
        );

        provlepsi.setOnClickListener(new View.OnClickListener(){
                                    public void onClick(View view){
                                        Intent i = new Intent(getApplicationContext(), Provlepsi.class);
                                        startActivity(i);
                                    }
                                }
        );


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
            case android.R.id.home:
               // mDrawer.openDrawer(GravityCompat.START);
                return true;

            case R.id.settings:
                Intent i = new Intent(getApplicationContext(), Settings.class);
                startActivity(i);
              //  startActivityForResult(i, SETTINGS_RESULT);



            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
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
