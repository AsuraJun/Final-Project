package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class netprofitratio extends AppCompatActivity {

    TextView textview, textview1;
    EditText number, number1;
    Button btn, btn1;

    double num, num1,
            sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netprofitratio);

        this.setTitle("Net Profit Ratio Version 2");

        textview = (TextView) findViewById(R.id.nprview);
        textview1 = (TextView) findViewById(R.id.nprview2);
        number = (EditText) findViewById(R.id.pat);
        number1 = (EditText) findViewById(R.id.ns);
        btn = (Button) findViewById(R.id.nprbtn);
        btn1 = (Button) findViewById(R.id.nprbtn2);

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
                    sum = (num / num1) * 100;

                    //2 decimal places and round up number
                    String sum1 = String.format("%.1f", sum);
                    textview.setText(String.valueOf(sum1 + " % Net profit ratio"));
                }
            }
        });

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    textview1.setText(String.valueOf(sum + " % Net profit ratio"));
                }
        });*/

    }
}
