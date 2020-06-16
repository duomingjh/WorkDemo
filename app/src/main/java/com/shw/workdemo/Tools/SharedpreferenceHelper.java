package com.shw.workdemo.Tools;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedpreferenceHelper {

    public static void setSpHelper(Context context,String key,Object object){
        SharedPreferences.Editor editor=context.getSharedPreferences("data",Context.MODE_PRIVATE).edit();
        if(object instanceof String){
            editor.putString(key,((String)object));
        }if(object instanceof Float){
            editor.putFloat(key,((Float)object).floatValue());
        }
        if(object instanceof Boolean){
            editor.putBoolean(key,((boolean) object));
        }
        editor.apply();
    }
    //type=1 string类型
    //type=2 int类型
    //type=3 bool类型
    public static Object getSpHelper(Context context,String key,Integer type){
        SharedPreferences preferences=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        Object o=null;
        if(type==1){
            o=preferences.getString(key,"");
        }if(type==2){
            o=preferences.getInt(key,0);
        }if(type==3){
            o=preferences.getBoolean(key,false);
        }
        return o;
    }
}
