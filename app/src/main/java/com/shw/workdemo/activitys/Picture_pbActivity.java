package com.shw.workdemo.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shw.workdemo.R;
import com.shw.workdemo.Tools.GetcontextHpler;
import com.shw.workdemo.Tools.ImageDownLoadAsyncTask;

public class Picture_pbActivity extends AppCompatActivity {
    private LinearLayout layout_left;
    private LinearLayout layout_right;
    private Drawable[] drawables;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_pb);
        layout_left=findViewById(R.id.pb_left);
        layout_right=findViewById(R.id.pb_right);
        String [] imaesPath={
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591789520013&di=8925f78b5048dfcf79d9c6c77fb783e7&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591789575380&di=b5a04b1a9f7d3830420033579c20a0a2&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F68%2F61%2F300000839764127060614318218_950.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591789603444&di=6cebebaa9f5dce2f29b7c6f5ca28392d&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fd000baa1cd11728bcdde8185ccfcc3cec2fd2ca1.jpg",
                "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1018380909,477757436&fm=26&gp=0.jpg",
                "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1749283526,3188307578&fm=11&gp=0.jpg",
                "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3496870847,4674976&fm=26&gp=0.jpg",
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3849722728,3392372800&fm=26&gp=0.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591795743425&di=011e7cfcf3ba5f0be4ace27f8f2f3e7b&imgtype=0&src=http%3A%2F%2F00.minipic.eastday.com%2F20161216%2F20161216093731_399df0a518f7932d349ba3bb0a8ab3da_1.jpeg",
                "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1749283526,3188307578&fm=11&gp=0.jpg",
                "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3496870847,4674976&fm=26&gp=0.jpg",
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3849722728,3392372800&fm=26&gp=0.jpg",
        };
        verifyStoragePermissions(Picture_pbActivity.this);
        int j=0;
        for(int i=0;i<imaesPath.length*3;i++){
            addBitMapToImage(imaesPath[i%imaesPath.length],j,i);
            j++;
            if(j>=2)
            {
                j=0;
            }
        }
    }

    private void addBitMapToImage(String s, int j, int i) {
        final ImageView imageView=new ImageView(Picture_pbActivity.this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        new ImageDownLoadAsyncTask(s,imageView).execute((Void)null);
        imageView.setTag(i);
        if(j==0){
            layout_left.addView(imageView);
        }else if(j==1){
            layout_right.addView(imageView);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Picture_pbActivity.this,"你点击了"+v.getTag(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
