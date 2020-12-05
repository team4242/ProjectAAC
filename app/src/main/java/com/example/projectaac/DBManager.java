package com.example.projectaac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static java.sql.DriverManager.println;


public class DBManager extends SQLiteOpenHelper {
    //데이터베이스
    private static final String DATABASE_NAME = "table.db";
    private static final int DATABASE_VERSION = 4;



    //기본 상징 데이터
    private static final String symbolName[] = {"안녕하세요", "친구", "가요", "기분좋아요", "과자", "귤", "학교", "좋아요", "맞아요", "주세요", "먹어요", "모르겠어요", "물", "물컵", "선생님" ,"된장국", "수저", "아니에요", "우유", "의사선생님"};
    private static final int imagePath[] = {R.drawable.an_nyeong_ha_se_yo_002_,R.drawable.cin_gu_, R.drawable.geod_da_, R.drawable.gi_bun_joh_a_yo_, R.drawable.gwa_ja_, R.drawable.gyul_,R.drawable.hag_gyo_001_, R.drawable.joh_a_yo_001_,R.drawable.joh_a_yo_002_,R.drawable.ju_se_yo_002_,R.drawable.meog_eo_yo_
            ,R.drawable.mu_seun_mal_in_ji_jal_mo_reu_gess_eo_yo_,R.drawable.mul_002_1,R.drawable.mul_keob_002_,R.drawable.seon_saeng_nim_001_,R.drawable.si_geum_ci_doen_jang_gug_002_,R.drawable.sig_sa_ha_gi_,R.drawable.silh_eo_yo_,R.drawable.u_yu_003_,R.drawable.yi_sa_seon_saeng_nim_002_};
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
    //id, name, image, count, location
    public static final String DATABASE_CREATE_SYMBOL = "create table "
            + TABLE_NAME_SYMBOL + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_NAME + " text,"
            + COLUMN_IMAGE_PATH + " text,"
            + COLUMN_COUNT + " integer,"
            + COLUMN_LOCATION + " integer)";
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
