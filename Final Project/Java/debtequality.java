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

public class debtequality extends AppCompatActivity {

    TextView textView;
    EditText number1, number2, number3, number4;
    Button btn;

    // Decimal
    Double num1, num2, num3,num4, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debtequality);

        this.setTitle("Debt to Equity Ratio");

        // Setting the result for total text box
        textView = (TextView) findViewById(R.id.dqtotal);
        number1 = (EditText) findViewById(R.id.lng);
        number2 = (EditText) findViewById(R.id.shrt);
        number3 = (EditText) findViewById(R.id.lea);
        number4 = (EditText) findViewById(R.id.equ);
        btn= (Button) findViewById(R.id.dqbtn);

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
                    num4 = Double.parseDouble(number4.getText().toString());
                    sum = num1 + num2 + num3 / num4;
                    textView.setText(String.valueOf(sum + " Debt to Equity"));
                }
            }
        });
    }
}