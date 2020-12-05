package com.example.projectaac;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String BaseSymbolName[] = {"안녕하세요", "친구", "가요", "기분좋아요", "과자", "귤", "학교", "좋아요", "맞아요", "주세요", "먹어요", "모르겠어요", "물", "물컵", "선생님" ,"된장국", "수저", "아니에요", "우유", "의사선생님"};
    private static final int BaseImagePath[] = {R.drawable.an_nyeong_ha_se_yo_002_,R.drawable.cin_gu_, R.drawable.geod_da_, R.drawable.gi_bun_joh_a_yo_, R.drawable.gwa_ja_, R.drawable.gyul_,R.drawable.hag_gyo_001_, R.drawable.joh_a_yo_001_,R.drawable.joh_a_yo_002_,R.drawable.ju_se_yo_002_,R.drawable.meog_eo_yo_
            ,R.drawable.mu_seun_mal_in_ji_jal_mo_reu_gess_eo_yo_,R.drawable.mul_002_1,R.drawable.mul_keob_002_,R.drawable.seon_saeng_nim_001_,R.drawable.si_geum_ci_doen_jang_gug_002_,R.drawable.sig_sa_ha_gi_,R.drawable.silh_eo_yo_,R.drawable.u_yu_003_,R.drawable.yi_sa_seon_saeng_nim_002_};

    DBManager dbManager;
    SQLiteDatabase database;
    SQLiteDatabase writeDatabase;

    Button btn_CP;
    Button btn_CPchangeMenu;
    ImageButton btn_option;
    String imagePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_CP = (Button)findViewById(R.id.btn_CP);
        btn_CP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CommunicationPlate.class);
                startActivity(intent);
            }
        });

        btn_CPchangeMenu = (Button)findViewById(R.id.btn_CPchangeMenu);
        btn_CPchangeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CPMenuActivity.class);
                startActivity(intent);
            }
        });

        btn_option = (ImageButton)findViewById(R.id.btn_option);
        btn_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), option.class);
                startActivity(intent);
            }
        });


        dbManager = new DBManager(this);
        database = dbManager.getReadableDatabase();
        writeDatabase = dbManager.getWritableDatabase();


        //DB의 symbolTB가 비어있으면 drawable을 bitmap으로 바꿔서 저장
        Cursor cursor = database.rawQuery("SELECT * FROM symbolTB", null);
        int dbCount = cursor.getCount();
        if(dbCount == 0){
            for(int i=0; i<20; i++) {
                Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), BaseImagePath[i]);
                saveBitmapToPng(bitmap, BaseSymbolName[i]);
                writeDatabase.execSQL("insert into symbolTB(name, image) values ('" + BaseSymbolName[i] + "','" +  imagePath + "')");
            }
        }
    }
    public void saveBitmapToPng(Bitmap bitmap, String name) {

        File storage = getCacheDir();
        String fileName = name + ".png";
        File tempFile = new File(storage, fileName);
        imagePath = storage +"/"+ fileName;

        try {
            tempFile.createNewFile();
            FileOutputStream out = new FileOutputStream(tempFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
