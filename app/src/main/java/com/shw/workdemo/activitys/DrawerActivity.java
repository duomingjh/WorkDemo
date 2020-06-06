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

import com.google.android.material.navigation.NavigationView;
import com.shw.workdemo.Frame.rightframe;
import com.shw.workdemo.R;

import java.util.ArrayList;

public class DrawerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private ArrayList<ImageView> imagelist;
    private int[] imgs;
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
        drawerLayout=findViewById(R.id.dr_layout);
    }
}
