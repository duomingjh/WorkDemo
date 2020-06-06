package com.shw.workdemo.Frame;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.shw.workdemo.Adapters.LoopViewPage;
import com.shw.workdemo.R;

import java.util.ArrayList;

public class rightframe extends Fragment {
    private View view;
    private ArrayList<ImageView> imageList;
    private int imgs[]=new int[]{
            R.drawable.viewpage01,
            R.drawable.viewpage01,
            R.drawable.m1
    };
    Context context;
    public rightframe(Context context){
        this.context=context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.another_right_fragment,container,false);
        imageList=new ArrayList<>();
        for(int i=0;i<imgs.length;i++){
            ImageView imageView=new ImageView(context);
            imageView.setBackgroundResource(imgs[i]);
            imageList.add(imageView);
        }
        LoopViewPage loopViewPage=new LoopViewPage(imageList);
        ViewPager viewPager=view.findViewById(R.id.loopview_page);
        viewPager.setAdapter(loopViewPage);

        return view;
    }


}
