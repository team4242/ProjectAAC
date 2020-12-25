package com.example.projectaac;


import android.content.Intent;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MakeSymbolActivity extends Activity {

    DBManager dbManager;
    private GridView symbolGrid;
    GridSymbolAdapter adapter;


    private static final int REQUEST_CODE = 0;

    private ImageView SelectedImage;
    private Button btn_gallery, btn_search, btn_AddSymbol, btn_delete;
    private EditText et_symbolName;

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
        btn_delete = (Button) findViewById(R.id.btn_delete);

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
                if(symbolName.isEmpty()) {
                    Toast.makeText(MakeSymbolActivity.this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show();
                }else{
                    //불러온 이미지를 내부저장소에 저장
                    SelectedImage.setDrawingCacheEnabled(true);
                    Bitmap bitmap = SelectedImage.getDrawingCache();
                    String imagePath = saveBitmapToPng(bitmap, symbolName);
                    Toast.makeText(getApplicationContext(), imagePath, Toast.LENGTH_SHORT).show();
                    //데이터베이스에 상징 데이터 저장

                    //이건 됩니다
                    dbquery.insertSymbol(symbolName, imagePath);
                    Intent intent = getIntent();

                    finish();
                    startActivity((intent));
                }
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
        adapter = new GridSymbolAdapter();

        final DBQuery dbquery = new DBQuery(dbManager);
        ArrayList<SymbolListItem> allSymbol = dbquery.getAllSymbol();
        ArrayList<Integer> noUsedList = dbquery.getNoUsedSymbol();
        if(noUsedList.size() > 1) {
            for (int i = 1; i < noUsedList.size(); i++) {
                adapter.addItem(allSymbol.get(noUsedList.get(i)));
            }
        }
        dbquery.dbClose();
        symbolGrid.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        symbolGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == adapter.getCheckedItem()){
                    adapter.setCheckedItem(100);
                    adapter.setAdapterChecked(false);
                }else {
                    adapter.setCheckedItem(position);
                    adapter.setAdapterChecked(true);
                }

                adapter.notifyDataSetChanged();
                symbolGrid.setAdapter(adapter);
            }
        });


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.isAdapterChecked()){
                    String delete_str = adapter.items.get(adapter.getCheckedItem()).name;
                    dbquery.deleteSymbol(delete_str);
                    adapter.items.remove(adapter.getCheckedItem());
                    adapter.setCheckedItem(100);
                    adapter.setAdapterChecked(false);
                    Toast.makeText(MakeSymbolActivity.this, "'"+ delete_str+"' 상징을 삭제했습니다.", Toast.LENGTH_SHORT).show();
                }
                adapter.notifyDataSetChanged();
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