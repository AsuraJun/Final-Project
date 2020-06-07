/*package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class daysales extends AppCompatActivity {

    TextView result;
    EditText number1, number2, number3;
    Button Calculate;

    // Decimal
    int num1, num2, num3, resultsum;

    // Integer
    //int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daysales);
        this.setTitle("Days Sales Outstanding Calculation");

        // Setting the result for total text box
        result = (TextView) findViewById(R.id.result);
        number1 = (EditText) findViewById(R.id.annr);
        number2 = (EditText) findViewById(R.id.accr);
        number3 = (EditText) findViewById(R.id.doy);
        Calculate = (Button) findViewById(R.id.sum);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                num3 = Integer.parseInt(number3.getText().toString());
                resultsum = num1 / num2;
                result.setText(String.valueOf(resultsum+" Days Sales Outstanding"));
            }
        });
    }
}
*/
package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class daysales extends AppCompatActivity {

    TextView textview;
    EditText number1, number2, number3;
    Button btn;

    // Decimal
    double num1, num2, num3, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daysales);

        this.setTitle("Day sales outstanding");

        // Setting the result for total text box
        textview = (TextView) findViewById(R.id.totaldaysale);
        number1 = (EditText) findViewById(R.id.receivable);
        number2 = (EditText) findViewById(R.id.revenue);
        number3 = (EditText) findViewById(R.id.doy);
       btn = (Button) findViewById(R.id.daysalebtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number1.length() == 0) {
                    number1.setError("Please enter a number");
                } else if (number2.length() == 0) {
                    number2.setError("Please enter a number");
                } else if (number3.length() == 0) {
                    number3.setError("Please enter a number");
                } else {
                    num1 = Double.parseDouble(number1.getText().toString());
                    num2 = Double.parseDouble(number2.getText().toString());
                    num3 = Double.parseDouble(number3.getText().toString());
                    sum = num1 / num2 * num3;
                    textview.setText(String.valueOf( sum + " Days of Sales"));
                }
            }
        });
    }
}