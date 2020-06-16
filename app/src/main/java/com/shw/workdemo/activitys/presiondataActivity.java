package com.shw.workdemo.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.shw.workdemo.Bean.user;
import com.shw.workdemo.R;
import com.shw.workdemo.Tools.dbTool;

public class presiondataActivity extends AppCompatActivity {
    private TextView textViewname;
    private TextView setname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presiondata);
        textViewname=findViewById(R.id.textview_mine_nickNmae);
        setname=findViewById(R.id.p_op1);
        final String str=getIntent().getStringExtra("id");
        final user u=dbTool.selectuser(this,"",1,str);
        setname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final EditText et=new EditText(v.getContext());
                new AlertDialog.Builder(v.getContext()).setTitle("请输入昵称").setIcon(android.R.drawable.sym_def_app_icon)
                        .setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                textViewname.setText(et.getText().toString()+"\n"+u.getSiginature());
                                user u=new user(str,et.getText().toString(),"","");
                                dbTool.updateuser(presiondataActivity.this,"user",1,u);
                            }
                        }).setNegativeButton("取消",null).show();
            }
        });
        if(u.getName()==null)
            textViewname.setText("未设置昵称"+"\n"+u.getSiginature());
        else
            textViewname.setText(u.getName()+"\n"+u.getSiginature());
    }


}
