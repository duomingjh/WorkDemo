package com.shw.workdemo.Frame;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shw.workdemo.Adapters.videoAdapter;
import com.shw.workdemo.Bean.videoData;
import com.shw.workdemo.R;
import com.shw.workdemo.Tools.GetcontextHpler;

import java.util.ArrayList;
import java.util.List;

public class rightVoide extends Fragment {
    private List<videoData> list;
    private String[] url={
            "https://vodpub1.v.news.cn/original/20200612/714647399ccf4bd09a1fac55819e48ba.mp4",
            "https://vodpub1.v.news.cn/original/20200612/714647399ccf4bd09a1fac55819e48ba.mp4",
            "https://vodpub1.v.news.cn/original/20200612/714647399ccf4bd09a1fac55819e48ba.mp4",
            "https://vodpub1.v.news.cn/original/20200612/714647399ccf4bd09a1fac55819e48ba.mp4",
            "https://vodpub1.v.news.cn/original/20200612/714647399ccf4bd09a1fac55819e48ba.mp4",
            "https://vodpub1.v.news.cn/original/20200612/714647399ccf4bd09a1fac55819e48ba.mp4",
            "https://vodpub1.v.news.cn/original/20200612/714647399ccf4bd09a1fac55819e48ba.mp4"

    };
    private int[] ims={
            R.drawable.video01,
            R.drawable.video2,
            R.drawable.video3,
            R.drawable.video2,
            R.drawable.video3,
            R.drawable.video01,
            R.drawable.video01
    };
    private View view;
    private Context context;
    public rightVoide(Context context){
        this.context=context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.voide_right,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.video_frame);
        init();
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        videoAdapter adapter=new videoAdapter(list);
        recyclerView.setAdapter(adapter);
        return view;
    }
    //装载数据
    void  init(){
        list=new ArrayList<>();
        for(int i=0;i<url.length;i++){
            videoData v=new videoData();
            v.setUrl(url[i]);
            v.setImage(ims[i]);
            list.add(v);
        }
    }
}
