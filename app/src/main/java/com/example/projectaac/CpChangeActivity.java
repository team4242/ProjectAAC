package com.example.projectaac;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class CpChangeActivity extends AppCompatActivity {

    Button btn_0, btn_1, btn_2;
    ImageButton btn_cancel, btn_up, btn_down, btn_save;
    GridView CpGridView, symbolGridView;
    GridSymbolAdapter cp_adapter, symbol_adapter, new_symbol_adapter;
    DBManager dbManager;
    DBQuery dbQuery;

    Cursor cursor1, cursor2;

    private static int ClickedCP = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_change);

        dbManager = new DBManager(this);

        CpGridView = (GridView)findViewById(R.id.CpGirdView);
        symbolGridView = (GridView)findViewById(R.id.symbolGirdView);

        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);

        btn_cancel = (ImageButton) findViewById(R.id.btn_cancel);
        btn_up =(ImageButton) findViewById(R.id.btn_up);
        btn_down = (ImageButton) findViewById(R.id.btn_down);
        btn_save = (ImageButton) findViewById(R.id.btn_save);

        cp_adapter = new GridSymbolAdapter();
        symbol_adapter = new GridSymbolAdapter();
        new_symbol_adapter = new GridSymbolAdapter();


        //위 그리드뷰 기본 화면 출력
        dbQuery = new DBQuery(dbManager);
        ArrayList<Integer> symbolList = new ArrayList<Integer>();
        symbolList = dbQuery.getTableSymbol("일상");  //일상 테이블의 상징id 저장
        cursor1 = dbQuery.getAllSymbol(); //모든 심볼 불러옴
        cursor1.moveToFirst();   //왠지 모르게 이거 안하면 에러남
        cp_adapter.clear(); //어댑터 다 삭제
        for (int i = 0; i < symbolList.size(); i++) {
            cursor1.moveToPosition(symbolList.get(i));
            cp_adapter.addItem(new SymbolListItem(cursor1.getInt(0),cursor1.getString(1),cursor1.getString(2),
                    cursor1.getInt(3),cursor1.getInt(4)));
        }
        CpGridView.setAdapter(cp_adapter);
        cp_adapter.notifyDataSetChanged();


        //아래 그리드뷰 기본 출력화면
        cursor2 = dbQuery.getNoUsedSymbol();
        cursor2.moveToFirst();
        final int symbolNum = cursor2.getCount();
        if(symbolNum > 1) {
            for (int i = 0; i < symbolNum; i++) {
                if (i == symbolNum-1) {
                    continue;
                } else {
                    cursor2.moveToNext();
                }
                symbol_adapter.addItem(new SymbolListItem(cursor2.getInt(0), cursor2.getString(1), cursor2.getString(2),
                        cursor2.getInt(3), cursor2.getInt(4)));
            }
        }
        symbolGridView.setAdapter(symbol_adapter);


        //cp 바꾸는 버튼클릭이벤트. 동적으로 구현할 예정, 직접 db에서 받아오지 않고 static hashmap에 저장해놓고 불러올 예정
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //각 버튼에 해당하는 테이블의 symbol을 불러와서 출력하는 기능
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                symbolList = dbQuery.getTableSymbol("일상");  //일상 테이블의 상징id 저장
                Cursor cursor = dbQuery.getAllSymbol(); //모든 심볼 불러옴
                cursor.moveToFirst();   //왠지 모르게 이거 안하면 에러남
                cp_adapter.clear(); //어댑터 다 삭제
                for (int i = 0; i < symbolList.size(); i++) {
                    cursor.moveToPosition(symbolList.get(i));
                    cp_adapter.addItem(new SymbolListItem(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));
                }
                symbol_adapter.setAdapterChecked(false);    //둘 다 체크 지우기
                cp_adapter.setAdapterChecked(false);

                cp_adapter.notifyDataSetChanged();  //어댑터 새로고침
                symbol_adapter.notifyDataSetChanged();
                CpGridView.setAdapter(cp_adapter);  //그리드뷰 새로고침
                symbolGridView.setAdapter(symbol_adapter);
                ClickedCP = 0;
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                symbolList = dbQuery.getTableSymbol("음식");
                Cursor cursor = dbQuery.getAllSymbol();
                cursor.moveToFirst();
                cp_adapter.clear();//어댑터 다 삭제
              for (int i = 0; i < symbolList.size(); i++) {
                    cursor.moveToPosition(symbolList.get(i));
                    cp_adapter.addItem(new SymbolListItem(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));
                }
                symbol_adapter.setAdapterChecked(false);    //둘 다 체크 지우기
                cp_adapter.setAdapterChecked(false);

                cp_adapter.notifyDataSetChanged();  //어댑터 새로고침
                symbol_adapter.notifyDataSetChanged();
                CpGridView.setAdapter(cp_adapter);  //그리드뷰 새로고침
                symbolGridView.setAdapter(symbol_adapter);
                ClickedCP = 1;
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                symbolList = dbQuery.getTableSymbol("도움");
                Cursor cursor = dbQuery.getAllSymbol();
                cursor.moveToFirst();
                cp_adapter.clear();//어댑터 다 삭제
                for (int i = 0; i < symbolList.size(); i++) {
                    cursor.moveToPosition(symbolList.get(i));
                    cp_adapter.addItem(new SymbolListItem(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));
                }
                symbol_adapter.setAdapterChecked(false);    //둘 다 체크 지우기
                cp_adapter.setAdapterChecked(false);

                cp_adapter.notifyDataSetChanged();  //어댑터 새로고침
                symbol_adapter.notifyDataSetChanged();
                CpGridView.setAdapter(cp_adapter);  //그리드뷰 새로고침
                symbolGridView.setAdapter(symbol_adapter);
                ClickedCP = 2;
            }
        });

        //아래 버튼들 클릭 이벤트
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                switch (ClickedCP) {
                    case 0:
                        symbolList = dbQuery.getTableSymbol("일상");
                        break;
                    case 1:
                        symbolList = dbQuery.getTableSymbol("음식");
                        break;
                    case 2:
                        symbolList = dbQuery.getTableSymbol("도움");
                        break;
                }
                Cursor cursor = dbQuery.getAllSymbol();
                cursor.moveToFirst();

                cp_adapter.clear();//어댑터 다 삭제
                for (int i = 0; i < symbolList.size(); i++) {
                    cursor.moveToPosition(symbolList.get(i));
                    cp_adapter.addItem(new SymbolListItem(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));
                }
                dbQuery.dbClose();
                CpGridView.setAdapter(cp_adapter);
                cp_adapter.notifyDataSetChanged();

                cursor2 = dbQuery.getNoUsedSymbol();
                cursor2.moveToFirst();
                symbol_adapter.clear();
                int symbolNum = cursor2.getCount();
                if(symbolNum > 1) {
                    for (int i = 0; i < symbolNum; i++) {
                        if (i == symbolNum-1) {
                            continue;
                        } else {
                            cursor2.moveToNext();
                        }
                        symbol_adapter.addItem(new SymbolListItem(cursor2.getInt(0), cursor2.getString(1), cursor2.getString(2),
                                cursor2.getInt(3), cursor2.getInt(4)));
                    }
                }
                symbolGridView.setAdapter(symbol_adapter);
            }
        });
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(symbol_adapter.isAdapterChecked()&&cp_adapter.isAdapterChecked()){   //symbol과 cp 그리드뷰가 선택되어있고
                    if(cp_adapter.items.get(cp_adapter.getCheckedItem()).ID == 1){  //선택한 cp 그리드뷰가 비어있을때
                        cp_adapter.items.remove(cp_adapter.getCheckedItem());   //비어있는 cp의 상징을 제거하고
                        cp_adapter.addItem(symbol_adapter.items.get(symbol_adapter.getCheckedItem()),cp_adapter.getCheckedItem());  //symbol의 상징을 cp에 추가한다
                        symbol_adapter.items.remove(symbol_adapter.getCheckedItem());   //symbol에서 제거한다

                        symbol_adapter.setCheckedItem(100);
                        cp_adapter.setCheckedItem(100);
                        symbol_adapter.setAdapterChecked(false);    //둘 다 체크 지우기
                        cp_adapter.setAdapterChecked(false);

                        cp_adapter.notifyDataSetChanged();  //어댑터 새로고침
                        symbol_adapter.notifyDataSetChanged();
                        CpGridView.setAdapter(cp_adapter);  //그리드뷰 새로고침
                        symbolGridView.setAdapter(symbol_adapter);
                    }else{
                        Toast.makeText(getApplicationContext(), "비어있는 위치를 선택해주세요", Toast.LENGTH_SHORT).show();
                    }
                }else{}
            }
        });
        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cp_adapter.isAdapterChecked() && cp_adapter.items.get(cp_adapter.getCheckedItem()).ID != 1) { //cp가 선택되고 선택된 심볼이 비어있지 않을 때
                    symbol_adapter.addItem(cp_adapter.items.get(cp_adapter.getCheckedItem()));  //선택한 상징을 symbol 그리드뷰에 추가한다.
                    cp_adapter.items.remove(cp_adapter.getCheckedItem());   //선택한 상징을 제거하고
                    cursor2.moveToFirst();
                    cp_adapter.items.add(new SymbolListItem(cursor1.getInt(0), cursor1.getString(1), cursor1.getString(2),
                            cursor1.getInt(3), cursor1.getInt(4)));  //제거한 자리에 1번 상징 (빈 상징) 추가

                    symbol_adapter.setCheckedItem(100);
                    cp_adapter.setCheckedItem(100);
                    cp_adapter.setAdapterChecked(false); //체크 지우기
                    cp_adapter.notifyDataSetChanged();  //어댑터 새로고침
                    symbol_adapter.notifyDataSetChanged();
                    CpGridView.setAdapter(cp_adapter);  //그리드뷰 새로고침
                    symbolGridView.setAdapter(symbol_adapter);
                }else{
                    Toast.makeText(getApplicationContext(), "비어있지 않은 상징을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //저장버튼 누르면 db에 현재 화면 저장
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> oldsymbolList = new ArrayList<Integer>();
                ArrayList<Integer> newsymbolList = new ArrayList<Integer>();

                switch (ClickedCP) {
                    case 0:
                        oldsymbolList = dbQuery.getTableSymbol("일상");
                        for (int i =0; i<16; i++) {
                            newsymbolList.add(i,cp_adapter.items.get(i).ID);
                        }
                        for (int i =0; i<16; i++) {
                            if(newsymbolList.get(i) != oldsymbolList.get(i)){
                                dbQuery.setUsedFalse(oldsymbolList.get(i));
                                dbQuery.setUsedTrue(newsymbolList.get(i));
                                dbQuery.setChangeCP("일상", (int) cp_adapter.items.get(i).ID, i+1);
                            }
                        }
                        break;
                    case 1:
                        oldsymbolList = dbQuery.getTableSymbol("음식");
                        for (int i =0; i<16; i++) {
                            newsymbolList.add(i,cp_adapter.items.get(i).ID);
                        }
                        for (int i =0; i<16; i++) {
                            if(newsymbolList.get(i) != oldsymbolList.get(i)){
                                dbQuery.setUsedFalse(oldsymbolList.get(i));
                                dbQuery.setUsedTrue(newsymbolList.get(i));
                                dbQuery.setChangeCP("음식", (int) cp_adapter.items.get(i).ID, i+1);
                            }
                        }
                        break;
                    case 2:
                        oldsymbolList = dbQuery.getTableSymbol("도움");
                        for (int i =0; i<16; i++) {
                            newsymbolList.add(i,cp_adapter.items.get(i).ID);
                        }
                        for (int i =0; i<16; i++) {
                            if(newsymbolList.get(i) != oldsymbolList.get(i)){
                                dbQuery.setUsedFalse(oldsymbolList.get(i));
                                dbQuery.setUsedTrue(newsymbolList.get(i));
                                dbQuery.setChangeCP("도움", (int) cp_adapter.items.get(i).ID, i+1);
                            }
                        }
                        break;
                }
            }
        });

        //위쪽 그리드뷰 클릭이벤트
        CpGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == cp_adapter.getCheckedItem()){
                    cp_adapter.setCheckedItem(0);
                    cp_adapter.setAdapterChecked(false);
                }else {
                    cp_adapter.setCheckedItem(position);
                    cp_adapter.setAdapterChecked(true);
                }

                cp_adapter.notifyDataSetChanged();
                CpGridView.setAdapter(cp_adapter);
            }
        });

        //아래 그리드뷰 클릭이벤트
        symbolGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == symbol_adapter.getCheckedItem()) {
                    symbol_adapter.setCheckedItem(100);
                    symbol_adapter.setAdapterChecked(false);
                }else{
                    symbol_adapter.setCheckedItem(position);
                    symbol_adapter.setAdapterChecked(true);
                }
                symbol_adapter.notifyDataSetChanged();
                symbolGridView.setAdapter(symbol_adapter);
            }
        });
    }
}
