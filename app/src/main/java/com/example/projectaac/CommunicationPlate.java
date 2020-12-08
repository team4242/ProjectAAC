package com.example.projectaac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CommunicationPlate extends AppCompatActivity {

    int count = 0;
    Button btn_recommand, btn_1, btn_2, btn_3, btn_4, btn_5;
    ImageButton btn_tts;
    ImageButton btn_home;
    LinearLayout layout_a,layout_b,layout_c,layout_d,layout_1,layout_2,layout_3,layout_4,layout_5,layout_6,layout_7,layout_8,layout_9,layout_10,layout_11,layout_12,layout_13,layout_14,layout_15,layout_16;
    ImageView image_a,image_b,image_c,image_d,image_1,image_2,image_3,image_4,image_5,image_6,image_7,image_8,image_9,image_10,image_11,image_12,image_13,image_14,image_15,image_16;
    TextView texta,textb,textc,textd,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16;
    GridView CpGridView, symbolGridView;
    GridSymbolAdapter adapter;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_plate);

        dbManager = new DBManager(this);

        btn_recommand = (Button)findViewById(R.id.btn_recommend);
        btn_recommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Location_recommend.class);
                startActivity(intent);
            }
        });

        btn_tts = (ImageButton)findViewById(R.id.btn_tts);
        btn_tts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TTS.class);
                startActivity(intent);
            }
        });

        btn_home = (ImageButton)findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_1.setImageResource(R.drawable.an_nyeong_ha_se_yo_002_);
                image_2.setImageResource(R.drawable.cin_gu_);
                image_3.setImageResource(R.drawable.joh_a_yo_002_);
                image_4.setImageResource(R.drawable.silh_eo_yo_);
                image_5.setImageResource(R.drawable.gi_bun_joh_a_yo_);
                image_6.setImageResource(R.drawable.ju_se_yo_002_);
                image_7.setImageResource(R.drawable.mul_002_1);
                image_8.setImageResource(R.drawable.u_yu_003_);
                image_9.setImageResource(R.drawable.mu_seun_mal_in_ji_jal_mo_reu_gess_eo_yo_);
                image_10.setImageResource(R.drawable.geod_da_);
                image_11.setImageResource(R.drawable.gwa_ja_);
                image_12.setImageResource(R.drawable.gyul_);
                image_13.setImageResource(R.drawable.hag_gyo_001_);
                image_14.setImageResource(R.drawable.meog_eo_yo_);
                image_15.setImageResource(R.drawable.sig_sa_ha_gi_);
                image_16.setImageResource(R.drawable.yi_sa_seon_saeng_nim_002_);
                text1.setText("안녕하세요");
                text2.setText("친구");
                text3.setText("좋아요");
                text4.setText("싫어요");
                text5.setText("기분좋아요");
                text6.setText("주세요");
                text7.setText("물");
                text8.setText("우유");
                text9.setText("모르겠어요");
                text10.setText("걸어가요");
                text11.setText("간식");
                text12.setText("과일");
                text13.setText("학교");
                text14.setText("먹어요");
                text15.setText("수저");
                text16.setText("의사선생님");
                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);
            }
        });

        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_5.setImageResource(R.drawable.an_nyeong_ha_se_yo_002_);
                image_6.setImageResource(R.drawable.cin_gu_);
                image_7.setImageResource(R.drawable.joh_a_yo_002_);
                image_8.setImageResource(R.drawable.silh_eo_yo_);
                image_9.setImageResource(R.drawable.gi_bun_joh_a_yo_);
                image_10.setImageResource(R.drawable.ju_se_yo_002_);
                image_11.setImageResource(R.drawable.mul_002_1);
                image_12.setImageResource(R.drawable.u_yu_003_);
                image_13.setImageResource(R.drawable.mu_seun_mal_in_ji_jal_mo_reu_gess_eo_yo_);
                image_14.setImageResource(R.drawable.geod_da_);
                image_15.setImageResource(R.drawable.gwa_ja_);
                image_16.setImageResource(R.drawable.gyul_);
                image_1.setImageResource(R.drawable.hag_gyo_001_);
                image_2.setImageResource(R.drawable.meog_eo_yo_);
                image_3.setImageResource(R.drawable.sig_sa_ha_gi_);
                image_4.setImageResource(R.drawable.yi_sa_seon_saeng_nim_002_);
                text5.setText("안녕하세요");
                text6.setText("친구");
                text7.setText("좋아요");
                text8.setText("싫어요");
                text9.setText("기분좋아요");
                text10.setText("주세요");
                text11.setText("물");
                text12.setText("우유");
                text13.setText("모르겠어요");
                text14.setText("걸어가요");
                text15.setText("간식");
                text16.setText("과일");
                text1.setText("학교");
                text2.setText("먹어요");
                text3.setText("수저");
                text4.setText("의사선생님");
                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);
            }
        });

        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //각 버튼에 해당하는 테이블의 symbol을 불러와서 출력하는 기능
                DBQuery dbQuery = new DBQuery(dbManager);
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                symbolList = dbQuery.getTableSymbol("일상");  //일상 테이블의 상징id 저장
                Cursor cursor = dbQuery.getAllSymbol(); //모든 심볼 불러옴
                cursor.moveToFirst();   //왠지 모르게 이거 안하면 에러남
                cursor.moveToPosition(symbolList.get(0));
                text1.setText(cursor.getString(1));
                image_1.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(1));
                text2.setText(cursor.getString(1));
                image_2.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(2));
                text3.setText(cursor.getString(1));
                image_3.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(3));
                text4.setText(cursor.getString(1));
                image_4.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(4));
                text5.setText(cursor.getString(1));
                image_5.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(5));
                text6.setText(cursor.getString(1));
                image_6.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(6));
                text7.setText(cursor.getString(1));
                image_7.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(7));
                text8.setText(cursor.getString(1));
                image_8.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(8));
                text9.setText(cursor.getString(1));
                image_9.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(9));
                text10.setText(cursor.getString(1));
                image_10.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(10));
                text11.setText(cursor.getString(1));
                image_11.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(11));
                text12.setText(cursor.getString(1));
                image_12.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(12));
                text13.setText(cursor.getString(1));
                image_13.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(13));
                text14.setText(cursor.getString(1));
                image_14.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(14));
                text15.setText(cursor.getString(1));
                image_15.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(15));
                text16.setText(cursor.getString(1));
                image_16.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                dbQuery.dbClose();      //꼭꼭 닫아줍시다

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);
            }
        });

        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //각 버튼에 해당하는 테이블의 symbol을 불러와서 출력하는 기능
                DBQuery dbQuery = new DBQuery(dbManager);
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                symbolList = dbQuery.getTableSymbol("음식");  //일상 테이블의 상징id 저장
                Cursor cursor = dbQuery.getAllSymbol(); //모든 심볼 불러옴
                cursor.moveToFirst();   //왠지 모르게 이거 안하면 에러남
                cursor.moveToPosition(symbolList.get(0));
                text1.setText(cursor.getString(1));
                image_1.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(1));
                text2.setText(cursor.getString(1));
                image_2.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(2));
                text3.setText(cursor.getString(1));
                image_3.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(3));
                text4.setText(cursor.getString(1));
                image_4.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(4));
                text5.setText(cursor.getString(1));
                image_5.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(5));
                text6.setText(cursor.getString(1));
                image_6.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(6));
                text7.setText(cursor.getString(1));
                image_7.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(7));
                text8.setText(cursor.getString(1));
                image_8.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(8));
                text9.setText(cursor.getString(1));
                image_9.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(9));
                text10.setText(cursor.getString(1));
                image_10.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(10));
                text11.setText(cursor.getString(1));
                image_11.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(11));
                text12.setText(cursor.getString(1));
                image_12.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(12));
                text13.setText(cursor.getString(1));
                image_13.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(13));
                text14.setText(cursor.getString(1));
                image_14.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(14));
                text15.setText(cursor.getString(1));
                image_15.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(15));
                text16.setText(cursor.getString(1));
                image_16.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                dbQuery.dbClose();      //꼭꼭 닫아줍시다

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);
            }
        });

        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //각 버튼에 해당하는 테이블의 symbol을 불러와서 출력하는 기능
                DBQuery dbQuery = new DBQuery(dbManager);
                ArrayList<Integer> symbolList = new ArrayList<Integer>();
                symbolList = dbQuery.getTableSymbol("도움");  //일상 테이블의 상징id 저장
                Cursor cursor = dbQuery.getAllSymbol(); //모든 심볼 불러옴
                cursor.moveToFirst();   //왠지 모르게 이거 안하면 에러남
                cursor.moveToPosition(symbolList.get(0));
                text1.setText(cursor.getString(1));
                image_1.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(1));
                text2.setText(cursor.getString(1));
                image_2.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(2));
                text3.setText(cursor.getString(1));
                image_3.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(3));
                text4.setText(cursor.getString(1));
                image_4.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(4));
                text5.setText(cursor.getString(1));
                image_5.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(5));
                text6.setText(cursor.getString(1));
                image_6.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(6));
                text7.setText(cursor.getString(1));
                image_7.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(7));
                text8.setText(cursor.getString(1));
                image_8.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(8));
                text9.setText(cursor.getString(1));
                image_9.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(9));
                text10.setText(cursor.getString(1));
                image_10.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(10));
                text11.setText(cursor.getString(1));
                image_11.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(11));
                text12.setText(cursor.getString(1));
                image_12.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(12));
                text13.setText(cursor.getString(1));
                image_13.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(13));
                text14.setText(cursor.getString(1));
                image_14.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(14));
                text15.setText(cursor.getString(1));
                image_15.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                cursor.moveToPosition(symbolList.get(15));
                text16.setText(cursor.getString(1));
                image_16.setImageDrawable(Drawable.createFromPath(cursor.getString(2)));
                dbQuery.dbClose();      //꼭꼭 닫아줍시다

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);
            }
        });

        image_a = (ImageView)findViewById(R.id.image_a);
        image_b = (ImageView)findViewById(R.id.image_b);
        image_c = (ImageView)findViewById(R.id.image_c);
        image_d = (ImageView)findViewById(R.id.image_d);
        image_1 = (ImageView)findViewById(R.id.image_1);
        image_2 = (ImageView)findViewById(R.id.image_2);
        image_3 = (ImageView)findViewById(R.id.image_3);
        image_4 = (ImageView)findViewById(R.id.image_4);
        image_5 = (ImageView)findViewById(R.id.image_5);
        image_6 = (ImageView)findViewById(R.id.image_6);
        image_7 = (ImageView)findViewById(R.id.image_7);
        image_8 = (ImageView)findViewById(R.id.image_8);
        image_9 = (ImageView)findViewById(R.id.image_9);
        image_10 = (ImageView)findViewById(R.id.image_10);
        image_11 = (ImageView)findViewById(R.id.image_11);
        image_12 = (ImageView)findViewById(R.id.image_12);
        image_13 = (ImageView)findViewById(R.id.image_13);
        image_14 = (ImageView)findViewById(R.id.image_14);
        image_15 = (ImageView)findViewById(R.id.image_15);
        image_16 = (ImageView)findViewById(R.id.image_16);

        layout_a = (LinearLayout)findViewById(R.id.layout_a);
        layout_b = (LinearLayout)findViewById(R.id.layout_b);
        layout_c = (LinearLayout)findViewById(R.id.layout_c);
        layout_d = (LinearLayout)findViewById(R.id.layout_d);
        layout_1 = (LinearLayout)findViewById(R.id.layout_1);
        layout_2 = (LinearLayout)findViewById(R.id.layout_2);
        layout_3 = (LinearLayout)findViewById(R.id.layout_3);
        layout_4 = (LinearLayout)findViewById(R.id.layout_4);
        layout_5 = (LinearLayout)findViewById(R.id.layout_5);
        layout_6 = (LinearLayout)findViewById(R.id.layout_6);
        layout_7 = (LinearLayout)findViewById(R.id.layout_7);
        layout_8 = (LinearLayout)findViewById(R.id.layout_8);
        layout_9 = (LinearLayout)findViewById(R.id.layout_9);
        layout_10 = (LinearLayout)findViewById(R.id.layout_10);
        layout_11 = (LinearLayout)findViewById(R.id.layout_11);
        layout_12 = (LinearLayout)findViewById(R.id.layout_12);
        layout_13 = (LinearLayout)findViewById(R.id.layout_13);
        layout_14 = (LinearLayout)findViewById(R.id.layout_14);
        layout_15 = (LinearLayout)findViewById(R.id.layout_15);
        layout_16 = (LinearLayout)findViewById(R.id.layout_16);

        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        text3 = (TextView)findViewById(R.id.text3);
        text4 = (TextView)findViewById(R.id.text4);
        text5 = (TextView)findViewById(R.id.text5);
        text6 = (TextView)findViewById(R.id.text6);
        text7 = (TextView)findViewById(R.id.text7);
        text8 = (TextView)findViewById(R.id.text8);
        text9 = (TextView)findViewById(R.id.text9);
        text10 = (TextView)findViewById(R.id.text10);
        text11 = (TextView)findViewById(R.id.text11);
        text12 = (TextView)findViewById(R.id.text12);
        text13 = (TextView)findViewById(R.id.text13);
        text14 = (TextView)findViewById(R.id.text14);
        text15 = (TextView)findViewById(R.id.text15);
        text16 = (TextView)findViewById(R.id.text16);
        texta = (TextView)findViewById(R.id.texta);
        textb = (TextView)findViewById(R.id.textb);
        textc = (TextView)findViewById(R.id.textc);
        textd = (TextView)findViewById(R.id.textd);

        layout_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 1) {
                    image_a.setImageResource(0);
                    texta.setText("");
                    count--;
                }
                else if (count == 2) {
                    image_a.setImageResource(0);
                    image_b.setImageResource(0);
                    texta.setText("");
                    textb.setText("");
                    count--;
                    count--;
                }
                else if (count == 3 ) {
                    image_a.setImageResource(0);
                    image_b.setImageResource(0);
                    image_c.setImageResource(0);
                    texta.setText("");
                    textb.setText("");
                    textc.setText("");
                    count--;
                    count--;
                    count--;
                }
                else if (count == 4){
                    image_a.setImageResource(0);
                    image_b.setImageResource(0);
                    image_c.setImageResource(0);
                    image_d.setImageResource(0);
                    texta.setText("");
                    textb.setText("");
                    textc.setText("");
                    textd.setText("");
                    count--;
                    count--;
                    count--;
                    count--;
                }else{

                }

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

            }
        });

        layout_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 2) {
                    image_b.setImageResource(0);
                    textb.setText("");
                    count--;
                }
                else if (count == 3 ) {
                    image_b.setImageResource(0);
                    image_c.setImageResource(0);
                    textb.setText("");
                    textc.setText("");
                    count--;
                    count--;
                }
                else if (count == 4) {
                    image_b.setImageResource(0);
                    image_c.setImageResource(0);
                    image_d.setImageResource(0);
                    textb.setText("");
                    textc.setText("");
                    textd.setText("");
                    count--;
                    count--;
                    count--;
                }else{

                }

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

            }
        });

        layout_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 3 ) {
                    image_c.setImageResource(0);
                    textc.setText("");
                    count--;
                }
                else if (count == 4) {
                    image_c.setImageResource(0);
                    image_d.setImageResource(0);
                    textc.setText("");
                    textd.setText("");
                    count--;
                    count--;
                }else{

                }

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

            }
        });

        layout_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 4) {
                    image_d.setImageResource(0);
                    textd.setText("");
                    count--;
                }

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

            }
        });


        layout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_1)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text1.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_1)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text1.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_1)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text1.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_1)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text1.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_2.setBackgroundColor(Color.RED);
                layout_6.setBackgroundColor(Color.YELLOW);
                layout_10.setBackgroundColor(Color.GREEN);
            }
        });

        layout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_2)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text2.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_2)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text2.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_2)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text2.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_2)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text2.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_8.setBackgroundColor(Color.RED);
                layout_4.setBackgroundColor(Color.YELLOW);
                layout_12.setBackgroundColor(Color.GREEN);
            }
        });

        layout_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_3)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text3.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_3)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text3.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_3)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text3.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_3)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text3.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_5.setBackgroundColor(Color.RED);
                layout_9.setBackgroundColor(Color.YELLOW);
                layout_1.setBackgroundColor(Color.GREEN);
            }
        });

        layout_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_4)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text4.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_4)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text4.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_4)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text4.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_4)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text4.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_12.setBackgroundColor(Color.RED);
                layout_7.setBackgroundColor(Color.YELLOW);
                layout_15.setBackgroundColor(Color.GREEN);
            }
        });

        layout_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_5)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text5.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_5)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text5.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_5)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text5.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_5)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text5.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_8.setBackgroundColor(Color.RED);
                layout_3.setBackgroundColor(Color.YELLOW);
                layout_14.setBackgroundColor(Color.GREEN);
            }
        });

        layout_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_6)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text6.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_6)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text6.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_6)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text6.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_6)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text6.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_5.setBackgroundColor(Color.RED);
                layout_8.setBackgroundColor(Color.YELLOW);
                layout_4.setBackgroundColor(Color.GREEN);
            }
        });

        layout_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_7)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text7.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_7)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text7.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_7)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text7.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_7)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text7.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_12.setBackgroundColor(Color.RED);
                layout_16.setBackgroundColor(Color.YELLOW);
                layout_4.setBackgroundColor(Color.GREEN);
            }
        });

        layout_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_8)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text8.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_8)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text8.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_8)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text8.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_8)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text8.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_3.setBackgroundColor(Color.RED);
                layout_13.setBackgroundColor(Color.YELLOW);
                layout_9.setBackgroundColor(Color.GREEN);
            }
        });

        layout_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_9)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text9.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_9)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text9.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_9)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text9.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_9)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text9.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_6.setBackgroundColor(Color.RED);
                layout_12.setBackgroundColor(Color.YELLOW);
                layout_5.setBackgroundColor(Color.GREEN);
            }
        });

        layout_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_10)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text10.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_10)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text10.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_10)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text10.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_10)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text10.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_3.setBackgroundColor(Color.RED);
                layout_1.setBackgroundColor(Color.YELLOW);
                layout_11.setBackgroundColor(Color.GREEN);
            }
        });

        layout_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_11)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text11.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_11)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text11.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_11)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text11.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_11)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text11.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_1.setBackgroundColor(Color.RED);
                layout_6.setBackgroundColor(Color.YELLOW);
                layout_12.setBackgroundColor(Color.GREEN);
            }
        });

        layout_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_12)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text12.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_12)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text12.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_12)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text12.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_12)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text12.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_2.setBackgroundColor(Color.RED);
                layout_7.setBackgroundColor(Color.YELLOW);
                layout_13.setBackgroundColor(Color.GREEN);
            }
        });

        layout_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_13)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text13.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_13)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text13.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_13)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text13.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_13)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text13.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_3.setBackgroundColor(Color.RED);
                layout_8.setBackgroundColor(Color.YELLOW);
                layout_14.setBackgroundColor(Color.GREEN);
            }
        });

        layout_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_14)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text14.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_14)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text14.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_14)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text14.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_14)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text14.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_4.setBackgroundColor(Color.RED);
                layout_9.setBackgroundColor(Color.YELLOW);
                layout_15.setBackgroundColor(Color.GREEN);
            }
        });

        layout_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_15)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text15.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_15)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text15.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_15)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text15.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_15)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text15.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_5.setBackgroundColor(Color.RED);
                layout_10.setBackgroundColor(Color.YELLOW);
                layout_16.setBackgroundColor(Color.GREEN);
            }
        });

        layout_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_16)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_a.setImageBitmap(b);
                    texta.setText(text16.getText());
                    count ++;
                }else if(count == 1){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_16)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_b.setImageBitmap(b);
                    textb.setText(text16.getText());
                    count ++;
                }else if(count == 2){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_16)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_c.setImageBitmap(b);
                    textc.setText(text16.getText());
                    count ++;
                }else if(count == 3){
                    BitmapDrawable d = (BitmapDrawable)((ImageView) findViewById(R.id.image_16)).getDrawable();
                    Bitmap b = d.getBitmap();
                    image_d.setImageBitmap(b);
                    textd.setText(text16.getText());
                    count ++;}

                layout_1.setBackgroundColor(Color.WHITE);
                layout_2.setBackgroundColor(Color.WHITE);
                layout_3.setBackgroundColor(Color.WHITE);
                layout_4.setBackgroundColor(Color.WHITE);
                layout_5.setBackgroundColor(Color.WHITE);
                layout_6.setBackgroundColor(Color.WHITE);
                layout_7.setBackgroundColor(Color.WHITE);
                layout_8.setBackgroundColor(Color.WHITE);
                layout_9.setBackgroundColor(Color.WHITE);
                layout_10.setBackgroundColor(Color.WHITE);
                layout_11.setBackgroundColor(Color.WHITE);
                layout_12.setBackgroundColor(Color.WHITE);
                layout_13.setBackgroundColor(Color.WHITE);
                layout_14.setBackgroundColor(Color.WHITE);
                layout_15.setBackgroundColor(Color.WHITE);
                layout_16.setBackgroundColor(Color.WHITE);

                layout_6.setBackgroundColor(Color.RED);
                layout_11.setBackgroundColor(Color.YELLOW);
                layout_1.setBackgroundColor(Color.GREEN);
            }
        });
    }
    private Bitmap getBitmap(String url) {
        URL imgUrl = null;
        HttpURLConnection connection = null;
        InputStream is = null;
        Bitmap retBitmap = null;
        try{
            imgUrl = new URL(url);
            connection = (HttpURLConnection) imgUrl.openConnection();
            connection.setDoInput(true);
            connection.connect();
            is = connection.getInputStream();
            retBitmap = BitmapFactory.decodeStream(is);
        }catch(Exception e){
            e.printStackTrace();
        return null;
        }
        finally {
            if(connection!=null) {
                connection.disconnect();
            }
            return retBitmap;
        }
    }

}
