package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.memoseed.jokeslibandroid.JokeActivity;
import com.memoseed.joketellerjava.Jokes;


public class MainActivity extends AppCompatActivity {

    Jokes jokes = new Jokes();

    Button btnJavaToast,btnJavaAndroid,btnBackend;
    String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJavaToast = (Button) findViewById(R.id.btnJavaToast);
        btnJavaToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, jokes.getJoke(),Toast.LENGTH_LONG).show();
            }
        });
        btnJavaAndroid = (Button) findViewById(R.id.btnJavaAndroid);
        btnJavaAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,JokeActivity.class).putExtra("joke",jokes.getJoke()));
            }
        });
        btnBackend = (Button) findViewById(R.id.btnBackend);
        btnBackend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"btnBackend");
                new EndpointsAsyncTask(MainActivity.this,"main").execute();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }


}
