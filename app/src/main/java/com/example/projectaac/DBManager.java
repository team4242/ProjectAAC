package com.example.projectaac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static java.sql.DriverManager.println;


public class DBManager extends SQLiteOpenHelper {
    //데이터베이스
    private static final String DATABASE_NAME = "table.db";
    private static final int DATABASE_VERSION = 2;


    //테이블
    public static final String TABLE_NAME_CP = "cpTB";
    public static final String TABLE_NAME_SYMBOL = "symbolTB";
    public static final String TABLE_NAME_PREDICT = "predictTB";
    public static final String TABLE_NAME_FAVORITE = "favoriteTB";
    public static final String TABLE_NAME_CATEGORY = "categoryTB";
    //테이블 공통
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    //테이블 개별
    public static final String SYMBOL_ID = "symbolID";
    public static final String COLUMN_IMAGE_PATH = "image";
    public static final String COLUMN_COUNT = "count";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_COMBI_ID = "combiID";

    //CP 테이블
    public static final String DATABASE_CREATE_CP = "create table "
            + TABLE_NAME_CP + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + SYMBOL_ID + " integer)";
    //SYMBOL 테이블
    public static final String DATABASE_CREATE_SYMBOL = "create table "
            + TABLE_NAME_SYMBOL + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_NAME + " text,"
            + COLUMN_IMAGE_PATH + " text,"
            + COLUMN_COUNT + " integer,"
            + COLUMN_LOCATION + " integer)";
    //PREDICT 테이블
    public static final String DATABASE_CREATE_PREDICT = "create table "
            + TABLE_NAME_PREDICT + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_COUNT + " integer)";
    //FAVORITE 테이블
    public static final String DATABASE_CREATE_FAVORITE = "create table "
            + TABLE_NAME_FAVORITE + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_COMBI_ID + " text)";


    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        println("onCreate() called");
//      CP = 의사소통판, Symbol = 상징, Predict = 예측, Favorite = 즐겨찾기
        db.execSQL(DATABASE_CREATE_CP);
        db.execSQL((DATABASE_CREATE_SYMBOL));
        db.execSQL(DATABASE_CREATE_PREDICT);
        db.execSQL(DATABASE_CREATE_FAVORITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
