package com.exapp.mikiriquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    //one table for each quiztitle is a bad design, instead create one table for quiztitles and other table for questions of said quiztitles

    public DBHelper(Context context) {
        super(context, "CustomQuestions.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table titles(sno INTEGER primary key AUTOINCREMENT, title TEXT, numberofqns INTEGER)");
        DB.execSQL("create Table questions(questionNo INTEGER primary key AUTOINCREMENT , question TEXT,title TEXT, option1 TEXT, option2 TEXT, option3 TEXT, option4 TEXT, correctOption INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists questions");
        DB.execSQL("drop Table if exists titles");
    }

    public Boolean insertDatA(String title,String ques, String op1, String op2, String op3, String op4, int correctopt){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("question", ques);
        contentValues.put("title", title);
        contentValues.put("option1", op1);
        contentValues.put("option2", op2);
        contentValues.put("option3", op3);
        contentValues.put("option4", op4);
        contentValues.put("correctOption", correctopt);
        long result = DB.insert("questions",null,contentValues);
        if (result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean insertTitle(String title, Integer numofqns){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("numberofqns", numofqns);
        long result = DB.insert("titles",null,contentValues);
        if (result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getQuizData(String selectedTitle){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from questions where title like '%"+selectedTitle+"%'",null);
        return cursor;
    }

    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        //use default locale  / some other form of formatted string?
        //Cursor cursor = DB.rawQuery(String.format("Select question from custom where questionNo=%d",n),null);
        Cursor cursor = DB.rawQuery("Select * from titles",null);
        return cursor;
    }


}
