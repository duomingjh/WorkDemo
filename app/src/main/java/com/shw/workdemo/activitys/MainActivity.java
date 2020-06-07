package com.shw.workdemo.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
