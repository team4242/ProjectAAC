package com.example.projectaac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static java.sql.DriverManager.println;


public class DBManager extends SQLiteOpenHelper {
    //데이터베이스
    private static final String DATABASE_NAME = "table.db";
    private static final int DATABASE_VERSION = 6;



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
    public static final String COLUMN_IMAGE_PATH = "image";
    public static final String COLUMN_COUNT = "count";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_COMBI_ID = "combiID";

    //CP 테이블
    //id, symbol1~ symbol16
    public static final String DATABASE_CREATE_CP = "create table "
            + TABLE_NAME_CP + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_NAME + " text,"
            + "symbol1 integer,"
            + "symbol2 integer,"
            + "symbol3 integer,"
            + "symbol4 integer,"
            + "symbol5 integer,"
            + "symbol6 integer,"
            + "symbol7 integer,"
            + "symbol8 integer,"
            + "symbol9 integer,"
            + "symbol10 integer,"
            + "symbol11 integer,"
            + "symbol12 integer,"
            + "symbol13 integer,"
            + "symbol14 integer,"
            + "symbol15 integer,"
            + "symbol16 integer)";
    //SYMBOL 테이블
    //id, name, image, count
    public static final String DATABASE_CREATE_SYMBOL = "create table "
            + TABLE_NAME_SYMBOL + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_NAME + " text,"
            + COLUMN_IMAGE_PATH + " text,"
            + COLUMN_COUNT + " integer,"
            + COLUMN_LOCATION +" integer)";
    //PREDICT 테이블
    //id, count
    public static final String DATABASE_CREATE_PREDICT = "create table "
            + TABLE_NAME_PREDICT + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_COUNT + " integer)";
    //FAVORITE 테이블
    //id, combiID
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SYMBOL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PREDICT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FAVORITE);
        onCreate(db);
    }
}
