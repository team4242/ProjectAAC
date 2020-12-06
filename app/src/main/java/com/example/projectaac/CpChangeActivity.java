package com.example.projectaac;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;


public class CpChangeActivity extends AppCompatActivity {

    Button btn_1, btn_2, btn_3;
    GridView symbolGridView;
    GridSymbolAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_change);

        final DBManager dbManager = new DBManager(this);

        symbolGridView = (GridView)findViewById(R.id.symbolGirdView);



        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBQuery dbQuery = new DBQuery(dbManager);
                adapter = new GridSymbolAdapter();
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                symbolList = dbQuery.getTableSymbol("일상");
                Cursor cursor = dbQuery.getAllSymbol();
                cursor.moveToFirst();
                for (int i = 0; i < symbolList.size(); i++) {
                    cursor.moveToPosition(symbolList.get(i));
                    adapter.addItem(new SymbolListItem(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));
                }
                dbQuery.dbClose();
                symbolGridView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBQuery dbQuery = new DBQuery(dbManager);
                adapter = new GridSymbolAdapter();
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                symbolList = dbQuery.getTableSymbol("음식");
                Cursor cursor = dbQuery.getAllSymbol();
                cursor.moveToFirst();
                for (int i = 0; i < symbolList.size(); i++) {
                    cursor.moveToPosition(symbolList.get(i));
                    adapter.addItem(new SymbolListItem(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));
                }
                dbQuery.dbClose();
                symbolGridView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBQuery dbQuery = new DBQuery(dbManager);
                adapter = new GridSymbolAdapter();
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                symbolList = dbQuery.getTableSymbol("도움");
                Cursor cursor = dbQuery.getAllSymbol();
                cursor.moveToFirst();
                for (int i = 0; i < symbolList.size(); i++) {
                    cursor.moveToPosition(symbolList.get(i));
                    adapter.addItem(new SymbolListItem(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));
                }
                dbQuery.dbClose();
                symbolGridView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });



    }
}
