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
    GridView CpGridView, symbolGridView;
    GridSymbolAdapter adapter;
    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_change);

        dbManager = new DBManager(this);

        CpGridView = (GridView)findViewById(R.id.CpGirdView);
        symbolGridView = (GridView)findViewById(R.id.symbolGirdView);

        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //각 버튼에 해당하는 테이블의 symbol을 불러와서 출력하는 기능
                DBQuery dbQuery = new DBQuery(dbManager);
                adapter = new GridSymbolAdapter();
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                symbolList = dbQuery.getTableSymbol("일상");  //일상 테이블의 상징id 저장
                Cursor cursor = dbQuery.getAllSymbol(); //모든 심볼 불러옴
                cursor.moveToFirst();   //왠지 모르게 이거 안하면 에러남
                for (int i = 0; i < symbolList.size(); i++) {
                    cursor.moveToPosition(symbolList.get(i));
                    adapter.addItem(new SymbolListItem(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));
                }
                dbQuery.dbClose();      //꼭꼭 닫아줍시다
                CpGridView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                //이상하게 테이블에 속한 상징이 들어가지지 않음. 오류수정 예정
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
                CpGridView.setAdapter(adapter);
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
                CpGridView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

    }
}
