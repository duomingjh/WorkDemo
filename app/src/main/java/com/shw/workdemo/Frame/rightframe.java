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
    int pos=0;
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
        final ViewPager viewPager=view.findViewById(R.id.loopview_page);
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
            newContext m2=new newContext("青年如何抓住海南自贸港建设红利","6月1日，中央正式发布《海南自由贸易港建设总体方案》（以下简称《总体方案》）。《总体方案》提出贸易自由便利、投资自由便利、跨境资金流动自由便利等11个方面共39条具体政策，要把海南岛打造成具有较强国际影响力的高水平自由贸易港。\n" +
                    "\n" +
                    "　　对年轻人而言，方案中有哪些政策利好？年轻人该如何抓住海南自贸港建设红利？\n" +
                    "\n" +
                    "　　海南师范大学中国特色自贸港研究中心主任刘锋认为，海南自贸港建设对年轻人来说发展机会多，平台好，扶持力度大。他表示，在目前经济普遍下行的趋势下，国家给予海南极大的政策支持，让海南拥有显而易见的增量机会，成了炙手可热的地方，投资、创业、就业、生活都非常具有吸引力。\n" +
                    "\n" +
                    "　　在企业所得税、个人所得税方面，《总体方案》中明确，海南对符合条件的企业和个人制定了目前中国大陆最优惠的税收方案——最高税率15%。对注册在海南自由贸易港并实质性运营的鼓励类产业企业，减按15%征收企业所得税。对在海南自由贸易港设立的旅游业、现代服务业、高新技术产业企业，其2025年前新增境外直接投资取得的所得，免征企业所得税。对一个纳税年度内在海南自由贸易港累计居住满183天的个人，其取得的来源于海南自由贸易港范围内的综合所得和经营所得，按照3%、10%、15%三档超额累进税率征收个人所得税。\n" +
                    "\n" +
                    "　　海南大学中国特色自由贸易港研究院常务副院长常健表示：“这是一个非常有吸引力的政策，低税率环境，会让海南成为国际创业港。我们预期国际和国内企业、独角兽企业会纷纷落地海南，给年轻人开创事业提供很广阔的舞台。”\n" +
                    "\n" +
                    "　　“一流的开放形态，会孕育出更多经济的新业态、新模式，年轻人对新鲜事物比较敏锐且接受能力强，更容易把握经济增长中的新机会，在教育、医疗、消费等细分领域都有很多创业机会。年轻人可以把握好政策支持的大方向和趋势，积极创业，自主发展，在互联网和5G等方面寻求发展。”刘锋表示，《总体方案》规定，离岛免税购物额度由现在的每年每人3万元增加到10万元。从消费角度来说，年轻人的经济实力处于初级阶段，免税购物额度提升，可以增强他们的获得感。同时这也是一个创业和就业的机会，“一业兴，百业旺”，这个政策给年轻人带来的机会很多，只要他们敢想敢干。\n" +
                    "\n" +
                    "　　海南建设自贸港离不开人才。此次发布的《总体方案》中提到，针对高端产业人才，实行更加开放的人才和停居留政策；完善国际人才评价机制，以薪酬水平为主要指标评估人力资源类别，建立市场导向的人才机制。\n" +
                    "\n" +
                    "　　刘锋表示，《总体方案》对人才认定机制作了改革，以薪资水平来评定人才，打破以往对人才单一的评价机制。过去强调学历、职称和资历，今后“英雄不问出身”，没有太多条条框框，对年轻人来说，机会均等非常重要。\n" +
                    "\n" +
                    "　　常健也表示，一直以来，海南都对人才高度重视。海南省委人才发展局出台了一系列举措，包括居留、落户便利，提供安居房，补贴安家费。《总体方案》将为这些来海南的年轻人提供更便利的条件，让他们能有所成长和收获，共同分享海南的发展成果。\n" +
                    "\n" +
                    "　　“随着互联网发展，线上办公条件增加，很多一二线城市的年轻人不一定要离开本地，现在许多互联网公司都以工作结果导向，所以也可以异地参与自贸港建设，灵活度很高。”刘锋表示，年轻人想抓住自贸港建设的红利，首先要找准自己的定位，对自己的专业领域和特长有清晰的把握和认知；其次结合海南自贸港的发展趋势和要求，发挥自身特长，同时通过不断学习以应对知识更新和迭代；最后就是要坚定信心，做好与海南自贸港共成长的准备。海南自贸港对国家的发展起到一个探路作用，这也是海南自贸港重大的责任。所以每一个投身海南自贸港建设的年轻人，要持之以恒，一步一个脚印，与海南同荣辱、共进退。\n" +
                    "\n" +
                    "　　“海南建设中国特色自由贸易港及配套政策制度体系，是习近平总书记亲自谋划、亲自部署、亲自推动的改革开放重大举措，也是一个国家战略，是深化改革的桥头堡和标杆。在此背景下，年轻人要将自身发展和国家需求紧密结合，无论是从自身发展还是为国家作出贡献，都是很完美的结合。”常健说。\n" +
                    "\n" +
                    "　　李争艳 中青报·中青网记者 任明超",R.drawable.new_image);
            newslist.add(m2);
        }
    }

}
