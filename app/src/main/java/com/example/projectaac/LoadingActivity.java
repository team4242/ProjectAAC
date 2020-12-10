package com.example.projectaac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadingActivity extends AppCompatActivity {
    private static final String BaseSymbolName[] = {" ", "친구", "가요", "기분좋아요", "과자", "귤", "학교", "좋아요", "맞아요", "주세요", "먹어요", "모르겠어요", "물", "물컵", "선생님", "된장국", "수저", "아니에요", "우유", "의사선생님", "배가 아파요", "경찰에신고해주세요", "때렸어요", "맞았어요", "밀었어요",};
    private static final int BaseImagePath[] = {R.drawable.blank, R.drawable.cin_gu_, R.drawable.geod_da_, R.drawable.gi_bun_joh_a_yo_, R.drawable.gwa_ja_
            , R.drawable.gyul_, R.drawable.hag_gyo_001_, R.drawable.joh_a_yo_001_, R.drawable.joh_a_yo_002_, R.drawable.ju_se_yo_002_, R.drawable.meog_eo_yo_
            , R.drawable.mu_seun_mal_in_ji_jal_mo_reu_gess_eo_yo_, R.drawable.mul_002_1, R.drawable.mul_keob_002_, R.drawable.seon_saeng_nim_001_, R.drawable.si_geum_ci_doen_jang_gug_002_
            , R.drawable.sig_sa_ha_gi_, R.drawable.silh_eo_yo_, R.drawable.u_yu_003_, R.drawable.yi_sa_seon_saeng_nim_002_, R.drawable.bae_ga_a_pa_yo_201_
            , R.drawable.gyeong_cal_seo_e_sin_go_hae_ju_se_yo_, R.drawable.jeo_reul_ddae_ryeoss_eo_yo_, R.drawable.maj_ass_eo_yo_2, R.drawable.mil_eoss_eo_yo_};
    DBManager dbManager;
    DBQuery dbquery;

    public static ArrayList<String> cp_List;
    public static HashMap<String,String[]> cp_SymbolHash;
    public static HashMap<String,String> symbol_ImageHash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        dbManager = new DBManager(this);
        dbquery = new DBQuery(dbManager);

        //cp 리스트를 저장하는 정적 변수
        cp_List = new ArrayList<String>();
        //각 cp 마다 상징모음배열을 hash하는 정적 hashmap
        cp_SymbolHash = new HashMap<String,String[]>();
        //각 상징마다 이미지경로를 hash하는 정적 hashmap
        symbol_ImageHash = new HashMap<String,String>();



        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                //DB의 symbolTB가 비어있으면 drawable을 bitmap으로 바꿔서 저장
                if (dbquery.isSymbolNull()) {
                    dbquery.insertCP("일상");
                    dbquery.insertCP("음식");
                    dbquery.insertCP("도움");
                    for (int i = 0; i < 25; i++) {
                        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), BaseImagePath[i]);
                        String imagePath = saveBitmapToPng(bitmap, BaseSymbolName[i]);
                        dbquery.insertSymbol(BaseSymbolName[i], imagePath);
                    }
                    //초기 테이블 설정 노가다
                    dbquery.setChangeCP("일상", 2, 1);
                    dbquery.setChangeCP("일상", 3, 2);
                    dbquery.setChangeCP("일상", 4, 3);
                    dbquery.setChangeCP("음식", 5, 1);
                    dbquery.setChangeCP("음식", 6, 2);
                    dbquery.setChangeCP("일상", 7, 4);
                    dbquery.setChangeCP("일상", 8, 5);
                    dbquery.setChangeCP("일상", 9, 6);
                    dbquery.setChangeCP("음식", 10, 3);
                    dbquery.setChangeCP("음식", 11, 4);
                    dbquery.setChangeCP("일상", 12, 7);
                    dbquery.setChangeCP("음식", 13, 5);
                    dbquery.setChangeCP("음식", 14, 6);
                    dbquery.setChangeCP("일상", 15, 8);
                    dbquery.setChangeCP("음식", 16, 7);
                    dbquery.setChangeCP("음식", 17, 8);
                    dbquery.setChangeCP("일상", 18, 9);
                    dbquery.setChangeCP("음식", 19, 9);
                    dbquery.setChangeCP("일상", 20, 10);
                    dbquery.setChangeCP("도움", 21, 1);
                    dbquery.setChangeCP("도움", 22, 2);
                    dbquery.setChangeCP("도움", 23, 3);
                    dbquery.setChangeCP("도움", 24, 4);
                    dbquery.setChangeCP("도움", 25, 5);
                }

                dbquery.dbClose();
                finish();
            }
        },100);

    }

    @Override
    protected void onResume() {
        super.onResume();




    }
    private String saveBitmapToPng(Bitmap bitmap, String name) {

        File storage = getCacheDir();
        String fileName = name + ".png";
        File tempFile = new File(storage, fileName);
        String imagePath = storage +"/"+ fileName;
        try {
            tempFile.createNewFile();
            FileOutputStream out = new FileOutputStream(tempFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath;
    }


}
