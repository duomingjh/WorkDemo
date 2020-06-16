package com.shw.workdemo.Tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.shw.workdemo.Bean.user;
import com.shw.workdemo.activitys.signActivity;

public class dbTool {

    public static void userinsert(Context context,String dbname,int version ,user user1){
        dbHelper db=new dbHelper(context,"User.db",null,1);
        SQLiteDatabase data=db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("id",user1.getId());
        values.put("passward",user1.getPassward());
        data.insert("user",null,values);
    }
    public static user selectuser(Context context,String dbname,int version ,String value){
        dbHelper db=new dbHelper(context,"User.db",null,1);
        SQLiteDatabase data=db.getWritableDatabase();
        Cursor cursor= data.query("user",null,"id=?",new String[]{value},null,null,null);
        cursor.moveToFirst();
        user u=new user();
        u.setId(cursor.getString(cursor.getColumnIndex("id")));
        u.setName(cursor.getString(cursor.getColumnIndex("name")));
        u.setPassward(cursor.getString(cursor.getColumnIndex("passward")));
        u.setSiginature(cursor.getString(cursor.getColumnIndex("siginature")));
        cursor.close();
        return u;
    }
    public static void updateuser(Context context,String dbname,int version ,user u){
        dbHelper db=new dbHelper(context,"User.db",null,1);
        SQLiteDatabase data=db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",u.getName());
        values.put("siginature",u.getSiginature());
        data.update("user",values,"id=?",new String[]{u.getId()});

    }
}
