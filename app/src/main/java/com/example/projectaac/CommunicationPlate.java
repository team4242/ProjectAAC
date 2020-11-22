package com.example.projectaac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommunicationPlate extends AppCompatActivity {

    int count = 0;
    Button btn_recommand;
    ImageButton btn_tts;
    ImageButton btn_home;
    LinearLayout layout_a,layout_b,layout_c,layout_d,layout_1,layout_2,layout_3,layout_4,layout_5,layout_6,layout_7,layout_8,layout_9,layout_10,layout_11,layout_12,layout_13,layout_14,layout_15,layout_16;
    ImageView image_a,image_b,image_c,image_d,image_1,image_2,image_3,image_4,image_5,image_6,image_7,image_8,image_9,image_10,image_11,image_12,image_13,image_14,image_15,image_16;
    TextView text,texta,textb,textc,textd,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16;

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
            }
        });


        layout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.an_nyeong_ha_se_yo_002_);
                    texta.setText(text1.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.an_nyeong_ha_se_yo_002_);
                    textb.setText(text1.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.an_nyeong_ha_se_yo_002_);
                    textc.setText(text1.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.an_nyeong_ha_se_yo_002_);
                    textd.setText(text1.getText());
                    count ++;}
            }
        });

        layout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.cin_gu_);
                    texta.setText(text2.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.cin_gu_);
                    textb.setText(text2.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.cin_gu_);
                    textc.setText(text2.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.cin_gu_);
                    textd.setText(text2.getText());
                    count ++;}
            }
        });

        layout_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.joh_a_yo_002_);
                    texta.setText(text3.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.joh_a_yo_002_);
                    textb.setText(text3.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.joh_a_yo_002_);
                    textc.setText(text3.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.joh_a_yo_002_);
                    textd.setText(text3.getText());
                    count ++;}
            }
        });

        layout_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.silh_eo_yo_);
                    texta.setText(text4.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.silh_eo_yo_);
                    textb.setText(text4.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.silh_eo_yo_);
                    textc.setText(text4.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.silh_eo_yo_);
                    textd.setText(text4.getText());
                    count ++;}
            }
        });

        layout_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.gi_bun_joh_a_yo_);
                    texta.setText(text5.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.gi_bun_joh_a_yo_);
                    textb.setText(text5.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.gi_bun_joh_a_yo_);
                    textc.setText(text5.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.gi_bun_joh_a_yo_);
                    textd.setText(text5.getText());
                    count ++;}
            }
        });

        layout_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.ju_se_yo_002_);
                    texta.setText(text6.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.ju_se_yo_002_);
                    textb.setText(text6.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.ju_se_yo_002_);
                    textc.setText(text6.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.ju_se_yo_002_);
                    textd.setText(text6.getText());
                    count ++;}
            }
        });

        layout_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.mul_002_1);
                    texta.setText(text7.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.mul_002_1);
                    textb.setText(text7.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.mul_002_1);
                    textc.setText(text7.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.mul_002_1);
                    textd.setText(text7.getText());
                    count ++;}
            }
        });

        layout_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.u_yu_003_);
                    texta.setText(text8.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.u_yu_003_);
                    textb.setText(text8.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.u_yu_003_);
                    textc.setText(text8.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.u_yu_003_);
                    textd.setText(text8.getText());
                    count ++;}
            }
        });

        layout_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.mu_seun_mal_in_ji_jal_mo_reu_gess_eo_yo_);
                    texta.setText(text9.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.mu_seun_mal_in_ji_jal_mo_reu_gess_eo_yo_);
                    textb.setText(text9.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.mu_seun_mal_in_ji_jal_mo_reu_gess_eo_yo_);
                    textc.setText(text9.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.mu_seun_mal_in_ji_jal_mo_reu_gess_eo_yo_);
                    textd.setText(text9.getText());
                    count ++;}
            }
        });

        layout_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.geod_da_);
                    texta.setText(text10.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.geod_da_);
                    textb.setText(text10.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.geod_da_);
                    textc.setText(text10.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.geod_da_);
                    textd.setText(text10.getText());
                    count ++;}
            }
        });

        layout_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.gwa_ja_);
                    texta.setText(text11.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.gwa_ja_);
                    textb.setText(text11.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.gwa_ja_);
                    textc.setText(text11.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.gwa_ja_);
                    textd.setText(text11.getText());
                    count ++;}
            }
        });

        layout_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.gyul_);
                    texta.setText(text12.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.gyul_);
                    textb.setText(text12.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.gyul_);
                    textc.setText(text12.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.gyul_);
                    textd.setText(text12.getText());
                    count ++;}
            }
        });

        layout_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.hag_gyo_001_);
                    texta.setText(text13.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.hag_gyo_001_);
                    textb.setText(text13.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.hag_gyo_001_);
                    textc.setText(text13.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.hag_gyo_001_);
                    textd.setText(text13.getText());
                    count ++;}
            }
        });

        layout_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.meog_eo_yo_);
                    texta.setText(text14.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.meog_eo_yo_);
                    textb.setText(text14.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.meog_eo_yo_);
                    textc.setText(text14.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.meog_eo_yo_);
                    textd.setText(text14.getText());
                    count ++;}
            }
        });

        layout_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.sig_sa_ha_gi_);
                    texta.setText(text15.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.sig_sa_ha_gi_);
                    textb.setText(text15.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.sig_sa_ha_gi_);
                    textc.setText(text15.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.sig_sa_ha_gi_);
                    textd.setText(text15.getText());
                    count ++;}
            }
        });

        layout_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0){
                    image_a.setImageResource(R.drawable.yi_sa_seon_saeng_nim_002_);
                    texta.setText(text16.getText());
                    count ++;
                }else if(count == 1){
                    image_b.setImageResource(R.drawable.yi_sa_seon_saeng_nim_002_);
                    textb.setText(text16.getText());
                    count ++;
                }else if(count == 2){
                    image_c.setImageResource(R.drawable.yi_sa_seon_saeng_nim_002_);
                    textc.setText(text16.getText());
                    count ++;
                }else if(count == 3){
                    image_d.setImageResource(R.drawable.yi_sa_seon_saeng_nim_002_);
                    textd.setText(text16.getText());
                    count ++;}
            }
        });
    }
}
