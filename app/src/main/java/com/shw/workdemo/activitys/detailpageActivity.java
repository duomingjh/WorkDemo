package com.shw.workdemo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.shw.workdemo.R;

public class detailpageActivity extends AppCompatActivity {
    private TextView titlTv;
    private ImageView newsImage;
    private TextView detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpage);
        init();
        String title=getIntent().getStringExtra("title");
        int image=getIntent().getIntExtra("newsimage",0);
        String detailtv=getIntent().getStringExtra("detail");
        titlTv.setText(title);
        newsImage.setBackgroundResource(image);
        detail.setText(detailtv);
    }
    void init(){
        titlTv=findViewById(R.id.newstitle_detail);
        newsImage=findViewById(R.id.newsimg_detail);
        detail=findViewById(R.id.newscontext_detail);
        detail.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
