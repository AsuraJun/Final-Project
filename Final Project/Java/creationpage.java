package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class creationpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creationpage);

        this.setTitle("Creation Page");

        Button btn = findViewById(R.id.nextbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                movetoselectionpage();
            }

        });

    }

    // move to another page
    private void movetoselectionpage() {
        Intent intent = new Intent(creationpage.this, selectionpage.class);
        startActivity(intent);
    }
}
