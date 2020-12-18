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
    GridSymbolAdapter cp1_adapter, cp2_adapter, cp3_adapter, symbol_adapter;
    ArrayList<Integer> cp1List, cp2List, cp3List, noUsedList;
    ArrayList<SymbolListItem> symbolList;
    DBManager dbManager;
    DBQuery dbQuery;

    private static int ClickedCP = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_change);

        dbManager = new DBManager(this);
        dbQuery = new DBQuery(dbManager);

        CpGridView = (GridView)findViewById(R.id.CpGirdView);
        symbolGridView = (GridView)findViewById(R.id.symbolGirdView);

        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);

        btn_cancel = (ImageButton) findViewById(R.id.btn_cancel);
        btn_up =(ImageButton) findViewById(R.id.btn_up);
        btn_down = (ImageButton) findViewById(R.id.btn_down);
        btn_save = (ImageButton) findViewById(R.id.btn_save);

        cp1List = new ArrayList<>();
        cp2List = new ArrayList<>();
        cp3List = new ArrayList<>();
        noUsedList = new ArrayList<>();

        symbolList = new ArrayList<SymbolListItem>();

        cp1_adapter = new GridSymbolAdapter();
        cp2_adapter  = new GridSymbolAdapter();
        cp3_adapter = new GridSymbolAdapter();
        symbol_adapter = new GridSymbolAdapter();

        cp_init();


        //cp 바꾸는 버튼클릭이벤트.
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol_adapter.setAdapterChecked(false);    //둘 다 체크 지우기
                cp1_adapter.setAdapterChecked(false);

                cp1_adapter.notifyDataSetChanged();  //어댑터 새로고침
                symbol_adapter.notifyDataSetChanged();
                CpGridView.setAdapter(cp1_adapter);  //그리드뷰 새로고침
                symbolGridView.setAdapter(symbol_adapter);
                ClickedCP = 0;
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol_adapter.setAdapterChecked(false);    //둘 다 체크 지우기
                cp2_adapter.setAdapterChecked(false);

                cp2_adapter.notifyDataSetChanged();  //어댑터 새로고침
                symbol_adapter.notifyDataSetChanged();
                CpGridView.setAdapter(cp2_adapter);  //그리드뷰 새로고침
                symbolGridView.setAdapter(symbol_adapter);
                ClickedCP = 1;
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol_adapter.setAdapterChecked(false);    //둘 다 체크 지우기
                cp3_adapter.setAdapterChecked(false);

                cp3_adapter.notifyDataSetChanged();  //어댑터 새로고침
                symbol_adapter.notifyDataSetChanged();
                CpGridView.setAdapter(cp3_adapter);  //그리드뷰 새로고침
                symbolGridView.setAdapter(symbol_adapter);
                ClickedCP = 2;
            }
        });

        //아래 버튼들 클릭 이벤트

        //초기화 버튼
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cp_init();
            }
        });

        //의사소통판에 상징 추가
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (ClickedCP){
                    case 0:
                        if(symbol_adapter.isAdapterChecked()&&cp1_adapter.isAdapterChecked()){   //symbol과 cp 그리드뷰가 선택되어있고
                            if(cp1_adapter.items.get(cp1_adapter.getCheckedItem()).ID == 1){  //선택한 cp 그리드뷰가 비어있을때
                                cp1_adapter.items.remove(cp1_adapter.getCheckedItem());   //비어있는 cp의 상징을 제거하고
                                cp1_adapter.addItem(symbol_adapter.items.get(symbol_adapter.getCheckedItem()),cp1_adapter.getCheckedItem());  //symbol의 상징을 cp에 추가한다
                                symbol_adapter.items.remove(symbol_adapter.getCheckedItem());   //symbol에서 제거한다

                                symbol_adapter.setCheckedItem(100);
                                cp1_adapter.setCheckedItem(100);
                                symbol_adapter.setAdapterChecked(false);    //둘 다 체크 지우기
                                cp1_adapter.setAdapterChecked(false);

                                cp1_adapter.notifyDataSetChanged();  //어댑터 새로고침
                                symbol_adapter.notifyDataSetChanged();
                                CpGridView.setAdapter(cp1_adapter);  //그리드뷰 새로고침
                                symbolGridView.setAdapter(symbol_adapter);
                            }else{
                                Toast.makeText(getApplicationContext(), "비어있는 위치를 선택해주세요", Toast.LENGTH_SHORT).show();
                            }
                        }else{}
                        break;
                    case 1:
                        if(symbol_adapter.isAdapterChecked()&&cp2_adapter.isAdapterChecked()){   //symbol과 cp 그리드뷰가 선택되어있고
                            if(cp2_adapter.items.get(cp2_adapter.getCheckedItem()).ID == 1){  //선택한 cp 그리드뷰가 비어있을때
                                cp2_adapter.items.remove(cp2_adapter.getCheckedItem());   //비어있는 cp의 상징을 제거하고
                                cp2_adapter.addItem(symbol_adapter.items.get(symbol_adapter.getCheckedItem()),cp2_adapter.getCheckedItem());  //symbol의 상징을 cp에 추가한다
                                symbol_adapter.items.remove(symbol_adapter.getCheckedItem());   //symbol에서 제거한다

                                symbol_adapter.setCheckedItem(100);
                                cp2_adapter.setCheckedItem(100);
                                symbol_adapter.setAdapterChecked(false);    //둘 다 체크 지우기
                                cp2_adapter.setAdapterChecked(false);

                                cp2_adapter.notifyDataSetChanged();  //어댑터 새로고침
                                symbol_adapter.notifyDataSetChanged();
                                CpGridView.setAdapter(cp2_adapter);  //그리드뷰 새로고침
                                symbolGridView.setAdapter(symbol_adapter);
                            }else{
                                Toast.makeText(getApplicationContext(), "비어있는 위치를 선택해주세요", Toast.LENGTH_SHORT).show();
                            }
                        }else{}
                        break;
                    case 2:
                        if(symbol_adapter.isAdapterChecked()&&cp3_adapter.isAdapterChecked()){   //symbol과 cp 그리드뷰가 선택되어있고
                            if(cp3_adapter.items.get(cp3_adapter.getCheckedItem()).ID == 1){  //선택한 cp 그리드뷰가 비어있을때
                                cp3_adapter.items.remove(cp3_adapter.getCheckedItem());   //비어있는 cp의 상징을 제거하고
                                cp3_adapter.addItem(symbol_adapter.items.get(symbol_adapter.getCheckedItem()),cp3_adapter.getCheckedItem());  //symbol의 상징을 cp에 추가한다
                                symbol_adapter.items.remove(symbol_adapter.getCheckedItem());   //symbol에서 제거한다

                                symbol_adapter.setCheckedItem(100);
                                cp3_adapter.setCheckedItem(100);
                                symbol_adapter.setAdapterChecked(false);    //둘 다 체크 지우기
                                cp3_adapter.setAdapterChecked(false);

                                cp3_adapter.notifyDataSetChanged();  //어댑터 새로고침
                                symbol_adapter.notifyDataSetChanged();
                                CpGridView.setAdapter(cp3_adapter);  //그리드뷰 새로고침
                                symbolGridView.setAdapter(symbol_adapter);
                            }else{
                                Toast.makeText(getApplicationContext(), "비어있는 위치를 선택해주세요", Toast.LENGTH_SHORT).show();
                            }
                        }else{}
                        break;
                    default:
                        Toast.makeText(CpChangeActivity.this, "오류입니다", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        //의사소통판에 있는 상징 빼기
        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (ClickedCP){
                    case 0:
                        if(cp1_adapter.isAdapterChecked() && cp1_adapter.items.get(cp1_adapter.getCheckedItem()).ID != 1) { //cp가 선택되고 선택된 심볼이 비어있지 않을 때
                            symbol_adapter.addItem(cp1_adapter.items.get(cp1_adapter.getCheckedItem()));  //선택한 상징을 symbol 그리드뷰에 추가한다.
                            cp1_adapter.items.remove(cp1_adapter.getCheckedItem());   //선택한 상징을 제거하고

                            cp1_adapter.items.add(symbolList.get(0));  //제거한 자리에 1번 상징 (빈 상징) 추가

                            symbol_adapter.setCheckedItem(100);
                            cp1_adapter.setCheckedItem(100);
                            cp1_adapter.setAdapterChecked(false); //체크 지우기
                            cp1_adapter.notifyDataSetChanged();  //어댑터 새로고침
                            symbol_adapter.notifyDataSetChanged();
                            CpGridView.setAdapter(cp1_adapter);  //그리드뷰 새로고침
                            symbolGridView.setAdapter(symbol_adapter);
                        }else{
                            Toast.makeText(getApplicationContext(), "비어있지 않은 상징을 선택해주세요", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        if(cp2_adapter.isAdapterChecked() && cp2_adapter.items.get(cp2_adapter.getCheckedItem()).ID != 1) { //cp가 선택되고 선택된 심볼이 비어있지 않을 때
                            symbol_adapter.addItem(cp2_adapter.items.get(cp2_adapter.getCheckedItem()));  //선택한 상징을 symbol 그리드뷰에 추가한다.
                            cp2_adapter.items.remove(cp2_adapter.getCheckedItem());   //선택한 상징을 제거하고

                            cp2_adapter.items.add(symbolList.get(0));  //제거한 자리에 1번 상징 (빈 상징) 추가

                            symbol_adapter.setCheckedItem(100);
                            cp2_adapter.setCheckedItem(100);
                            cp2_adapter.setAdapterChecked(false); //체크 지우기
                            cp2_adapter.notifyDataSetChanged();  //어댑터 새로고침
                            symbol_adapter.notifyDataSetChanged();
                            CpGridView.setAdapter(cp2_adapter);  //그리드뷰 새로고침
                            symbolGridView.setAdapter(symbol_adapter);
                        }else{
                            Toast.makeText(getApplicationContext(), "비어있지 않은 상징을 선택해주세요", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        if(cp3_adapter.isAdapterChecked() && cp3_adapter.items.get(cp3_adapter.getCheckedItem()).ID != 1) { //cp가 선택되고 선택된 심볼이 비어있지 않을 때
                            symbol_adapter.addItem(cp3_adapter.items.get(cp3_adapter.getCheckedItem()));  //선택한 상징을 symbol 그리드뷰에 추가한다.
                            cp3_adapter.items.remove(cp3_adapter.getCheckedItem());   //선택한 상징을 제거하고

                            cp3_adapter.items.add(symbolList.get(0));  //제거한 자리에 1번 상징 (빈 상징) 추가

                            symbol_adapter.setCheckedItem(100);
                            cp3_adapter.setCheckedItem(100);
                            cp3_adapter.setAdapterChecked(false); //체크 지우기
                            cp3_adapter.notifyDataSetChanged();  //어댑터 새로고침
                            symbol_adapter.notifyDataSetChanged();
                            CpGridView.setAdapter(cp3_adapter);  //그리드뷰 새로고침
                            symbolGridView.setAdapter(symbol_adapter);
                        }else{
                            Toast.makeText(getApplicationContext(), "비어있지 않은 상징을 선택해주세요", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        Toast.makeText(CpChangeActivity.this, "오류입니다", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        //저장버튼 누르면 db에 현재 화면 저장
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> oldsymbolList = new ArrayList<Integer>();

                switch (ClickedCP) {
                    case 0:
                        oldsymbolList = dbQuery.getTableSymbol("일상");
                        for (int i =0; i<16; i++) {
                            if(cp1_adapter.items.get(i).ID-1 != oldsymbolList.get(i)){
                                dbQuery.setUsedFalse(oldsymbolList.get(i));
                                dbQuery.setUsedTrue(cp1_adapter.items.get(i).ID);
                                dbQuery.setChangeCP("일상", (int) cp1_adapter.items.get(i).ID, i+1);
                            }
                        }
                        break;
                    case 1:
                        oldsymbolList = dbQuery.getTableSymbol("음식");
                        for (int i =0; i<16; i++) {
                            if(cp2_adapter.items.get(i).ID-1 != oldsymbolList.get(i)){
                                dbQuery.setUsedFalse(oldsymbolList.get(i));
                                dbQuery.setUsedTrue(cp2_adapter.items.get(i).ID);
                                dbQuery.setChangeCP("음식", (int) cp2_adapter.items.get(i).ID, i+1);
                            }
                        }
                        break;
                    case 2:
                        oldsymbolList = dbQuery.getTableSymbol("도움");
                        for (int i =0; i<16; i++) {
                            if(cp3_adapter.items.get(i).ID-1 != oldsymbolList.get(i)){
                                dbQuery.setUsedFalse(oldsymbolList.get(i));
                                dbQuery.setUsedTrue(cp3_adapter.items.get(i).ID);
                                dbQuery.setChangeCP("도움", (int) cp3_adapter.items.get(i).ID, i+1);
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

                switch (ClickedCP) {
                    case 0:
                        if (position == cp1_adapter.getCheckedItem()) {
                            cp1_adapter.setCheckedItem(0);
                            cp1_adapter.setAdapterChecked(false);
                        } else {
                            cp1_adapter.setCheckedItem(position);
                            cp1_adapter.setAdapterChecked(true);
                        }

                        cp1_adapter.notifyDataSetChanged();
                        CpGridView.setAdapter(cp1_adapter);
                        break;
                    case 1:

                        if (position == cp2_adapter.getCheckedItem()) {
                            cp2_adapter.setCheckedItem(0);
                            cp2_adapter.setAdapterChecked(false);
                        } else {
                            cp2_adapter.setCheckedItem(position);
                            cp2_adapter.setAdapterChecked(true);
                        }

                        cp2_adapter.notifyDataSetChanged();
                        CpGridView.setAdapter(cp2_adapter);
                        break;
                    case 2:

                        if (position == cp3_adapter.getCheckedItem()) {
                            cp3_adapter.setCheckedItem(0);
                            cp3_adapter.setAdapterChecked(false);
                        } else {
                            cp3_adapter.setCheckedItem(position);
                            cp3_adapter.setAdapterChecked(true);
                        }

                        cp3_adapter.notifyDataSetChanged();
                        CpGridView.setAdapter(cp3_adapter);
                        break;
                }
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
    protected void cp_init(){
        //cp 1,2,3 초기화

        cp1_adapter.clear();
        cp2_adapter.clear();
        cp3_adapter.clear();
        symbol_adapter.clear();
        noUsedList.clear();

        cp1List.clear();
        cp2List.clear();
        cp3List.clear();
        noUsedList.clear();
        symbolList.clear();

        cp1List = dbQuery.getTableSymbol("일상");
        cp2List = dbQuery.getTableSymbol("음식");
        cp3List = dbQuery.getTableSymbol("도움");
        noUsedList = dbQuery.getNoUsedSymbol();
        symbolList = dbQuery.getAllSymbol();

        for (int i = 0; i < cp1List.size(); i++) {
            cp1_adapter.addItem(symbolList.get(cp1List.get(i)));
        }
        for (int i = 0; i < cp2List.size(); i++) {
            cp2_adapter.addItem(symbolList.get(cp2List.get(i)));
        }
        for (int i = 0; i < cp3List.size(); i++) {
            cp3_adapter.addItem(symbolList.get(cp3List.get(i)));
        }
        for (int i = 1; i < noUsedList.size(); i++) {
            symbol_adapter.addItem(symbolList.get(noUsedList.get(i)));
        }
        //위 그리드뷰 기본 화면 출력
        CpGridView.setAdapter(cp1_adapter);

        //아래 그리드뷰 기본 출력화면
        symbolGridView.setAdapter(symbol_adapter);
    }
}
