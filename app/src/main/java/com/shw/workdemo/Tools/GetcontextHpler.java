package com.shw.workdemo.Tools;

import android.app.Application;
import android.content.Context;

public class GetcontextHpler extends Application {
    private static Context m_context;

    @Override
    public void onCreate() {
        super.onCreate();
        m_context = getApplicationContext();
    }

    public static Context getContext(){
        return  m_context;
    }
}
