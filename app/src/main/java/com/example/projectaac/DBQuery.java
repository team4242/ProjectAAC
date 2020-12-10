package com.example.projectaac;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;


public class DBQuery {
    //DB Query 날리는 클래스
    DBManager dbManager;
    SQLiteDatabase database;

    //생성자
    public DBQuery(DBManager dbManager){
        this.dbManager = dbManager;
    }

    //sqlite 닫기    DB 사용 후 꼭 닫아줍시다
    public void dbClose(){
        database.close();
        dbManager.close();
    }

    //검색
    //상징 이름 입력하면 상징 id 반환하는 메소드
    public int getSymbolIdFromName(String symbolName){
        database = dbManager.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from symbolTB where name = '"+symbolName +"'",null);
        int symbolId = cursor.getInt(0);
        cursor.close();         //커서 사용 후 꼭 닫아줍시다.
        return symbolId;
    }

    //상징 id 입력하면 상징 이름 반환하는 메소드
    public String getSymbolNameFromId(int symbolID){
        database = dbManager.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from symbolTB where id = '"+symbolID +"'",null);
        String symbolName = cursor.getString(1);
        cursor.close();         //커서 사용 후 꼭 닫아줍시다.
        return symbolName;
    }
    //상징 테이블 전체 cursor로 반환하는 메소드
    public Cursor getAllSymbol(){
        database = dbManager.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM symbolTB", null);
        return cursor;
    }
    public Cursor getNoUsedSymbol(){
        database = dbManager.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM symbolTB where used = 0", null);
        return cursor;
    }
    //cp의 이름을 입력받아 해당 cp의 상징id를 담은 arraylist 반환하는 메소드
    public ArrayList<Integer> getTableSymbol(String cpName){
        database = dbManager.getWritableDatabase();
        Cursor symbolId = database.rawQuery("select * from cpTB where name ='" +cpName + "'",null);
        symbolId.moveToFirst();
        ArrayList<Integer> symbolIdList = new ArrayList<Integer>();
        for(int i=2; i<18; i++){
            if(symbolId.getInt(i)==0){
                symbolIdList.add(0);
            }else {
                symbolIdList.add(symbolId.getInt(i)-1);
            }
        }
        symbolId.close();
        return symbolIdList;
    }


    //추가
    //새로운 cp 추가하는 메소드
    public void insertCP(String cpName){
        database = dbManager.getWritableDatabase();
        database.execSQL("insert into cpTb (name) values ('"+ cpName +"')");
    }
    //새로운 상징 추가하는 메소드
    public void insertSymbol(String symbolName, String imagePath){
        database = dbManager.getWritableDatabase();
        database.execSQL("insert into symbolTB(name, image, used) values('" + symbolName +"', '" +imagePath + "', 0)");
    }
    //즐겨찾기 추가하는 메소드
    //public void insertFavorite{}

    //카테고리 추가하는 메소드
    //public void insertCategory{}

    //삭제
    //cp 삭제하는 메소드
    public void deleteCP(String cpName){
        database = dbManager.getWritableDatabase();
        database.execSQL("delete from cpTB where name = '"+ cpName +"'");
    }
    //상징 삭제하는 메소드
    public void deleteSymbol(String symbolName){
        database = dbManager.getWritableDatabase();
        database.execSQL("delete from symbolTB where name = '"+ symbolName +"'");
    }

    //값 변경
    //cpTB의 상징값 변경하는 메소드     테이블이름, 상징id, 상징을 추가할 위치 지정
    public void setChangeCP(String tableName, int symbolId, int location){
        database = dbManager.getWritableDatabase();
        String symbolNum = "symbol"+ Integer.toString(location);
        database.execSQL("update cpTB set " + symbolNum + " = " + symbolId +" where name ='" + tableName +"'" );
        database.execSQL("update symbolTB set used = 1 where id ='" + symbolId + "'");
    }
    //symbolTB의 텍스트 변경하는 메소드
    public void setChangeSymbolText(int symbolId, String changeName){
        database = dbManager.getWritableDatabase();
        database.execSQL("update symbolTB set name =" + changeName + " where id = '" + symbolId +"'");
    }
    //symbol의 used 값 변경하는 메소드
    public void setUsedFalse(int symbolId){
        database = dbManager.getWritableDatabase();
        database.execSQL("update symbolTB set used = 0 where id = " + symbolId);
    }
    public void setUsedTrue(int symbolId){
        database = dbManager.getWritableDatabase();
        database.execSQL("update symbolTB set used = 1 where id = " + symbolId);
    }

    //확인
    //상징 테이블이 비었는지 확인
    public boolean isSymbolNull(){
        database = dbManager.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM symbolTB", null);
        int dbCount = cursor.getCount();
        cursor.close();         //커서 사용 후 꼭 닫아줍시다.
        if(dbCount == 0) {
            return true;
        }else{
            return false;
        }
    }
    //이미 존재하는 상징인지 확인
    public boolean isSymbolExist(String symbolName){
        database = dbManager.getWritableDatabase();
        Cursor cursor = database.rawQuery("select name from symbolTB where name = '" + symbolName +"'",null);
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
}
