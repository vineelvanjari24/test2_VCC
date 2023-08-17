package com.vv.test2_vcc.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AgentLoginDBHelper extends SQLiteOpenHelper{
    final static String TABLE_NAME = "AGENT_LOGIN";
    public AgentLoginDBHelper(@Nullable Context context) {
        super(context,TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME +"(id integer primary key autoincrement , userName text , password text ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public void insert(String name,String password){
        ContentValues cv = new ContentValues();
        cv.put("userName",name);
        cv.put("password",password);
        SQLiteDatabase sb= this.getWritableDatabase();
        sb.insert(TABLE_NAME,null,cv);
    }
    public boolean userNameCheck(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cus = db.rawQuery("select * from " + TABLE_NAME+" where userName = ?",new String[]{username});
        if(cus.getCount()>0) {
            cus.close();
            return true;
        }
        else
        {
            cus.close();
            return false;
        }
    }
    public boolean passwordCheck(String username,String password){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cus = db.rawQuery(" select * from  "+TABLE_NAME+" where  userName = ? and password = ? ",new String[]{username,password});
        if(cus.getCount()>0) {
            cus.close();
            return true;
        }
        else {
            cus.close();
            return false;
        }
    }

}
