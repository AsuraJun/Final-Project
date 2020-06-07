package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class currentratio extends AppCompatActivity {

    TextView textview;
    EditText number1, number2;
    Button btn;

    double num1, num2, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currentratio);

        this.setTitle("Current Ratio");

        // Setting the result for total text box
        textview = (TextView) findViewById(R.id.currenttotal);
        number1 = (EditText) findViewById(R.id.ca);
        number2 = (EditText) findViewById(R.id.cl);
        btn = (Button) findViewById(R.id.currentbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number1.length()==0) {
                    number1.setError("Please enter a number");
                } else if (number2.length()==0) {
                    number2.setError("Please enter a number");
                } else {
                    num1 = Double.parseDouble(number1.getText().toString());
                    num2 = Double.parseDouble(number2.getText().toString());
                    sum = num1 / num2;
                    textview.setText(String.valueOf("The Current Ratio is: " + sum));
                }
            }
        });
    }
}
