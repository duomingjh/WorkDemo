package com.shw.workdemo.Frame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shw.workdemo.Adapters.musicTvAdapter;
import com.shw.workdemo.Bean.musicdata;
import com.shw.workdemo.R;
import com.shw.workdemo.Tools.GetcontextHpler;

import java.util.ArrayList;
import java.util.List;

public class rightmusicframe extends Fragment {
    private List<musicdata> list;
    private View view;
    private String[] musicname={
            "琵琶行",
            "酒醉的蝴蝶",
            "少年",
            "大海 - 张雨生",
            "日不落 - 蔡依林",
            "曹操 - 林俊杰",
            "琵琶行",
            "酒醉的蝴蝶",
            "少年",
            "大海 - 张雨生",
            "日不落 - 蔡依林",
            "曹操 - 林俊杰"

    };
    private String[] musicurl={
            "http://96.ierge.cn/12/185/370503.mp3",
        "http://mp32.9ku.com/upload/128/2019/08/14/994784.mp3",
            "http://mp32.9ku.com/upload/128/2020/04/17/1003659.mp3",
            "http://mp3.9ku.com/hot/2004/07-13/11417.mp3",
            "http://mp3.9ku.com/hot/2007/09-18/89467.mp3",
            "http://mp3.9ku.com/hot/2006/02-15/75199.mp3",
            "http://96.ierge.cn/12/185/370503.mp3",
            "http://mp32.9ku.com/upload/128/2019/08/14/994784.mp3",
            "http://mp32.9ku.com/upload/128/2020/04/17/1003659.mp3",
            "http://mp3.9ku.com/hot/2004/07-13/11417.mp3",
            "http://mp3.9ku.com/hot/2007/09-18/89467.mp3",
            "http://mp3.9ku.com/hot/2006/02-15/75199.mp3"

    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.right_music,container,false);
        init();
        RecyclerView recyclerView=view.findViewById(R.id.music_frame);

        LinearLayoutManager layoutManager=new LinearLayoutManager(GetcontextHpler.getContext());
        recyclerView.setLayoutManager(layoutManager);
        musicTvAdapter a=new musicTvAdapter(list);
        recyclerView.setAdapter(a);
        return view;
    }
    void init(){
        list=new ArrayList<>();

         for(int i=0;i<musicname.length;i++){
             musicdata m=new musicdata();
             m.setName(musicname[i]);
             m.setURL(musicurl[i]);
             list.add(m);
         }

    }
}
