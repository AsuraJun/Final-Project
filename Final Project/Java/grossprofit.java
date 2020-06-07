package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class grossprofit extends AppCompatActivity {

    TextView textview, texview1;
    EditText number1, number2, number3, number4, number5, number6;
    Button btn, btn1;

    // Decimal
    double num1, num2, num3, num4, num5, num6,
            sum, sum1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grossprofit);

        this.setTitle("Gross Profit Ratio");

        // Setting the result for total text box
        textview = (TextView) findViewById(R.id.compview);
        texview1 = (TextView) findViewById(R.id.restrictview);
        number1 = (EditText) findViewById(R.id.sales);
        number2 = (EditText) findViewById(R.id.dm);
        number3 = (EditText) findViewById(R.id.dl);
        number4 = (EditText) findViewById(R.id.oh);
        number5 = (EditText) findViewById(R.id.sales1);
        number6 = (EditText) findViewById(R.id.dm1);
        btn = (Button) findViewById(R.id.compbtn);
        btn1 = (Button) findViewById(R.id.restrictbtn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number1.length()==0) {
                    number1.setError("Please enter a number");
                } else if (number2.length()==0) {
                    number2.setError("Please enter a number");
                } else if (number3.length()==0) {
                    number3.setError("Please enter a number");
                } else if (number4.length()==0) {
                    number4.setError("Please enter a number");
                } else {
                    num1 = Double.parseDouble(number1.getText().toString());
                    num2 = Double.parseDouble(number2.getText().toString());
                    num3 = Double.parseDouble(number3.getText().toString());
                    num4 = Double.parseDouble(number4.getText().toString());
                    sum = (num1 - (num2 + num3 + num4)) / num1 * 100;
                    textview.setText(String.valueOf("The Gross Profit percentage is: " + sum + "%"));
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number5.length() == 0) {
                    number5.setError("Please enter a number");
                } else if (number6.length() == 0) {
                    number6.setError("Please enter a number");
                } else {
                    num5 = Double.parseDouble(number5.getText().toString());
                    num6 = Double.parseDouble(number6.getText().toString());
                    sum1 = (num5 - num6) / num5 * 100;
                    texview1.setText(String.valueOf("The Gross Profit percentage is: " + sum1 + "%"));
                }
            }
        });
    }
}