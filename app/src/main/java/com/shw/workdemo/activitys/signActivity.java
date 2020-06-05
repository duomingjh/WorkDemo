package com.shw.workdemo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.shw.workdemo.R;
import com.shw.workdemo.Tools.SharedpreferenceHelper;

public class signActivity extends AppCompatActivity {
    private EditText user;
    private EditText pas;
    private Button rebt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        init();
        rebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=user.getText().toString();
                String userPass=pas.getText().toString();
                if(username!=null&&username.length()>=5&&userPass!=null&&userPass.length()>=4){
                    SharedpreferenceHelper.setSpHelper(signActivity.this,username+"name",username);
                    SharedpreferenceHelper.setSpHelper(signActivity.this,username+"pwd",userPass);
                    /*Intent intent=new Intent(signActivity.this,registerActivity.class);
                    startActivity(intent);*/
                    finish();
                }else{
                    Toast.makeText(signActivity.this,"格式错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void init(){
        user=findViewById(R.id.sg_user);
        pas=findViewById(R.id.sg_pas);
        rebt=findViewById(R.id.sg_bt);
    }
}
