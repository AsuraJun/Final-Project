package com.example.financialanalytics;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class popularitems extends AppCompatActivity {

    //converting list to an array
    public static Context instance = null;
    List<String> product_line_list = new ArrayList<String>();
    List<String> product_line_list_distinct = new ArrayList<String>();
    List<String> output = new ArrayList<String>();

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popularitems);

        this.setTitle("Popular Items");

        // getting values from databasehelper
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        Cursor cursor = dbHelper.readData("supermarketSales");

        // move the position of the list to 1 and not 0
            if (cursor.moveToPosition(1)){
            do {
                product_line_list.add(cursor.getString(cursor.getColumnIndex("product_line")));
            } while (cursor.moveToNext());
        }

        //counting the items
        product_line_list_distinct=product_line_list.stream().distinct().collect(Collectors.<String>toList());
        for (int p=0; p<product_line_list_distinct.size();p++){
            String count = Integer.toString(Collections.frequency(product_line_list, product_line_list_distinct.get(p)));
            output.add(product_line_list_distinct.get(p)+" | Count :"+ count);
        }

        // list view
        ListView listView = (ListView) findViewById(R.id.popularlist);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, output);
        listView.setAdapter(adapter);
        }
    }
