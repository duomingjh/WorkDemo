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

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.shw.workdemo.Bean.user;
import com.shw.workdemo.Frame.rightframe;
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
        init();
        androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.dr_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        NavigationView navigationView=findViewById(R.id.nav_view);
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("首页");
        }
        navigationView.setCheckedItem(R.id.nav_op1);
        rightframe r=new rightframe(DrawerActivity.this);
        replaceFragment(r);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });

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
        username=getIntent().getStringExtra("username");
        user s= dbTool.selectuser(this,"User.db",1,username);
        drawerLayout=findViewById(R.id.dr_layout);
        nameTv=findViewById(R.id.user_name);
        tallTv=findViewById(R.id.user_tall);
    }
}
