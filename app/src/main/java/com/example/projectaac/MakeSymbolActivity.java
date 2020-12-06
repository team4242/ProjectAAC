package com.example.projectaac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MakeSymbolActivity extends Activity {

    DBManager dbManager;
    private GridView symbolGrid;


    private static final int REQUEST_CODE = 0;

    private ImageView SelectedImage;
    private Button btn_gallery, btn_search, btn_AddSymbol;
    private EditText et_symbolName, et_categoryName;

    String symbolName, categoryName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_symbol);



        //DB 사용할 수 있게 선언
        dbManager = new DBManager(this);

        //액티비티에서 버튼, 이미지뷰 등 불러오기
        SelectedImage = (ImageView) findViewById(R.id.SelectedImage);
        btn_gallery = (Button) findViewById(R.id.btn_gallery);
        btn_search = (Button) findViewById(R.id.btn_search);
        btn_AddSymbol = (Button) findViewById(R.id.btn_AddSymbol);
        et_symbolName = (EditText) findViewById(R.id.et_symbolName);
        et_categoryName = (EditText) findViewById(R.id.et_categoryName);

        //갤러리에서 사진 불러오는 클릭 리스너
        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        //DB에 상징 저장하는 부분

        btn_AddSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBQuery dbquery = new DBQuery(dbManager);
                symbolName = et_symbolName.getText().toString().trim();
                categoryName = et_categoryName.getText().toString().trim();
                //불러온 이미지를 내부저장소에 저장
                SelectedImage.setDrawingCacheEnabled(true);
                Bitmap bitmap = SelectedImage.getDrawingCache();
                String imagePath = saveBitmapToPng(bitmap, symbolName);
                Toast.makeText(getApplicationContext(), imagePath, Toast.LENGTH_SHORT).show();
                //데이터베이스에 상징 데이터 저장

                //이건 안되고
                //database.execSQL("insert into symbolTB(name, image) values(" + symbolName +", " +imagePath + ")");

                //이건 됩니다
                dbquery.insertSymbol(symbolName, imagePath);
                Intent intent = getIntent();
                finish();
                startActivity((intent));


            }
        });
        //KAAC에서 상징 검색하는 기능
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://220.69.171.35:8080/searchsymbols/index.jsp");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        //모든 상징 검색해서 symbolGrid 에 뿌려주는 기능
        symbolGrid = findViewById(R.id.symbolGirdView);
        GridSymbolAdapter adapter = new GridSymbolAdapter();

        DBQuery dbquery = new DBQuery(dbManager);
        Cursor cursor = dbquery.getAllSymbol();
        if(!dbquery.isSymbolNull()) {   //symbolTB 가 비어있지 않으면
            cursor.moveToFirst();
            int symbolNum = cursor.getCount();
            for (int i = 0; i < symbolNum ; i++) {
                adapter.addItem(new SymbolListItem(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));

                if (i == symbolNum - 1) {
                    continue;
                } else {
                    cursor.moveToNext();
                }
            }
        }
        dbquery.dbClose();
        symbolGrid.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    //갤러리에서 사진 불러오는 파일스트림
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    SelectedImage.setImageBitmap(img);
                } catch (Exception e) {
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }
    //이미지를 내부저장소에 저장하는 파일스트림 메소드 이미지 경로를 반환.
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