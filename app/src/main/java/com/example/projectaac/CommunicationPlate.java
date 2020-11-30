package com.example.projectaac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommunicationPlate extends AppCompatActivity {

    int count = 0;
    Button btn_recommand;
    ImageButton btn_tts;
    ImageButton btn_home;
    LinearLayout layout_a,layout_b,layout_c,layout_d,layout_1,layout_2,layout_3,layout_4,layout_5,layout_6,layout_7,layout_8,layout_9,layout_10,layout_11,layout_12,layout_13,layout_14,layout_15,layout_16;
    ImageView image_a,image_b,image_c,image_d,image_1,image_2,image_3,image_4,image_5,image_6,image_7,image_8,image_9,image_10,image_11,image_12,image_13,image_14,image_15,image_16;
    TextView texta,textb,textc,textd,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_plate);


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
