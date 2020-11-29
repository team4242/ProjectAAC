package com.example.projectaac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MakeSymbolActivity extends Activity {

    DBManager dbManager;
    SQLiteDatabase database;

    private static final int REQUEST_CODE = 0;
    private ImageView SelectedImage;
    private Button btn_gallery, btn_search, btn_AddSymbol;
    private EditText et_symbolName, et_categoryName;

    String symbolName, categoryName, imagePath;

    ImageButton btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_symbol);

        btn_home = (ImageButton)findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CpChangeActivity.class);
                startActivity(intent);
            }
        });



        //DB 사용할 수 있게 선언
        dbManager = new DBManager(this);
        database = dbManager.getWritableDatabase();

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
                symbolName = et_symbolName.getText().toString().trim();
                categoryName = et_categoryName.getText().toString().trim();
                //불러온 이미지를 내부저장소에 저장
                SelectedImage.setDrawingCacheEnabled(true);
                Bitmap bitmap = SelectedImage.getDrawingCache();
                saveBitmapToPng(bitmap, symbolName);
                Toast.makeText(getApplicationContext(), imagePath, Toast.LENGTH_SHORT).show();
                //데이터베이스에 상징 데이터 저장

                //이건 안되고
                //database.execSQL("insert into symbolTB(name, image) values(" + symbolName +", " +imagePath + ")");

                //이건 됩니다
                database.execSQL("insert into symbolTB(name, image) values('" + symbolName +"', '" +imagePath + "')");


            }
        });
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
    //이미지를 내부저장소에 저장하는 파일스트림
    private void saveBitmapToPng(Bitmap bitmap, String name) {

        File storage = getCacheDir();
        String fileName = name + ".png";
        File tempFile = new File(storage, fileName);
        imagePath = fileName;

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