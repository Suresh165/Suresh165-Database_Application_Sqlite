package com.example.database_application_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "USER_DATA.db";
    public static final String TABLE_NAME = "USER_TABLE";
    public static final String ID = "ID";

    public static final String COL_1 = "Name";
    public static final String COL_2 = "Email";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
    }

    // Insert Data in Database SQlite

    public boolean Insert_Data(String Name,String Email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues Insert_Value = new ContentValues();
        Insert_Value.put(COL_1,Name);
        Insert_Value.put(COL_2,Email);

        long result = sqLiteDatabase.insert(TABLE_NAME,null,Insert_Value);

        if (result==-1){
            return false;
        }else {
            return true;
        }
    }

    //Get The Data and show
    public Cursor Read_Data(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.rawQuery("Select * from " +TABLE_NAME,null);
    }

    //update Data
    public boolean Update_Data(String ID, String Name,String Email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues Update_value = new ContentValues();

        Update_value.put(COL_1,Name);
        Update_value.put(COL_2,Email);

        int result = sqLiteDatabase.update(TABLE_NAME,Update_value,"ID=?",new String[]{ID});
        return result>0;
    }

    public Integer Delete_Data(String ID){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,"ID=?",new String[]{ID});
    }
}
