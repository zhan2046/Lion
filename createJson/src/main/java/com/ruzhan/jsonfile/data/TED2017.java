package com.ruzhan.jsonfile.data;

import com.ruzhan.jsonfile.model.Introduce;
import com.ruzhan.jsonfile.model.Movie;
import com.ruzhan.jsonfile.model.MovieDetail;
import com.ruzhan.jsonfile.model.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruzhan123 on 2018/7/3.
 */
public class TED2017 {

    private static final int ID = 3603;
    private static final String PLAY_COUNT = "11";

    private static final String TITLE = "2017年度最受欢迎TED演讲";
    private static final String TAG = "TED·社会·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/ted02.jpg";

    private static final String DESC = "美国的一家私有非营利机构，该机构以它组织的TED大会著称。TED诞生于1984年";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/ted-desc.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "TED大会希望传达这样一个的信息，即优秀的思想可以改变人们对这个世界的看法，使人们反思自己的行为。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "TED大会只是TED社区的一部分，任何人，只要他认同某个TED演讲所传递的观点，都是TED社区的一员，他们都可以为实现某个伟大的理想而共同努力。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "TED演讲（TED Talks）的主题并不仅仅局限于技术、娱乐和设计。事实上，科学、教育、发展、文化、商业、艺术、环保等话题也经常出现。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、TED演讲特斯拉ceo马斯克TED专访：我们不能等待一个悲惨未来的到来", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123099&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、TED演讲：爱美很正常，但也很狭隘", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123100&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、TED演讲：长大后，我逃离了那个恐怖的教会", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123101&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、TED演讲沙鲁克汗 关于人性、名利和爱", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123102&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、TED演讲：人工智能想要具有意识，除非活起来", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123103&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、TED演讲：怎样的人生更有意义？这里有4点建议", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123104&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、TED演讲：电脑是怎么准确识别东西的？", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123105&page=7"));

        videoList.add(new Video(String.valueOf(ID + 18),
                "8、TED演讲：你是给予者还是索取者？", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123106&page=8"));

        videoList.add(new Video(String.valueOf(ID + 19),
                "9、TED演讲：看手机太久，可能是你不开心的原因", IMAGE, PLAY_COUNT, 9, "第九集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123107&page=9"));

        videoList.add(new Video(String.valueOf(ID + 20),
                "10、TED演讲：认清自己的恐惧，可能比明确目标更重要", IMAGE, PLAY_COUNT, 10, "第十集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123108&page=10"));

        videoList.add(new Video(String.valueOf(ID + 21),
                "11、TED演讲：未来如何避免机器人抢走饭碗？", IMAGE, PLAY_COUNT, 11, "第十一集",
                "http://player.bilibili.com/player.html?aid=17838687&cid=29123109&page=11"));

        movie.id = String.valueOf(ID);
        movie.title = TITLE;
        movie.tag = TAG;
        movie.desc = DESC;
        movie.image = IMAGE;

        movieDetail.id = String.valueOf(ID + 3);
        movieDetail.movieId = String.valueOf(ID);
        movieDetail.title = TITLE;
        movieDetail.tag = TAG;
        movieDetail.desc = DESC;
        movieDetail.image = IMAGE;

        movieDetail.introduces = new ArrayList<>();
        movieDetail.introduces.addAll(introduceList);

        movieDetail.videos = new ArrayList<>();
        movieDetail.videos.addAll(videoList);
    }
}
