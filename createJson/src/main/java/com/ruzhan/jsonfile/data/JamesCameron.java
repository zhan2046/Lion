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
public class JamesCameron {

    private static final int ID = 4703;
    private static final String PLAY_COUNT = "6";

    private static final String TITLE = "詹姆斯·卡梅隆的科幻故事";
    private static final String TAG = "科幻·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/james-cameron.jpg";

    private static final String DESC = "詹姆斯·卡梅隆将通过分析科幻小说从起初被人们崇拜到如今轰动影视界的成功演变，深度探究人类与科幻小说之间的历史关系及现实意义。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/james-cameron01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "AMC宣布立项科幻小说历史纪录剧集《詹姆斯·卡梅隆的科幻小说轶事》。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/james-cameron02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "詹姆斯·卡梅隆将担任执行制片人。该剧将于2018年上线AMC，共6集。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、第一集 外星生命", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=24026520&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、第二集 外太空", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=24026520&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、第三集 怪物", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=24026520&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、第四集 黑暗未来", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=24026520&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、第五集 智能机器", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=24026520&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、第六集 时间旅行", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=24026520&page=6"));


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
