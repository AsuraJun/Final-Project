package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class dividendpayout extends AppCompatActivity {

    TextView textview, textview1;
    EditText number1, number2, number3, number4;
    Button btn, btn1;

    // Decimal
    Double num1, num2, num3, num4,sum, sum1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dividendpayout);

        this.setTitle("Dividend Payout Ratio");

        // Setting the result for total text box
        textview = (TextView) findViewById(R.id.incometotal);
        textview1 = (TextView) findViewById(R.id.persharetotal);
        number1 = (EditText) findViewById(R.id.tdp);
        number2 = (EditText) findViewById(R.id.ni);
        number3 = (EditText) findViewById(R.id.dpps);
        number4 = (EditText) findViewById(R.id.eps);
        btn = (Button) findViewById(R.id.netbtn);
        btn1 = (Button) findViewById(R.id.sharebtn);


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
                    sum = (num1 / num2) * 100;
                    textview.setText(String.valueOf(sum + "% Dividend payout Ratio"));
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number3.length() == 0) {
                    number3.setError("Please enter a number");
                } else if (number4.length() == 0) {
                    number4.setError("Please enter a number");
                } else {
                    num3 = Double.parseDouble(number3.getText().toString());
                    num4 = Double.parseDouble(number4.getText().toString());
                    sum1 = (num3 / num4) * 100;
                    textview1.setText(String.valueOf(sum1 + "% Dividend payout Ratio"));
                }
            }
        });
    }
}
