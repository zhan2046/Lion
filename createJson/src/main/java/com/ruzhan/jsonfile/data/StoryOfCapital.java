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
public class StoryOfCapital {

    private static final int ID = 5403;
    private static final String PLAY_COUNT = "20";

    private static final String TITLE = "资本的故事 第1季";
    private static final String TAG = "社会·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/story-of-capital.jpg";

    private static final String DESC = "以四百多年来世界经济的发展历程为背景，以当下的视角剖析资本在市场经济中的作用和地位，为中国经济下一步的深化改革和发展提供借鉴。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/story-of-capital01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "由中央电视台财经频道和康美药业股份有限公司联合制作的系列微纪录片《资本的故事》于近期开始在中央电视台财经频道播出。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/story-of-capital02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "《资本的故事》是中央电视台专业财经短片的一次有益尝试，它以“播出季”的方式滚动制作和播出。第一播出季为20集，每集八分钟。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "讲述了从股票的诞生到次贷危机四百年间的20个精彩的资本故事。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "1、第1季第1集：股份的力量", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=19258366&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、第1季第2集：泡沫的诱惑", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=19258366&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、第1季第3集：南海骗局", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=19258366&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、第1季第4集：汉密尔顿的旋转门", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=19258366&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、第1季第5集：梧桐树下的承诺", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=19258366&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、第1季第6集：给风险定价", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=19258366&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、第1季第7集：注水的股票", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=19258366&page=7"));

        videoList.add(new Video(String.valueOf(ID + 18),
                "8、第1季第8集：巨人的诞生", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=19258366&page=8"));

        videoList.add(new Video(String.valueOf(ID + 19),
                "9、第1季第9集：镀金的美元", IMAGE, PLAY_COUNT, 9, "第九集",
                "http://player.bilibili.com/player.html?aid=19258366&page=9"));

        videoList.add(new Video(String.valueOf(ID + 20),
                "10、第1季第10集：风险的价值", IMAGE, PLAY_COUNT, 10, "第十集",
                "http://player.bilibili.com/player.html?aid=19258366&page=10"));

        videoList.add(new Video(String.valueOf(ID + 21),
                "11、第1季第11集：日本泡沫", IMAGE, PLAY_COUNT, 11, "第十一集",
                "http://player.bilibili.com/player.html?aid=19258366&page=11"));

        videoList.add(new Video(String.valueOf(ID + 22),
                "12、第1季第12集：八百伴倒闭", IMAGE, PLAY_COUNT, 12, "第十二集",
                "http://player.bilibili.com/player.html?aid=19258366&page=12"));

        videoList.add(new Video(String.valueOf(ID + 23),
                "13、第1季第13集：门口的野蛮人", IMAGE, PLAY_COUNT, 13, "第十三集",
                "http://player.bilibili.com/player.html?aid=19258366&page=13"));

        videoList.add(new Video(String.valueOf(ID + 24),
                "14、资本的故事第1季第14集：英镑狙击战", IMAGE, PLAY_COUNT, 14, "第十四集",
                "http://player.bilibili.com/player.html?aid=19258366&page=14"));

        videoList.add(new Video(String.valueOf(ID + 25),
                "15、资本的故事第1季第15集：破碎的梦之队", IMAGE, PLAY_COUNT, 15, "第十五集",
                "http://player.bilibili.com/player.html?aid=19258366&page=15"));

        videoList.add(new Video(String.valueOf(ID + 26),
                "16、资本的故事第1季第16集：创新的温床", IMAGE, PLAY_COUNT, 16, "第十六集",
                "http://player.bilibili.com/player.html?aid=19258366&page=16"));

        videoList.add(new Video(String.valueOf(ID + 27),
                "17、资本的故事第1季第17集：峭壁边缘的华尔街", IMAGE, PLAY_COUNT, 17, "第十七集",
                "http://player.bilibili.com/player.html?aid=19258366&page=17"));

        videoList.add(new Video(String.valueOf(ID + 28),
                "18、资本的故事第1季第18集：华尔街的3A游戏", IMAGE, PLAY_COUNT, 18, "第十八集",
                "http://player.bilibili.com/player.html?aid=19258366&page=18"));

        videoList.add(new Video(String.valueOf(ID + 29),
                "19、资本的故事第1季第19集：麦道夫骗局", IMAGE, PLAY_COUNT, 19, "第十九集",
                "http://player.bilibili.com/player.html?aid=19258366&page=19"));

        videoList.add(new Video(String.valueOf(ID + 30),
                "20、资本的故事第1季第20集：神的午餐", IMAGE, PLAY_COUNT, 20, "第二十集",
                "http://player.bilibili.com/player.html?aid=19258366&page=20"));


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
