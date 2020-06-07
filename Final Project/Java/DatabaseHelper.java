package com.example.financialanalytics;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "jundb";
    public Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void createTable() {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();

        //************************* supermarket ********************************
        String supermarket = "select count(1) from sqlite_master WHERE type='table' and name='supermarketSales'";
        String dropTable = "DROP TABLE supermarketSales";
        String createTable = "CREATE TABLE supermarketSales(" +
                "invoice_id varchar(255)," +
                "branch varchar(255)," +
                "city varchar(255)," +
                "customer_type varchar(255)," +
                "gender varchar(255)," +
                "product_line varchar(255)," +
                "unitprice varchar(255)," +
                "quantity varchar(255)," +
                "tax_5 varchar(255)," +
                "total varchar(255)," +
                "date varchar(255)," +
                "time varchar(255)," +
                "payment varchar(255)," +
                "sold_goods_cost varchar(255)," +
                "gross_margin_percentage varchar(255)," +
                "gross_income varchar(255)," +
                "rating varchar(255))";

            Cursor cursor1 = writableDatabase.rawQuery(supermarket,null);
            int count = cursor1.getCount();

            if (count > 0){
                writableDatabase.execSQL(dropTable);
            }
                writableDatabase.execSQL(createTable);

        //********************* superStore **********************
        //String removeData = "Delete from superStore";
        String superstore = "select count(1) from sqlite_master Where type = 'table' and name ='superStore'";
        String dropTablesuperstore = "DROP TABLE superStore";
        String createTablesuperstore = "CREATE TABLE superStore(" +
                "invoiceno varchar(255)," +
                "unitprice varchar(255)," +
                "country varchar(255))";

          //superstore
          Cursor cursor2 = writableDatabase.rawQuery(superstore,null);
          int count1 = cursor2.getCount();
          if (count1 > 0){
             writableDatabase.execSQL(dropTablesuperstore);
          }
        writableDatabase.execSQL(createTablesuperstore);
    }

    public void insertData(Context context1) throws IOException {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        int i;

        InputStream inputStream = context1.getResources().openRawResource(R.raw.supermarketsales);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line=null;
        while(reader.ready()) {
            line = reader.readLine();
            String[] value = line.split(",");
            String setupData = "INSERT INTO supermarketSales(" +
                    "invoice_id ," +
                    "branch ," +
                    "city ," +
                    "customer_type ," +
                    "gender ," +
                    "product_line ," +
                    "unitprice ," +
                    "quantity ," +
                    "tax_5 ," +
                    "total ," +
                    "date ," +
                    "time ," +
                    "payment ," +
                    "sold_goods_cost ," +
                    "gross_margin_percentage ," +
                    "gross_income ," +
                    "rating) values" +
                    "('" + value[0] + "'," +
                    "'" + value[1] + "'," +
                    "'" + value[2] + "'," +
                    "'" + value[3] + "'," +
                    "'" + value[4] + "'," +
                    "'" + value[5] + "'," +
                    "'" + value[6] + "'," +
                    "'" + value[7] + "'," +
                    "'" + value[8] + "'," +
                    "'" + value[9] + "'," +
                    "'" + value[10] + "'," +
                    "'" + value[11] + "'," +
                    "'" + value[12] + "'," +
                    "'" + value[13] + "'," +
                    "'" + value[14] + "'," +
                    "'" + value[15] + "'," +
                    "'" + value[16] + "')";

            writableDatabase.execSQL(setupData);
        }

            InputStream inputStream1 = context1.getResources().openRawResource(R.raw.superstore);
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream1));
            String line1=null;
            while(reader1.ready()) {
                line1 = reader1.readLine();
                String[] value1 = line1.split(",");
                String setupData1 = "INSERT INTO superStore(" +
                        "invoiceno," +
                        "unitprice," +
                        "country) values" +
                        "('" + value1[0] + "'," +
                        "'" + value1[5] + "'," +
                        "'" + value1[7] + "')";
                 writableDatabase.execSQL(setupData1);
            }
    }
    public Cursor readData(String tableName){
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        String readTable = "SELECT * FROM "+tableName;
        Cursor cursor = writableDatabase.rawQuery(readTable, null);
        return cursor;
        //return null;
    }
}
