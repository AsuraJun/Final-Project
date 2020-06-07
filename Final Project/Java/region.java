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

public class region extends AppCompatActivity {

    public static Context instance = null;
    List<String> region_list = new ArrayList<String>();
    List<String> region_list_distinct = new ArrayList<String>();
    List<String> regionoutput = new ArrayList<String>();
    List<String> yesNo = new ArrayList<String>();
    List<String> TrueIndex = new ArrayList<String>();

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);

        this.setTitle("Region");

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        Cursor cursor = dbHelper.readData("superStore");

        if (cursor.moveToPosition(1)){
            do {
                try {
                    Double.parseDouble(cursor.getString(cursor.getColumnIndex("country")));
                    yesNo.add("True");
                } catch (Exception ex){
                    yesNo.add("False");
                }

                region_list.add(cursor.getString(cursor.getColumnIndex("country")));
            } while (cursor.moveToNext());
        }

        //get indexes of every region which is a number
        for (int q =0;q<yesNo.size();q++){
            if (yesNo.get(q) == "True"){
                TrueIndex.add(Integer.toString(q));
            }
        }

        region_list_distinct=region_list.stream().distinct().collect(Collectors.<String>toList());

        for (int p=0; p<region_list_distinct.size();p++){
            String count = Integer.toString(Collections.frequency(region_list, region_list_distinct.get(p)));
            regionoutput.add(region_list_distinct.get(p)+" | Count :"+ count);
            // position the list centre
        }

        ListView listView = (ListView) findViewById(R.id.regionlist);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, regionoutput);
        listView.setAdapter(adapter);
    }
}