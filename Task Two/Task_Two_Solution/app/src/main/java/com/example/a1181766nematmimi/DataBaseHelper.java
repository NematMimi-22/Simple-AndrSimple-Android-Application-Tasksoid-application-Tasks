package com.example.a1181766nematmimi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Closeable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE BOAT(ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT, COLOR TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE SAILOR (ID INTEGER PRIMARY KEY AUTOINCREMENT ,IDB LONG,NAME TEXT,NATIONALITY TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void defaultInsertBoat(String name,String color ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("COLOR", color);
        sqLiteDatabase.insert("BOAT", null, contentValues);
    }
    public void defaultInsertSailor(long id, String name,String Nationality ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("IDB", id);
        contentValues.put("NAME", name);
        contentValues.put("NATIONALITY",Nationality);

        sqLiteDatabase.insert("SAILOR", null, contentValues);
    }
    public void insertBoat(boat boat) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", boat.getmName());
        contentValues.put("COLOR", boat.getmColor());

        sqLiteDatabase.insert("BOAT", null, contentValues);
    }
    public void insertSailor(sailor sailor) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("IDB", sailor.getmBoatId());
        contentValues.put("NAME", sailor.getmName());
        contentValues.put("NATIONALITY",sailor.getmNationality());

        sqLiteDatabase.insert("SAILOR", null, contentValues);
    }

    public Cursor getAllBoats() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM BOAT", null);
    }
    public Cursor nameOfRedBoats() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT NAME FROM BOAT WHERE COLOR='Red'", null);
    }
    public Cursor getAllSailor() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM SAILOR", null);
    }


    public int numOfPalestinianSailor() {
        String countQuery = "SELECT  * FROM  SAILOR WHERE NATIONALITY ='Palestinian'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int numOfJordanianSailor() {
        String countQuery = "SELECT  * FROM  SAILOR WHERE NATIONALITY ='Jordanian'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public int numOfQatariSailor() {
        String countQuery = "SELECT  * FROM  SAILOR WHERE NATIONALITY ='Qatari'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public Cursor palestiniansSailorWithRedBoat() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT SAILOR.NAME FROM SAILOR,BOAT WHERE BOAT.ID=SAILOR.IDB AND COLOR='Red'AND NATIONALITY='Palestinian' ", null);
    }

}

