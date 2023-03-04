package com.exapp.mikiriquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "CustomQuestions.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table custom(questionNo INTEGER primary key AUTOINCREMENT , question TEXT, option1 TEXT, option2 TEXT, option3 TEXT, option4 TEXT, correctOption INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists custom");
    }

    public Boolean insertDatA(String ques, String op1, String op2, String op3, String op4, int correctopt){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("question", ques);
        contentValues.put("option1", op1);
        contentValues.put("option2", op2);
        contentValues.put("option3", op3);
        contentValues.put("option4", op4);
        contentValues.put("correctOption", correctopt);
        long result = DB.insert("custom",null,contentValues);
        if (result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData(int n){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from custom",null);
        return cursor;
    }


}
