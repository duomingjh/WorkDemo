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
    private String[] titles={
            "青年如何抓住海南自贸港建设红利",
            "蓝海101”号科考船完成科考任务返回青岛",
            "中国经济具有强大韧性潜力 专家预计下半年将会反弹",
            "中青报：多所高校全额退宿舍费 不是谁占谁的便宜"
    };
    private int[] im={
            R.drawable.new_image,
            R.drawable.news1,
            R.drawable.news2,
            R.drawable.new_image

    };
    private String[] texts={
            "《海南自由贸易港建设总体方案》提出11个方面39条具体政策，对年轻人而言，方案有哪些政策利好？",
            "6月11日，国内最大的渔业科学考察船“蓝海 101”号，圆满完成国家自然科学基金委渤黄海共享航次春季航次，顺利返回青岛母港。\n" +
                    "\n" +
                    "该航次历时13天，航程2800海里，完成科研调查站位66个、收集水文、气象、化学、生物学以及其他现场观测数据，共计21298个，，为全球变化和人类活动背景下渤黄海海域生态环境及生物资源的变化研究提供科学依据。（张进刚 范锡湘/ 摄）",
            "近年来，安徽省滁州市全椒县六镇镇通过“合作社+农户”形式进行规模化育秧，并为水稻种植户提供耕种、管护、收割、收购等一条龙服务，提高规模化效益，帮助农民增收。图为6月10日，六镇镇一家合作社的农民在水稻秧苗田里进行田间管理。\n" +
                    "　　沈 果摄（人民视觉）\n" +
                    "\n" +
                    "　　6月11日，国务院新闻办公室举行吹风会，与会专家就热点问题回答记者问。专家指出，中国经济具有强大韧性和潜力，长期向好的态势没有改变。预计下半年，中国经济将会反弹。\n" +
                    "\n" +
                    "　　稳就业，促消费\n" +
                    "\n" +
                    "　　疫情发生后，服务型消费减少，食品消费增温。国务院参事、中央财经大学税务学院原副院长刘桓表示：“日常消费在大城市没有受到影响，超市和市场的活跃程度比较高。但是服务型消费减少了，例如子女教育、培训、理发等。”\n" +
                    "\n" +
                    "　　3月份以来，中国经济各项主要指标持续改善，消费市场逐渐回暖。刘桓认为：“随着经济复苏，中国最困难的时刻已经过去，我们对下一阶段充满信心。数字的恢复需要时间，疫情稳定后经济复苏指日可待。我认为二季度会有明显的复苏，到了三季度将会有喷发式的增长。”\n" +
                    "\n" +
                    "　　位居“六保”之首的保居民就业，对于促进消费起着重要作用。在国务院参事、中国银行保险监督管理委员会原副主席王兆星看来，就业稳了，收入才稳，人民群众才有消费能力。“一方面，要不断增加人民群众的可支配收入，增强消费能力和消费需求。另一方面，中国在住房、教育、养老、医疗等方面具有巨大的消费潜力，在供给方面也要提供高质量的商品和服务供给。这样消费市场就能保持稳定增长，对中国经济提供强大支撑。”\n" +
                    "\n" +
                    "　　“速度，不是我们考虑的指标，要保证多数百姓有就业机会。‘六保’中，保就业、民生、产业链和基层运转的核心在于保企业，企业保住了，就业就保住了，收入就有了，基层财政就有了。要让资金流向企业，让企业真正尝到甜头。”刘桓表示。\n" +
                    "\n" +
                    "　　财政和货币政策相互配合\n" +
                    "\n" +
                    "　　衡量财政政策是否积极，既要看财政总量，更要看财政支出的增量。\n" +
                    "\n" +
                    "　　除了新增财政赤字和抗疫特别国债共2万亿元，今年还将新增减税降费2.5万亿元、新增地方政府专项债1.6万亿元和铁路资金1000亿元，共6.2万亿元。国务院参事、财政部原副部长朱光耀介绍，“这个总量还是比较大的，其中很大一部分将在下半年发挥作用。”\n" +
                    "\n" +
                    "　　当前，财政政策和货币政策都有较大空间。例如，还有很多货币工具可以选择，利率也有一定的调整空间等。多位与会专家指出，财政政策和货币政策的配合非常重要。\n" +
                    "\n" +
                    "　　如何协调？王兆星表示，一是通过减税降费，进一步减轻企业的困难和负担。例如，央行通过提供低利率的信贷支持，提供充裕流动性，助力企业走出困境，恢复增长。\n" +
                    "\n" +
                    "　　二是增加低收入群体的收入，促进消费和投资的有效增长。王兆星认为：“通过财政政策和货币政策，进一步扩大有效消费需求和投资需求还有较大空间。”\n" +
                    "\n" +
                    "　　三是央行通过提供市场流动性，为财政支持消费增长起到配合作用。“在中国，中央和地方政府债券都有很大需求，老百姓和机构投资者都是国债的投资者。通过扩大国债发行，可以增加财政对消费的支持，没有必要实行财政赤字的货币化。”王兆星表示。\n" +
                    "\n" +
                    "　　金融支持实体经济“快、直、准”\n" +
                    "\n" +
                    "　　5月底，国务院金融稳定发展委员会推出11条金融改革措施；6月1日，央行、银保监会、发改委、工信部、财政部、市场监管总局、证监会和外汇局等八部委联合发布《关于进一步强化中小微企业金融服务的指导意见》，提出30条措施支持实体经济……一系列措施相继落地。“这些措施都是为了进一步加大对实体经济支持，特别是让受疫情冲击比较严重的小微企业得到更多金融支持，支撑中国经济恢复发展。”王兆星说。\n" +
                    "\n" +
                    "　　具体来看，金融对实体经济的支持要做到“快、直、准”：快，即尽快帮助陷入困境的企业渡过难关，恢复生产；直，即不管是财政的2万亿元还是央行和商业银行的支持都必须直接到达小微企业等市场主体，要防止淤塞和渗漏；准，即财政资金和信贷资金要帮助真正需要帮助同时具有市场竞争力的企业。“要通过金融的有效供给，满足企业的有效需求。”王兆星说。\n" +
                    "\n" +
                    "　　在国务院参事、国务院扶贫办友成企业家扶贫基金会常务副理事长汤敏看来，虽然国际疫情还比较严重，国际物流和海外订单受到一定影响，但随着复工复产的有序推进，国内市场快速启动后，情况会不断改善。“相信下半年，中国经济将会反弹。”\n" +
                    "\n" +
                    "　　“我们对中国恢复经济增长，实现稳中有进，一定的经济增长极有信心。中国已有雄厚的物质基础、完备的基础设施体系支撑、完整的产业链和巨大的国内消费市场需求支撑。14亿人口的巨大市场，本身就是对经济最基本的保障。同时，中国政府在激活国内消费市场方面采取了有效措施，能够更好地增加有效需求、有效供给，促进经济平稳增长。”王兆星说。",
                    "突如其来的新冠肺炎疫情，让不少人的生活“直接”从冬天进入夏季。感触最深的莫过于学生，经历了一个超长“寒假”，再开学已入夏。近日，各地学生陆续迎来开学的日子。对许多地方的大学生来说，这是一个令人振奋的消息，而一些高校退还本学期住宿费的消息，更是“喜上加喜”。\n" +
                            "\n" +
                            "　　无论住宿费是全额退还是按实际情况部分退，都是对学生关切的回应。高校这一干脆利落的举动被赞“把最大的实惠留给学生”。\n" +
                            "\n" +
                            "　　没有住宿，自然不能收费。而且，关于住宿费收取、退费等问题，教育主管部门已有明确说法。今年4月，教育部发布《教育部治理教育乱收费工作领导小组办公室关于疫情防控期间学校收费有关问题的预警》。通知称：住宿费不得跨学年或学期预收，未住宿不得提前收取住宿费。已按学年收取的住宿费，应根据实际住宿情况合理确定退费办法。\n" +
                            "\n" +
                            "　　许多地方和高校根据实际情况推出具体的退费举措，是对教育部预警通知的落实。关心退费问题的学生及家长也大可安心。\n" +
                            "\n" +
                            "　　不过，也出现了另外一种声音：大学宿舍费本来就不高，虽然学生未住但物品还在宿舍，学校管理与维护也涉及费用支出，因此退费对高校而言未免不够公平。\n" +
                            "\n" +
                            "　　这有一定道理，但高校后勤服务不是纯粹的生意，不能用纯商业思维来分析谁“吃亏”了，谁又“占便宜”了。割舍宿舍费，对很多学校来说并不会造成太大的影响，却把政策的温度传递给了每一位学生及他们背后的家庭。对家庭困难的学生来说，这笔“可观的收入”在当下或许能发挥更大价值。\n" +
                            "\n" +
                            "　　如果为了区区几百元的宿舍费而犹豫不决，丢了教育应有的公益属性与温度，对高校来说才是最大的损失。\n" +
                            "\n" +
                            "　　当然，退费问题不能简单化处理。在当前高校推行社会化、市场化管理的大环境下，要兼顾学生、学校、服务提供者等多方利益，用更细化的标准、操作规则、退还办法等寻求各方利益的平衡。\n" +
                            "\n" +
                            "　　比如河北、宁夏等省份明确，在校住宿时间不足一个月的，15天（含15天）以上的按一个月计算，15天以下的按半个月计算。多余部分退还学生。\n" +
                            "\n" +
                            "　　也有部分地区将人员、折旧成本也做了考虑。例如四川省明确对于已按学年收取的住宿费，“学校根据实际住宿时间并综合考虑与宿舍直接相关的人员、折旧等成本支出，在春季学期末结算清退”。\n" +
                            "\n" +
                            "　　这些更细化、更贴近实际的规定与计算方法，清晰且明确，只要在实践过程坚持公开透明，相信大部分学生与公众也能接受。\n" +
                            "\n" +
                            "　　不妨以此次灵活退宿舍费为契机，将类似疫情这样突发情况下退费操作规范化、制度化，以后即便没有主管部门的“预警”，各地各高校也能按照规定做好退费工作。于高校而言，这是一种制约；于学子而言，权益多了一层更有力的保障。\n" +
                            "\n" +
                            "　　疫情之下，从教育主管部门到政策执行者，及时关注到退费问题，透出的是对个体权利的尊重。其中，完全可能有某位学生因这份“意外收获”渡过了眼前的难关。对这批被退费的学生而言，这也必将成为他们在疫情经历中一段温暖的记忆。\n" +
                            "\n" +
                            "　　期待更多地方、高校将这件好事办好，让教育精神直抵人心，润物无声、成风化人。\n" +
                            "\n" +
                            "(责编：朱一梵、仝宗莉)"
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
        for (int i=0;i<titles.length;i++){
           newContext m=new newContext(titles[i],texts[i],im[i]);
           newslist.add(m);

        }
        for (int i=0;i<titles.length;i++){
            newContext m=new newContext(titles[i],texts[i],im[i]);
            newslist.add(m);

        }
    }

}
