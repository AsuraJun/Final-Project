package com.example.financialanalytics;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.math.MathUtils;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class Incomelist extends AppCompatActivity {
    double average=0;
    public static Context instance = null;
    List<String> product_line_list = new ArrayList<String>();
    List<Double> gross_income_list= new ArrayList<Double>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incomelist);

        this.setTitle("Average Gross Income");

        //****************************************************************
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        Cursor cursor = dbHelper.readData("supermarketSales");
        if (cursor.moveToPosition(1)) {
            do {
                // displaying the results side by side
                String gross_income = cursor.getString(cursor.getColumnIndex("gross_income"));
                String product_line = cursor.getString(cursor.getColumnIndex("product_line"));
                product_line_list.add(gross_income + " | " + product_line);

                double gross_income_num = Double.parseDouble(cursor.getString(cursor.getColumnIndex("gross_income")));
                gross_income_list.add(gross_income_num);

                //displaying the gross income
                /*
                String gross_income = cursor.getString(cursor.getColumnIndex("gross_income"));
                double gross_income_num = Double.parseDouble(cursor.getString(cursor.getColumnIndex("gross_income")));
                gross_income_list.add(gross_income_num);
                */

                //populate list view
                /*
                Cursor cursor = dbHelper.readData();
                if (cursor.moveToFirst()) {
                do {
                    product_line_list.add(cursor.getString(cursor.getColumnIndex("product_line")));
                }
                    while (cursor.moveToNext());
                }
                    ListView listView = (ListView) findViewById(R.id.listView);
                    ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, product_line_list);
                    listView.setAdapter(adapter);
                */

                // assigning the total as an variable and giving it an value of zero
                double total = 0;
                //gross income average
                for (int n=0; n < gross_income_list.size();n++){
                total = total+gross_income_list.get(n);
                }
                    average = total/gross_income_list.size();
                //product_line_list.add(cursor.getString(cursor.getColumnIndex("gross_income")));
                } while (cursor.moveToNext());
        }
        //assigning the result to a list view
        ListView listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, product_line_list);
        listView.setAdapter(adapter);

        //button
        Button btn = (Button) findViewById(R.id.avgbtn);
        //onclick function
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //set average as text
                TextView textView = (TextView) findViewById(R.id.txtview);

                //average = decimalplace
                String averageStr = String.format("%.2f",average);
                textView.setText("The Average Gross Income is = " + averageStr);
            }
        });
    }
}
