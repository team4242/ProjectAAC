package com.example.projectaac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CpChangeActivity extends AppCompatActivity {

    Button btn_symbolmake, btn_camera, btn_community, btn_save;
    ImageButton btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_change);

        btn_symbolmake = (Button)findViewById(R.id.btn_favorites);
        btn_camera= (Button)findViewById(R.id.btn_addfavorites);
        btn_community= (Button)findViewById(R.id.btn_community);
        btn_save= (Button)findViewById(R.id.btn_save);

        btn_symbolmake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MakeSymbolActivity.class);
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
    }
}
