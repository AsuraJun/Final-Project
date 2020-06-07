package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class selectionpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectionpage);

        this.setTitle("Selection Page");

        String[] listitems = new String[]{
                "Common-Size Statement",
                "Comparative Financial Statement",
                "Ratio Analysis",
                "Benchmarking Analysis",
                "Popular Items",
                "The Average Income",
                "Region",
                "Heat Map",
                "Settings"
        };
        ListView listview = (ListView) findViewById(R.id.selectionlist);

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitems);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(selectionpage.this, commonsize.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(selectionpage.this, comparative.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(selectionpage.this, ratio.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(selectionpage.this, benchmark.class);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(selectionpage.this, popularitems.class);
                    startActivity(intent);
                }
                if (i == 5) {
                    Intent intent = new Intent(selectionpage.this, Incomelist.class);
                    startActivity(intent);
                }
                if (i == 6) {
                    Intent intent = new Intent(selectionpage.this, region.class);
                    startActivity(intent);
                }
                if (i == 7) {
                    Intent intent = new Intent(selectionpage.this, regionheatmap.class);
                    startActivity(intent);
                }
            }
        });
    }
}
