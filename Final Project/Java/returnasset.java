package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class returnasset extends AppCompatActivity {

    TextView textview;
    EditText number, number1;
    Button btn;

    double
            num, num1,
            sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returnasset);

        this.setTitle("Return on assets");

        textview = (TextView) findViewById(R.id.raview);
        number = (EditText) findViewById(R.id.np);
        number1 = (EditText) findViewById(R.id.ta);
        btn = (Button) findViewById(R.id.rabtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number.length()==0) {
                    number.setError("Please enter a number");
                } else if (number1.length()==0) {
                    number1.setError("Please enter a number");
                } else {
                    num = Double.parseDouble(number.getText().toString());
                    num1 = Double.parseDouble(number1.getText().toString());
                    sum = num / num1;
                    textview.setText(String.valueOf(sum + " Return on assets"));
                }
            }
        });
    }
}

