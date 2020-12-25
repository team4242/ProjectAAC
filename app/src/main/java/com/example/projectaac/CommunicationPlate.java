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
import android.speech.tts.TextToSpeech;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public class CommunicationPlate extends AppCompatActivity {


    public TextToSpeech tts;
    String tts_statement;
    int count = 0, num = 0;
    Button btn_recommand, btn_3, btn_4, btn_5, btn_number;
    ImageButton btn_tts, btn_speak;
    ImageButton btn_home;
    LinearLayout layout_a,layout_b,layout_c,layout_d,layout_1,layout_2,layout_3,layout_4,layout_5,layout_6,layout_7,layout_8,layout_9,layout_10,layout_11,layout_12,layout_13,layout_14,layout_15,layout_16;
    ImageView image_a,image_b,image_c,image_d,image_1,image_2,image_3,image_4,image_5,image_6,image_7,image_8,image_9,image_10,image_11,image_12,image_13,image_14,image_15,image_16;
    TextView texta,textb,textc,textd,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16;
    ArrayList<SymbolListItem> cursor;
    ArrayList<Drawable> draw1, draw2, draw3;
    ArrayList<Integer> symbolList1, symbolList2, symbolList3;
    DBManager dbManager;
    DBQuery dbQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_plate);

        dbManager = new DBManager(this);
        dbQuery = new DBQuery(dbManager);
        symbolList1 = dbQuery.getTableSymbol("일상");
        symbolList2 = dbQuery.getTableSymbol("음식");
        symbolList3 = dbQuery.getTableSymbol("도움");
        cursor= dbQuery.getAllSymbol();

        draw1 = new ArrayList<>();
        draw2 = new ArrayList<>();
        draw3 = new ArrayList<>();
        for(int i =0; i<16; i++){
            draw1.add(Drawable.createFromPath(cursor.get(symbolList1.get(i)).getImagePath()));
            draw2.add(Drawable.createFromPath(cursor.get(symbolList2.get(i)).getImagePath()));
            draw3.add(Drawable.createFromPath(cursor.get(symbolList3.get(i)).getImagePath()));
        }


        tts = new TextToSpeech(CommunicationPlate.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status ==TextToSpeech.SUCCESS){
                    int result = tts.setLanguage(Locale.KOREA);
                    if(result ==TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(CommunicationPlate.this,"지원하지 않는 언어입니다",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        btn_number = (Button)findViewById(R.id.btn_number);
        btn_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num==0) {
                    ++num;
                    count=0;
                }
                text1.setText("7");
                text2.setText("8");
                text3.setText("9");
                text4.setText("/");
                text5.setText("4");
                text6.setText("5");
                text7.setText("6");
                text8.setText("x");
                text9.setText("1");
                text10.setText("2");
                text11.setText("3");
                text12.setText("-");
                text13.setText(".");
                text14.setText("0");
                text15.setText("=");
                text16.setText("+");
                image_1.setImageResource(R.drawable.blank);
                image_2.setImageResource(R.drawable.blank);
                image_3.setImageResource(R.drawable.blank);
                image_4.setImageResource(R.drawable.blank);
                image_5.setImageResource(R.drawable.blank);
                image_6.setImageResource(R.drawable.blank);
                image_7.setImageResource(R.drawable.blank);
                image_8.setImageResource(R.drawable.blank);
                image_9.setImageResource(R.drawable.blank);
                image_10.setImageResource(R.drawable.blank);
                image_11.setImageResource(R.drawable.blank);
                image_12.setImageResource(R.drawable.blank);
                image_13.setImageResource(R.drawable.blank);
                image_14.setImageResource(R.drawable.blank);
                image_15.setImageResource(R.drawable.blank);
                image_16.setImageResource(R.drawable.blank);

                image_a.setImageResource(0);
                image_b.setImageResource(0);
                image_c.setImageResource(0);
                image_d.setImageResource(0);

                texta.setText("");
                textb.setText("");
                textc.setText("");
                textd.setText("");

                image_1.getLayoutParams().height=10;
                image_2.getLayoutParams().height=10;
                image_3.getLayoutParams().height=10;
                image_4.getLayoutParams().height=10;
                image_5.getLayoutParams().height=10;
                image_6.getLayoutParams().height=10;
                image_7.getLayoutParams().height=10;
                image_8.getLayoutParams().height=10;
                image_9.getLayoutParams().height=10;
                image_10.getLayoutParams().height=10;
                image_11.getLayoutParams().height=10;
                image_12.getLayoutParams().height=10;
                image_13.getLayoutParams().height=10;
                image_14.getLayoutParams().height=10;
                image_15.getLayoutParams().height=10;
                image_16.getLayoutParams().height=10;
                image_a.getLayoutParams().height=10;
                image_b.getLayoutParams().height=10;
                image_c.getLayoutParams().height=10;
                image_d.getLayoutParams().height=10;

                text1.getLayoutParams().height=290;
                text2.getLayoutParams().height=290;
                text3.getLayoutParams().height=290;
                text4.getLayoutParams().height=290;
                text5.getLayoutParams().height=290;
                text6.getLayoutParams().height=290;
                text7.getLayoutParams().height=290;
                text8.getLayoutParams().height=290;
                text9.getLayoutParams().height=290;
                text10.getLayoutParams().height=290;
                text11.getLayoutParams().height=290;
                text12.getLayoutParams().height=290;
                text13.getLayoutParams().height=290;
                text14.getLayoutParams().height=290;
                text15.getLayoutParams().height=290;
                text16.getLayoutParams().height=290;
                texta.getLayoutParams().height=290;
                textb.getLayoutParams().height=290;
                textc.getLayoutParams().height=290;
                textd.getLayoutParams().height=290;

                text1.setTextSize(70);
                text2.setTextSize(70);
                text3.setTextSize(70);
                text4.setTextSize(70);
                text5.setTextSize(70);
                text6.setTextSize(70);
                text7.setTextSize(70);
                text8.setTextSize(70);
                text9.setTextSize(70);
                text10.setTextSize(70);
                text11.setTextSize(70);
                text12.setTextSize(70);
                text13.setTextSize(70);
                text14.setTextSize(70);
                text15.setTextSize(70);
                text16.setTextSize(70);
                texta.setTextSize(70);
                textb.setTextSize(70);
                textc.setTextSize(70);
                textd.setTextSize(70);

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

        btn_speak = (ImageButton)findViewById(R.id.btn_speak);
        btn_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = (String) texta.getText();
                String b = (String) textb.getText();
                String c = (String) textc.getText();
                String d = (String) textd.getText();
                tts_statement = a+b+c+d;
                tts.speak(tts_statement, TextToSpeech.QUEUE_FLUSH, null);
            }
        });



        texta = (TextView)findViewById(R.id.texta);
        textb = (TextView)findViewById(R.id.textb);
        textc = (TextView)findViewById(R.id.textc);
        textd = (TextView)findViewById(R.id.textd);
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

        image_a =(ImageView)findViewById(R.id.image_a);
        image_b =(ImageView)findViewById(R.id.image_b);
        image_c =(ImageView)findViewById(R.id.image_c);
        image_d =(ImageView)findViewById(R.id.image_d);
        image_1 =(ImageView)findViewById(R.id.image_1);
        image_2 =(ImageView)findViewById(R.id.image_2);
        image_3 =(ImageView)findViewById(R.id.image_3);
        image_4 =(ImageView)findViewById(R.id.image_4);
        image_5 =(ImageView)findViewById(R.id.image_5);
        image_6 =(ImageView)findViewById(R.id.image_6);
        image_7 =(ImageView)findViewById(R.id.image_7);
        image_8 =(ImageView)findViewById(R.id.image_8);
        image_9 =(ImageView)findViewById(R.id.image_9);
        image_10 =(ImageView)findViewById(R.id.image_10);
        image_11 =(ImageView)findViewById(R.id.image_11);
        image_12 =(ImageView)findViewById(R.id.image_12);
        image_13 =(ImageView)findViewById(R.id.image_13);
        image_14 =(ImageView)findViewById(R.id.image_14);
        image_15 =(ImageView)findViewById(R.id.image_15);
        image_16 =(ImageView)findViewById(R.id.image_16);

        layout_a = (LinearLayout)findViewById(R.id.layout_a);
        layout_b = (LinearLayout)findViewById(R.id.layout_b);
        layout_c = (LinearLayout)findViewById(R.id.layout_c);
        layout_d = (LinearLayout)findViewById(R.id.layout_d);
        layout_1 = (LinearLayout)findViewById(R.id.layout_1);
        layout_2 = (LinearLayout)findViewById(R.id.layout_2);
        layout_3= (LinearLayout)findViewById(R.id.layout_3);
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

        texta.setText("");
        textb.setText("");
        textc.setText("");
        textd.setText("");
        image_a.setImageResource(0);
        image_b.setImageResource(0);
        image_c.setImageResource(0);
        image_d.setImageResource(0);
        num=0;
        count=0;

        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,90,getResources().getDisplayMetrics());
        image_1.getLayoutParams().height = width;
        image_2.getLayoutParams().height = width;
        image_3.getLayoutParams().height = width;
        image_4.getLayoutParams().height = width;
        image_5.getLayoutParams().height = width;
        image_6.getLayoutParams().height = width;
        image_7.getLayoutParams().height = width;
        image_8.getLayoutParams().height = width;
        image_9.getLayoutParams().height = width;
        image_10.getLayoutParams().height = width;
        image_11.getLayoutParams().height = width;
        image_12.getLayoutParams().height = width;
        image_13.getLayoutParams().height = width;
        image_14.getLayoutParams().height = width;
        image_15.getLayoutParams().height = width;
        image_16.getLayoutParams().height = width;
        image_a.getLayoutParams().height = width;
        image_b.getLayoutParams().height = width;
        image_c.getLayoutParams().height = width;
        image_d.getLayoutParams().height = width;

        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,getResources().getDisplayMetrics());
        text1.getLayoutParams().height=height;
        text2.getLayoutParams().height=height;
        text3.getLayoutParams().height=height;
        text4.getLayoutParams().height=height;
        text5.getLayoutParams().height=height;
        text6.getLayoutParams().height=height;
        text7.getLayoutParams().height=height;
        text8.getLayoutParams().height=height;
        text9.getLayoutParams().height=height;
        text10.getLayoutParams().height=height;
        text11.getLayoutParams().height=height;
        text12.getLayoutParams().height=height;
        text13.getLayoutParams().height=height;
        text14.getLayoutParams().height=height;
        text15.getLayoutParams().height=height;
        text16.getLayoutParams().height=height;
        texta.getLayoutParams().height=height;
        textb.getLayoutParams().height=height;
        textc.getLayoutParams().height=height;
        textd.getLayoutParams().height=height;

        text1.setTextSize(14);
        text2.setTextSize(14);
        text3.setTextSize(14);
        text4.setTextSize(14);
        text5.setTextSize(14);
        text6.setTextSize(14);
        text7.setTextSize(14);
        text8.setTextSize(14);
        text9.setTextSize(14);
        text10.setTextSize(14);
        text11.setTextSize(14);
        text12.setTextSize(14);
        text13.setTextSize(14);
        text14.setTextSize(14);
        text15.setTextSize(14);
        text16.setTextSize(14);
        texta.setTextSize(14);
        textb.setTextSize(14);
        textc.setTextSize(14);
        textd.setTextSize(14);


        text1.setText(cursor.get(symbolList1.get(0)).getName());
        image_1.setImageDrawable(draw1.get(0));
        text2.setText(cursor.get(symbolList1.get(1)).getName());
        image_2.setImageDrawable(draw1.get(1));
        text3.setText(cursor.get(symbolList1.get(2)).getName());
        image_3.setImageDrawable(draw1.get(2));
        text4.setText(cursor.get(symbolList1.get(3)).getName());
        image_4.setImageDrawable(draw1.get(3));
        text5.setText(cursor.get(symbolList1.get(4)).getName());
        image_5.setImageDrawable(draw1.get(4));
        text6.setText(cursor.get(symbolList1.get(5)).getName());
        image_6.setImageDrawable(draw1.get(5));
        text7.setText(cursor.get(symbolList1.get(6)).getName());
        image_7.setImageDrawable(draw1.get(6));
        text8.setText(cursor.get(symbolList1.get(7)).getName());
        image_8.setImageDrawable(draw1.get(7));
        text9.setText(cursor.get(symbolList1.get(8)).getName());
        image_9.setImageDrawable(draw1.get(8));
        text10.setText(cursor.get(symbolList1.get(9)).getName());
        image_10.setImageDrawable(draw1.get(9));
        text11.setText(cursor.get(symbolList1.get(10)).getName());
        image_11.setImageDrawable(draw1.get(10));
        text12.setText(cursor.get(symbolList1.get(11)).getName());
        image_12.setImageDrawable(draw1.get(11));
        text13.setText(cursor.get(symbolList1.get(12)).getName());
        image_13.setImageDrawable(draw1.get(12));
        text14.setText(cursor.get(symbolList1.get(13)).getName());
        image_14.setImageDrawable(draw1.get(13));
        text15.setText(cursor.get(symbolList1.get(14)).getName());
        image_15.setImageDrawable(draw1.get(14));
        text16.setText(cursor.get(symbolList1.get(15)).getName());
        image_16.setImageDrawable(draw1.get(15));


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


        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(num==1) {
                    texta.setText("");
                    textb.setText("");
                    textc.setText("");
                    textd.setText("");
                    image_a.setImageResource(0);
                    image_b.setImageResource(0);
                    image_c.setImageResource(0);
                    image_d.setImageResource(0);
                    num=0;
                    count=0;

                    int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,90,getResources().getDisplayMetrics());
                    image_1.getLayoutParams().height = width;
                    image_2.getLayoutParams().height = width;
                    image_3.getLayoutParams().height = width;
                    image_4.getLayoutParams().height = width;
                    image_5.getLayoutParams().height = width;
                    image_6.getLayoutParams().height = width;
                    image_7.getLayoutParams().height = width;
                    image_8.getLayoutParams().height = width;
                    image_9.getLayoutParams().height = width;
                    image_10.getLayoutParams().height = width;
                    image_11.getLayoutParams().height = width;
                    image_12.getLayoutParams().height = width;
                    image_13.getLayoutParams().height = width;
                    image_14.getLayoutParams().height = width;
                    image_15.getLayoutParams().height = width;
                    image_16.getLayoutParams().height = width;
                    image_a.getLayoutParams().height = width;
                    image_b.getLayoutParams().height = width;
                    image_c.getLayoutParams().height = width;
                    image_d.getLayoutParams().height = width;

                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,getResources().getDisplayMetrics());
                    text1.getLayoutParams().height=height;
                    text2.getLayoutParams().height=height;
                    text3.getLayoutParams().height=height;
                    text4.getLayoutParams().height=height;
                    text5.getLayoutParams().height=height;
                    text6.getLayoutParams().height=height;
                    text7.getLayoutParams().height=height;
                    text8.getLayoutParams().height=height;
                    text9.getLayoutParams().height=height;
                    text10.getLayoutParams().height=height;
                    text11.getLayoutParams().height=height;
                    text12.getLayoutParams().height=height;
                    text13.getLayoutParams().height=height;
                    text14.getLayoutParams().height=height;
                    text15.getLayoutParams().height=height;
                    text16.getLayoutParams().height=height;
                    texta.getLayoutParams().height=height;
                    textb.getLayoutParams().height=height;
                    textc.getLayoutParams().height=height;
                    textd.getLayoutParams().height=height;

                    text1.setTextSize(14);
                    text2.setTextSize(14);
                    text3.setTextSize(14);
                    text4.setTextSize(14);
                    text5.setTextSize(14);
                    text6.setTextSize(14);
                    text7.setTextSize(14);
                    text8.setTextSize(14);
                    text9.setTextSize(14);
                    text10.setTextSize(14);
                    text11.setTextSize(14);
                    text12.setTextSize(14);
                    text13.setTextSize(14);
                    text14.setTextSize(14);
                    text15.setTextSize(14);
                    text16.setTextSize(14);
                    texta.setTextSize(14);
                    textb.setTextSize(14);
                    textc.setTextSize(14);
                    textd.setTextSize(14);

                }

                //각 버튼에 해당하는 테이블의 symbol을 불러와서 출력하는 기능


                text1.setText(cursor.get(symbolList1.get(0)).getName());
                image_1.setImageDrawable(draw1.get(0));
                text2.setText(cursor.get(symbolList1.get(1)).getName());
                image_2.setImageDrawable(draw1.get(1));
                text3.setText(cursor.get(symbolList1.get(2)).getName());
                image_3.setImageDrawable(draw1.get(2));
                text4.setText(cursor.get(symbolList1.get(3)).getName());
                image_4.setImageDrawable(draw1.get(3));
                text5.setText(cursor.get(symbolList1.get(4)).getName());
                image_5.setImageDrawable(draw1.get(4));
                text6.setText(cursor.get(symbolList1.get(5)).getName());
                image_6.setImageDrawable(draw1.get(5));
                text7.setText(cursor.get(symbolList1.get(6)).getName());
                image_7.setImageDrawable(draw1.get(6));
                text8.setText(cursor.get(symbolList1.get(7)).getName());
                image_8.setImageDrawable(draw1.get(7));
                text9.setText(cursor.get(symbolList1.get(8)).getName());
                image_9.setImageDrawable(draw1.get(8));
                text10.setText(cursor.get(symbolList1.get(9)).getName());
                image_10.setImageDrawable(draw1.get(9));
                text11.setText(cursor.get(symbolList1.get(10)).getName());
                image_11.setImageDrawable(draw1.get(10));
                text12.setText(cursor.get(symbolList1.get(11)).getName());
                image_12.setImageDrawable(draw1.get(11));
                text13.setText(cursor.get(symbolList1.get(12)).getName());
                image_13.setImageDrawable(draw1.get(12));
                text14.setText(cursor.get(symbolList1.get(13)).getName());
                image_14.setImageDrawable(draw1.get(13));
                text15.setText(cursor.get(symbolList1.get(14)).getName());
                image_15.setImageDrawable(draw1.get(14));
                text16.setText(cursor.get(symbolList1.get(15)).getName());
                image_16.setImageDrawable(draw1.get(15));


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

                if(num==1) {
                    texta.setText("");
                    textb.setText("");
                    textc.setText("");
                    textd.setText("");
                    image_a.setImageResource(0);
                    image_b.setImageResource(0);
                    image_c.setImageResource(0);
                    image_d.setImageResource(0);
                    num=0;
                    count=0;

                    int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,90,getResources().getDisplayMetrics());
                    image_1.getLayoutParams().height = width;
                    image_2.getLayoutParams().height = width;
                    image_3.getLayoutParams().height = width;
                    image_4.getLayoutParams().height = width;
                    image_5.getLayoutParams().height = width;
                    image_6.getLayoutParams().height = width;
                    image_7.getLayoutParams().height = width;
                    image_8.getLayoutParams().height = width;
                    image_9.getLayoutParams().height = width;
                    image_10.getLayoutParams().height = width;
                    image_11.getLayoutParams().height = width;
                    image_12.getLayoutParams().height = width;
                    image_13.getLayoutParams().height = width;
                    image_14.getLayoutParams().height = width;
                    image_15.getLayoutParams().height = width;
                    image_16.getLayoutParams().height = width;
                    image_a.getLayoutParams().height = width;
                    image_b.getLayoutParams().height = width;
                    image_c.getLayoutParams().height = width;
                    image_d.getLayoutParams().height = width;

                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,getResources().getDisplayMetrics());
                    text1.getLayoutParams().height=height;
                    text2.getLayoutParams().height=height;
                    text3.getLayoutParams().height=height;
                    text4.getLayoutParams().height=height;
                    text5.getLayoutParams().height=height;
                    text6.getLayoutParams().height=height;
                    text7.getLayoutParams().height=height;
                    text8.getLayoutParams().height=height;
                    text9.getLayoutParams().height=height;
                    text10.getLayoutParams().height=height;
                    text11.getLayoutParams().height=height;
                    text12.getLayoutParams().height=height;
                    text13.getLayoutParams().height=height;
                    text14.getLayoutParams().height=height;
                    text15.getLayoutParams().height=height;
                    text16.getLayoutParams().height=height;
                    texta.getLayoutParams().height=height;
                    textb.getLayoutParams().height=height;
                    textc.getLayoutParams().height=height;
                    textd.getLayoutParams().height=height;

                    text1.setTextSize(14);
                    text2.setTextSize(14);
                    text3.setTextSize(14);
                    text4.setTextSize(14);
                    text5.setTextSize(14);
                    text6.setTextSize(14);
                    text7.setTextSize(14);
                    text8.setTextSize(14);
                    text9.setTextSize(14);
                    text10.setTextSize(14);
                    text11.setTextSize(14);
                    text12.setTextSize(14);
                    text13.setTextSize(14);
                    text14.setTextSize(14);
                    text15.setTextSize(14);
                    text16.setTextSize(14);
                    texta.setTextSize(14);
                    textb.setTextSize(14);
                    textc.setTextSize(14);
                    textd.setTextSize(14);

                }
                //각 버튼에 해당하는 테이블의 symbol을 불러와서 출력하는 기능


                text1.setText(cursor.get(symbolList2.get(0)).getName());
                image_1.setImageDrawable(draw2.get(0));
                text2.setText(cursor.get(symbolList2.get(1)).getName());
                image_2.setImageDrawable(draw2.get(1));
                text3.setText(cursor.get(symbolList2.get(2)).getName());
                image_3.setImageDrawable(draw2.get(2));
                text4.setText(cursor.get(symbolList2.get(3)).getName());
                image_4.setImageDrawable(draw2.get(3));
                text5.setText(cursor.get(symbolList2.get(4)).getName());
                image_5.setImageDrawable(draw2.get(4));
                text6.setText(cursor.get(symbolList2.get(5)).getName());
                image_6.setImageDrawable(draw2.get(5));
                text7.setText(cursor.get(symbolList2.get(6)).getName());
                image_7.setImageDrawable(draw2.get(6));
                text8.setText(cursor.get(symbolList2.get(7)).getName());
                image_8.setImageDrawable(draw2.get(7));
                text9.setText(cursor.get(symbolList2.get(8)).getName());
                image_9.setImageDrawable(draw2.get(8));
                text10.setText(cursor.get(symbolList2.get(9)).getName());
                image_10.setImageDrawable(draw2.get(9));
                text11.setText(cursor.get(symbolList2.get(10)).getName());
                image_11.setImageDrawable(draw2.get(10));
                text12.setText(cursor.get(symbolList2.get(11)).getName());
                image_12.setImageDrawable(draw2.get(11));
                text13.setText(cursor.get(symbolList2.get(12)).getName());
                image_13.setImageDrawable(draw2.get(12));
                text14.setText(cursor.get(symbolList2.get(13)).getName());
                image_14.setImageDrawable(draw2.get(13));
                text15.setText(cursor.get(symbolList2.get(14)).getName());
                image_15.setImageDrawable(draw2.get(14));
                text16.setText(cursor.get(symbolList2.get(15)).getName());
                image_16.setImageDrawable(draw2.get(15));

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

                if(num==1) {
                    texta.setText("");
                    textb.setText("");
                    textc.setText("");
                    textd.setText("");
                    image_a.setImageResource(0);
                    image_b.setImageResource(0);
                    image_c.setImageResource(0);
                    image_d.setImageResource(0);
                    num=0;
                    count=0;

                    int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,90,getResources().getDisplayMetrics());
                    image_1.getLayoutParams().height = width;
                    image_2.getLayoutParams().height = width;
                    image_3.getLayoutParams().height = width;
                    image_4.getLayoutParams().height = width;
                    image_5.getLayoutParams().height = width;
                    image_6.getLayoutParams().height = width;
                    image_7.getLayoutParams().height = width;
                    image_8.getLayoutParams().height = width;
                    image_9.getLayoutParams().height = width;
                    image_10.getLayoutParams().height = width;
                    image_11.getLayoutParams().height = width;
                    image_12.getLayoutParams().height = width;
                    image_13.getLayoutParams().height = width;
                    image_14.getLayoutParams().height = width;
                    image_15.getLayoutParams().height = width;
                    image_16.getLayoutParams().height = width;
                    image_a.getLayoutParams().height = width;
                    image_b.getLayoutParams().height = width;
                    image_c.getLayoutParams().height = width;
                    image_d.getLayoutParams().height = width;

                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,getResources().getDisplayMetrics());
                    text1.getLayoutParams().height=height;
                    text2.getLayoutParams().height=height;
                    text3.getLayoutParams().height=height;
                    text4.getLayoutParams().height=height;
                    text5.getLayoutParams().height=height;
                    text6.getLayoutParams().height=height;
                    text7.getLayoutParams().height=height;
                    text8.getLayoutParams().height=height;
                    text9.getLayoutParams().height=height;
                    text10.getLayoutParams().height=height;
                    text11.getLayoutParams().height=height;
                    text12.getLayoutParams().height=height;
                    text13.getLayoutParams().height=height;
                    text14.getLayoutParams().height=height;
                    text15.getLayoutParams().height=height;
                    text16.getLayoutParams().height=height;
                    texta.getLayoutParams().height=height;
                    textb.getLayoutParams().height=height;
                    textc.getLayoutParams().height=height;
                    textd.getLayoutParams().height=height;

                    text1.setTextSize(14);
                    text2.setTextSize(14);
                    text3.setTextSize(14);
                    text4.setTextSize(14);
                    text5.setTextSize(14);
                    text6.setTextSize(14);
                    text7.setTextSize(14);
                    text8.setTextSize(14);
                    text9.setTextSize(14);
                    text10.setTextSize(14);
                    text11.setTextSize(14);
                    text12.setTextSize(14);
                    text13.setTextSize(14);
                    text14.setTextSize(14);
                    text15.setTextSize(14);
                    text16.setTextSize(14);
                    texta.setTextSize(14);
                    textb.setTextSize(14);
                    textc.setTextSize(14);
                    textd.setTextSize(14);

                }

                //각 버튼에 해당하는 테이블의 symbol을 불러와서 출력하는 기능

                text1.setText(cursor.get(symbolList3.get(0)).getName());
                image_1.setImageDrawable(draw3.get(0));
                text2.setText(cursor.get(symbolList3.get(1)).getName());
                image_2.setImageDrawable(draw3.get(1));
                text3.setText(cursor.get(symbolList3.get(2)).getName());
                image_3.setImageDrawable(draw3.get(2));
                text4.setText(cursor.get(symbolList3.get(3)).getName());
                image_4.setImageDrawable(draw3.get(3));
                text5.setText(cursor.get(symbolList3.get(4)).getName());
                image_5.setImageDrawable(draw3.get(4));
                text6.setText(cursor.get(symbolList3.get(5)).getName());
                image_6.setImageDrawable(draw3.get(5));
                text7.setText(cursor.get(symbolList3.get(6)).getName());
                image_7.setImageDrawable(draw3.get(6));
                text8.setText(cursor.get(symbolList3.get(7)).getName());
                image_8.setImageDrawable(draw3.get(7));
                text9.setText(cursor.get(symbolList3.get(8)).getName());
                image_9.setImageDrawable(draw3.get(8));
                text10.setText(cursor.get(symbolList3.get(9)).getName());
                image_10.setImageDrawable(draw3.get(9));
                text11.setText(cursor.get(symbolList3.get(10)).getName());
                image_11.setImageDrawable(draw3.get(10));
                text12.setText(cursor.get(symbolList3.get(11)).getName());
                image_12.setImageDrawable(draw3.get(11));
                text13.setText(cursor.get(symbolList3.get(12)).getName());
                image_13.setImageDrawable(draw3.get(12));
                text14.setText(cursor.get(symbolList3.get(13)).getName());
                image_14.setImageDrawable(draw3.get(13));
                text15.setText(cursor.get(symbolList3.get(14)).getName());
                image_15.setImageDrawable(draw3.get(14));
                text16.setText(cursor.get(symbolList3.get(15)).getName());
                image_16.setImageDrawable(draw3.get(15));


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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_1)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text1.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_2)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text2.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_3)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text3.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_4)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text4.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_5)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text5.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_6)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text6.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_7)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text7.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_8)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text8.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_9)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text9.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_10)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text10.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_11)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text11.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_12)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text12.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_13)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text13.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_14)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text14.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_15)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text15.getText());
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
                    count ++;
                }else if(count > 3){
                    BitmapDrawable d1 = (BitmapDrawable)((ImageView) findViewById(R.id.image_b)).getDrawable();
                    BitmapDrawable d2 = (BitmapDrawable)((ImageView) findViewById(R.id.image_c)).getDrawable();
                    BitmapDrawable d3 = (BitmapDrawable)((ImageView) findViewById(R.id.image_d)).getDrawable();
                    BitmapDrawable d4 = (BitmapDrawable)((ImageView) findViewById(R.id.image_16)).getDrawable();
                    Bitmap b1 = d1.getBitmap();
                    Bitmap b2 = d2.getBitmap();
                    Bitmap b3 = d3.getBitmap();
                    Bitmap b4 = d4.getBitmap();
                    image_a.setImageBitmap(b1);
                    image_b.setImageBitmap(b2);
                    image_c.setImageBitmap(b3);
                    image_d.setImageBitmap(b4);
                    texta.setText(textb.getText());
                    textb.setText(textc.getText());
                    textc.setText(textd.getText());
                    textd.setText(text16.getText());
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
