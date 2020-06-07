package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.facebook.stetho.Stetho;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    public static Context instance = null;
    List<String> product_line_list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main);

        //title of the page
        this.setTitle("Financial Analystics Application");

        //loading screen
        /*Timer timer = new Timer();
        try {
            timer.wait(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // databas helper
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.createTable();
        try {
            dbHelper.insertData(instance);
        } catch (IOException e) {
            e.printStackTrace();
        }

       // assigning the btn
        Button btn = findViewById(R.id.loginbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){ movetocreationpage(); }
        });
    }

    public static Context getContext() { return instance.getApplicationContext(); }
    // move to another page
    private void movetocreationpage() {
        Intent intent = new Intent(MainActivity.this, creationpage.class);
        startActivity(intent);
    }
}
