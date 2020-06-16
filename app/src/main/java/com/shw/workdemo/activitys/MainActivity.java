package com.shw.workdemo.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.shw.workdemo.R;
import com.shw.workdemo.Tools.dbHelper;

public class MainActivity extends AppCompatActivity {
    private TextView textView; //
    private static final int UPDATE_TV=1;
    private int Time=3;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" };
    public static void verifyStoragePermissions(Activity activity) {
        try { //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e)
        { e.printStackTrace();
        }
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE_TV:
                    textView.setText(String.valueOf(Time));
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv_main);
        dbHelper db=new dbHelper(this,"User.db",null,1);
        db.getReadableDatabase();
        verifyStoragePermissions(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(Time>0){
                    try {
                        Message message=new Message();
                        message.what=UPDATE_TV;
                        handler.sendMessage(message);
                        Thread.sleep(1000);
                        Time--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent=new Intent(MainActivity.this,registerActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();
    }
}
