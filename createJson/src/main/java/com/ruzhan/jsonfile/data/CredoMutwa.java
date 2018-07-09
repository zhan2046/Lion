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
public class CredoMutwa {

    private static final int ID = 803;
    private static final String PLAY_COUNT = "7";

    private static final String TITLE = "1999年 地球史上最震撼的访谈";
    private static final String TAG = "社会·神秘纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/credo-mutwa01.jpg";

    private static final String DESC = "来自非洲的 科瑞多·穆特瓦(Credo Mutwa)，分享古老非洲保存下来的知识。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "也许全世界需要知道这些！”. ...是时候了。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/credo-mutwa.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "他是祖鲁族(古代官方)故事的指定叙述人,同时也是历史知识的保管者，他掌握着惊世秘密，他曾面临各方威胁，为此付出巨大代价，而幕后只是人只想让他永远闭嘴。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "1999年美国著名记者大卫·艾克在南非约翰内斯堡秘密访谈了科瑞多。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、地球史上最震撼的访谈(一)", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、地球史上最震撼的访谈(二)", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、地球史上最震撼的访谈(三)", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、地球史上最震撼的访谈(四)", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、地球史上最震撼的访谈(五)", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、地球史上最震撼的访谈(六)", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、地球史上最震撼的访谈(七)", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=7"));

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
