package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class netprofit extends AppCompatActivity {

    TextView textview, textview1, textview2, textview3;
    EditText number1, number2, number3, number4, number5, number6, number7;
    Button btn, btn1, btn2, btn3;

    double num1, num2, num3, num4, num5, num6, num7,
            sum, sum1, sum2, sum3, sum4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netprofit);

        this.setTitle("Net profit");

        textview = (TextView) findViewById(R.id.netview);
        textview1 = (TextView) findViewById(R.id.incomeview);
        textview2 = (TextView) findViewById(R.id.profitview);
        textview3 = (TextView) findViewById(R.id.finalview);
        /*********************************************/
        number1 = (EditText) findViewById(R.id.sales);
        number2 = (EditText) findViewById(R.id.salesr);
        /*********************************************/
        number3 = (EditText) findViewById(R.id.cog);
        number4 = (EditText) findViewById(R.id.ad);
        /*********************************************/
        number5 = (EditText) findViewById(R.id.itr);
        /*********************************************/
        btn = (Button) findViewById(R.id.netbtn);
        btn1 = (Button) findViewById(R.id.incomebtn);
        btn2 = (Button) findViewById(R.id.patbtn);
        btn3 = (Button) findViewById(R.id.finalbtn);

        // calculating net sales
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
                    sum = num1 - num2;
                    textview.setText(String.valueOf(sum + " Net sales"));
                }
            }
        });

        // calculating income before tax
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number3.length()==0) {
                    number3.setError("Please enter a number");
                } else if (number4.length()==0) {
                    number4.setError("Please enter a number");
                } else {
                    num3 = Double.parseDouble(number3.getText().toString());
                    num4 = Double.parseDouble(number4.getText().toString());
                    sum1 = sum - num3 - num4;
                    textview1.setText(String.valueOf(sum1 + " Income before tax"));
                }
            }
        });

        // calculating profit after tax
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number5.length()==0) {
                    number5.setError("Please enter a number");
                } else {
                    num5 = Double.parseDouble(number5.getText().toString());
                    sum2 = sum1 * (1-num5);
                    textview2.setText(String.valueOf(sum2 + " Profit after tax"));
                }
            }
        });

        // calculating Net profit ratio
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum3 = (sum2 / sum) * 100;
                textview3.setText(String.valueOf(sum3 + " Net profit ratio"));
                /* Attempt to add an existing formula
                if (number6.length() == 0) {
                    number6.setError("Please enter a number");
                } else if (number7.length()==0) {
                    number7.setError("Please enter a number");
                } else {
                    num6 = Double.parseDouble(number6.getText().toString());
                    num7 = Double.parseDouble(number7.getText().toString());
                    //sum4 = (num6 / num7) * 100;
                    //textview3.setText(String.valueOf(sum4 + " Net profit ratio"));
                 */
                }
        });
    }
}
