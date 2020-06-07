package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class priceearnings extends AppCompatActivity {

    TextView textview, textview1;
    EditText number, number1, number2, number3;
    Button btn, btn1;

    double
    num, num1, num2, num3,
    sum, sum1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priceearnings);

        this.setTitle("Price Earning Ratio");

        textview = (TextView) findViewById(R.id.mpsview);
        textview1 = (TextView) findViewById(R.id.cmcview);
        number = (EditText) findViewById(R.id.mps);
        number1 = (EditText) findViewById(R.id.eps);
        number2 = (EditText) findViewById(R.id.cmc);
        number3 = (EditText) findViewById(R.id.nate);
        btn = (Button) findViewById(R.id.mpsbtn);
        btn1 = (Button) findViewById(R.id.cmcbtn);

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
                    textview.setText(String.valueOf(sum + " Price earnings ratio"));
                }
            }
        });

        // calculating income before tax
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number2.length()==0) {
                    number2.setError("Please enter a number");
                } else if (number3.length()==0) {
                    number3.setError("Please enter a number");
                } else {
                    num2 = Double.parseDouble(number2.getText().toString());
                    num3 = Double.parseDouble(number3.getText().toString());
                    sum1 = num2 / num3;
                    textview1.setText(String.valueOf(sum1 + " Price earnings ratio"));
                }
            }
        });
    }
}
