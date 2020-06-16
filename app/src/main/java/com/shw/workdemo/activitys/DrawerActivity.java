package com.shw.workdemo.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.shw.workdemo.Bean.user;
import com.shw.workdemo.Frame.rightVoide;
import com.shw.workdemo.Frame.rightframe;
import com.shw.workdemo.Frame.rightmusicframe;
import com.shw.workdemo.R;
import com.shw.workdemo.Tools.dbTool;

import java.util.ArrayList;

import static com.shw.workdemo.Tools.dbTool.selectuser;

public class DrawerActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private String username;
    private TextView nameTv;
    private TextView tallTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.dr_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        NavigationView navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.dr_layout);
        nameTv=navigationView.getHeaderView(0).findViewById(R.id.user_name);
        tallTv=navigationView.getHeaderView(0).findViewById(R.id.user_tall);
        username=getIntent().getStringExtra("username");
        user s= dbTool.selectuser(this,"User.db",1,username);
        if(s.getName()==null||s.getName().length()<=0){
            nameTv.setText("未设置昵称");
        }else {
            nameTv.setText(s.getName());
        }
        if(s.getSiginature()==null){
            tallTv.setText("未设置个性签名");
        }else{
            tallTv.setText(s.getSiginature());
        }
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("首页");
        }

        rightframe r=new rightframe(DrawerActivity.this);
        replaceFragment(r);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_op1:
                        Intent intent=new Intent(DrawerActivity.this,presiondataActivity.class);
                        intent.putExtra("id",username);
                        startActivity(intent);
                        break;
                    case  R.id.nav_op2:
                        Intent intent1=new Intent(DrawerActivity.this,Picture_pbActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_op3:
                        rightmusicframe r=new rightmusicframe();
                        replaceFragment(r);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_op4:
                        rightframe right=new rightframe(DrawerActivity.this);
                        replaceFragment(right);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_op5:
                        Intent intent2=new Intent(DrawerActivity.this,registerActivity.class);
                        startActivity(intent2);
                        break;
                    case  R.id.nav_op6:
                        rightVoide voide=new rightVoide(DrawerActivity.this);
                        replaceFragment(voide);
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        user s= dbTool.selectuser(this,"User.db",1,username);
        Log.i("user",s.toString());
        if(s.getName()==null||s.getName().length()<=0){
            nameTv.setText("未设置昵称");
        }else {
            nameTv.setText(s.getName());
        }
        if(s.getSiginature()==null){
            tallTv.setText("未设置个性签名");
        }else{
            tallTv.setText(s.getSiginature());
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.main_con,fragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
        }
        return true;
    }

    private void init(){
        drawerLayout=findViewById(R.id.dr_layout);
        nameTv=findViewById(R.id.user_name);
        tallTv=findViewById(R.id.user_tall);
        username=getIntent().getStringExtra("username");
        user s= dbTool.selectuser(this,"User.db",1,username);
        nameTv.setText(s.getName());
        tallTv.setText(s.getSiginature());
    }
}
