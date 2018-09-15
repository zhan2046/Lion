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
public class CosmicDisclosure3 {

    private static final int ID = 6001;
    private static final String PLAY_COUNT = "20";

    private static final String TITLE = "揭露宇宙 101-120集";
    private static final String TAG = "揭露·宇宙";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/cosmi-disclosure03-1.jpg";

    private static final String DESC = "一部关于秘密太空计划（SSP）、宇宙历史、外星人讯息等有关内容的揭露节目。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/cosmi-disclosure03-2.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "科里·古德拥有在SSP秘密太空计划（Secret Space Programs） 的“特别行动顾问”职位上服役20多年的经历。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/cosmi-disclosure03-3.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "他熟悉外星生物，并且与外星人联合工作、交流多年。关于他不可思议的接触经历，我们可以从节目内容与细节中获知更多首次揭露的信息。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、101集 星体投射与宇宙位置", IMAGE, PLAY_COUNT, 1, "第一百零一集",
                "http://player.bilibili.com/player.html?aid=31746795&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、102集 联合低级别军工秘密太空集团", IMAGE, PLAY_COUNT, 2, "第一百零二集",
                "http://player.bilibili.com/player.html?aid=31746795&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、103集 揭秘初始秘密太空飞船", IMAGE, PLAY_COUNT, 3, "第一百零三集",
                "http://player.bilibili.com/player.html?aid=31746795&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、104集 南极新51区", IMAGE, PLAY_COUNT, 4, "第一百零四集",
                "http://player.bilibili.com/player.html?aid=31746795&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、105集 超光速科技", IMAGE, PLAY_COUNT, 5, "第一百零五集",
                "http://player.bilibili.com/player.html?aid=31746795&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、106集 临终证词", IMAGE, PLAY_COUNT, 6, "第一百零六集",
                "http://player.bilibili.com/player.html?aid=31746795&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、107集 零点能源与先进推进技术", IMAGE, PLAY_COUNT, 7, "第一百零七集",
                "http://player.bilibili.com/player.html?aid=31746795&page=7"));

        videoList.add(new Video(String.valueOf(ID + 18),
                "8、108集 分析约瑟夫.斯基珀的照片档案", IMAGE, PLAY_COUNT, 8, "第一百零八集",
                "http://player.bilibili.com/player.html?aid=31746795&page=8"));

        videoList.add(new Video(String.valueOf(ID + 19),
                "9、109集 虫洞与分离文明", IMAGE, PLAY_COUNT, 9, "第一百零九集",
                "http://player.bilibili.com/player.html?aid=31746795&page=9"));

        videoList.add(new Video(String.valueOf(ID + 20),
                "10、110集 月亮背面的黑幕", IMAGE, PLAY_COUNT, 10, "第一百一十集",
                "http://player.bilibili.com/player.html?aid=31746795&page=10"));

        videoList.add(new Video(String.valueOf(ID + 21),
                "11、111集 观众提问-八", IMAGE, PLAY_COUNT, 11, "第一百一十一集",
                "http://player.bilibili.com/player.html?aid=31746795&page=11"));

        videoList.add(new Video(String.valueOf(ID + 22),
                "12、112集 冷战阴影", IMAGE, PLAY_COUNT, 12, "第一百一十二集",
                "http://player.bilibili.com/player.html?aid=31746795&page=12"));

        videoList.add(new Video(String.valueOf(ID + 23),
                "13、113集 观众提问-九", IMAGE, PLAY_COUNT, 13, "第一百一十三集",
                "http://player.bilibili.com/player.html?aid=31746795&page=13"));

        videoList.add(new Video(String.valueOf(ID + 24),
                "14、114集 地下城与金字塔", IMAGE, PLAY_COUNT, 14, "第一百一十四集",
                "http://player.bilibili.com/player.html?aid=31746795&page=14"));

        videoList.add(new Video(String.valueOf(ID + 25),
                "15、115集 南极UFO与五指之秘", IMAGE, PLAY_COUNT, 15, "第一百一十五集",
                "http://player.bilibili.com/player.html?aid=31746795&page=15"));

        videoList.add(new Video(String.valueOf(ID + 26),
                "16、116集 三指技术", IMAGE, PLAY_COUNT, 16, "第一百一十六集",
                "http://player.bilibili.com/player.html?aid=31746795&page=16"));

        videoList.add(new Video(String.valueOf(ID + 27),
                "17、117集 重大实验", IMAGE, PLAY_COUNT, 17, "第一百一十七集",
                "http://player.bilibili.com/player.html?aid=31746795&page=17"));

        videoList.add(new Video(String.valueOf(ID + 28),
                "18、118集 大卫.阿戴尔简历", IMAGE, PLAY_COUNT, 18, "第一百一十八集",
                "http://player.bilibili.com/player.html?aid=31746795&page=18"));

        videoList.add(new Video(String.valueOf(ID + 29),
                "19、119集 原创火箭人", IMAGE, PLAY_COUNT, 19, "第一百一十九集",
                "http://player.bilibili.com/player.html?aid=31746795&page=19"));

        videoList.add(new Video(String.valueOf(ID + 30),
                "20、120集 深入51区", IMAGE, PLAY_COUNT, 20, "第一百二十集",
                "http://player.bilibili.com/player.html?aid=31746795&page=20"));

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
