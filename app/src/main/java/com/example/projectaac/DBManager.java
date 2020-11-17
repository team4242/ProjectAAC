package com.example.projectaac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {
    public DBManager(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//      CP = 의사소통판, Symbol = 상징, Predict = 예측, Favorite = 즐겨찾기
        String sql_CP =         "create table CommunicationPlate (CP_id integer primary key autoincrement, symbol_id integer, foreign key(symbol_id) references Symbol(symbol_id))";
        String sql_symbol =     "create table Symbol (symbol_id integer primary key autoincrement, iamgePath text, symbol_name text, count integer)";
        String sql_predict =    "create table Predict (symbolCombi_id text primary key autoincrement, count integer)";
        String sql_favorite =   "create table Favorite (favorite_id integer primary key autoincrement, symbolcombi_id text)";
        db.execSQL(sql_CP);
        db.execSQL((sql_symbol));
        db.execSQL(sql_predict);
        db.execSQL(sql_favorite);
        Toast.makeText(null, "DB is opened", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
