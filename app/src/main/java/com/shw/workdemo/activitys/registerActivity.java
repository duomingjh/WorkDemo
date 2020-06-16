package com.shw.workdemo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.shw.workdemo.Bean.user;
import com.shw.workdemo.R;
import com.shw.workdemo.Tools.GetcontextHpler;
import com.shw.workdemo.Tools.SharedpreferenceHelper;
import com.shw.workdemo.Tools.dbHelper;

public class registerActivity extends AppCompatActivity {
    private EditText user;
    private EditText pas;
    private CheckBox pasMber;
    private Button rebt;
    private Button reTosg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        ReadPwd();
        rebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=user.getText().toString();
                String userPass=pas.getText().toString();
                Boolean remeberpwd=pasMber.isChecked();
                String pass= (String) SharedpreferenceHelper.getSpHelper(registerActivity.this,username+"pwd",1);
                if(username!=null&&username.length()>3&&userPass!=null&&userPass.equals(pass)){
                    SharedpreferenceHelper.setSpHelper(registerActivity.this,"isrb",remeberpwd);
                    SharedpreferenceHelper.setSpHelper(registerActivity.this,"recentuser",username);
                    Toast.makeText(registerActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(registerActivity.this,DrawerActivity.class);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(GetcontextHpler.getContext(),"密码或账户错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
        reTosg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registerActivity.this,signActivity.class);
                startActivity(intent);

            }
        });
    }
    private void init(){
        user=findViewById(R.id.rg_user);
        pas=findViewById(R.id.rg_pas);
        pasMber=findViewById(R.id.rg_pasmeber);
        rebt=findViewById(R.id.rg_bt);
        reTosg=findViewById(R.id.rg_sg);
    }
    private void ReadPwd(){
        Boolean flag=(Boolean)SharedpreferenceHelper.getSpHelper(registerActivity.this,"isrb",3);
        String name=(String) SharedpreferenceHelper.getSpHelper(registerActivity.this,"recentuser",1);
        String username=(String)SharedpreferenceHelper.getSpHelper(registerActivity.this,name+"name",1);
        if(flag){
            pasMber.setChecked(true);
            String userpwd=(String)SharedpreferenceHelper.getSpHelper(registerActivity.this,name+"pwd",1);

            pas.setText(userpwd);
        }
        user.setText(username);

    }

}
