package com.example.financialanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ratio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratio);

        this.setTitle("Ratio Calculator");

        String[] listitems = new String[]{
                "Current Ratio",
                "Days Sales Outstanding",
                "Debt to Equality Ratio",
                "Dividend Payout Ratio",
                "Gross Profit Ratio",
                "Net Profit Ratio",
                "Net Profit Ratio Version 2",
                "Price Earnings Ratio",
                "Return On Assets Ratio"
        };
        ListView listview = (ListView) findViewById(R.id.ratiolist);

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitems);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(ratio.this, currentratio.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(ratio.this, daysales.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(ratio.this, debtequality.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(ratio.this, dividendpayout.class);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(ratio.this, grossprofit.class);
                    startActivity(intent);
                }
                if (i == 5) {
                    Intent intent = new Intent(ratio.this, netprofit.class);
                    startActivity(intent);
                }
                if (i == 6) {
                    Intent intent = new Intent(ratio.this, netprofitratio.class);
                    startActivity(intent);
                }
                if (i == 7) {
                    Intent intent = new Intent(ratio.this, priceearnings.class);
                    startActivity(intent);
                }
                if (i == 8) {
                    Intent intent = new Intent(ratio.this, returnasset.class);
                    startActivity(intent);
                }
            }
        });

    }
}
