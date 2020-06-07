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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.shw.workdemo.Adapters.LoopViewPage;
import com.shw.workdemo.Adapters.newsAdapter;
import com.shw.workdemo.Bean.newContext;
import com.shw.workdemo.R;

import java.util.ArrayList;

public class rightframe extends Fragment {
    private View view;
    private ArrayList<ImageView> imageList;
    private ArrayList<newContext> newslist=new ArrayList<>();
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
        initNEws();
        RecyclerView recyclerView=view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        newsAdapter adapter=new newsAdapter(newslist);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private void initNEws(){
        for (int i=0;i<4;i++){
            newContext m=new newContext("青年如何抓住海南自贸港建设红利","《海南自由贸易港建设总体方案》提出11个方面39条具体政策，对年轻人而言，方案有哪些政策利好？",R.drawable.new_image);
            newslist.add(m);
            newContext m1=new newContext("青年如何抓住海南自贸港建设红利","《海南自由贸易港建设总体方案》提出11个方面39条具体政策，对年轻人而言，方案有哪些政策利好？",R.drawable.new_image);
            newslist.add(m1);
            newContext m2=new newContext("青年如何抓住海南自贸港建设红利","《海南自由贸易港建设总体方案》提出11个方面39条具体政策，对年轻人而言，方案有哪些政策利好？",R.drawable.new_image);
            newslist.add(m2);
        }
    }

}
