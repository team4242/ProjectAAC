package com.example.projectaac;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DBManager dbManager;
    SQLiteDatabase database;

    Button btn_CP;
    Button btn_CPchange;
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

        btn_CPchange = (Button)findViewById(R.id.btn_CPchange);
        btn_CPchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CpChangeActivity.class);
                startActivity(intent);
            }
        });
    }
}
