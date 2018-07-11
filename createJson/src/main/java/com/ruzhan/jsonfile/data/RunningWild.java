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
public class RunningWild {

    private static final int ID = 2503;
    private static final String PLAY_COUNT = "6";

    private static final String TITLE = "越野千里 第一季";
    private static final String TAG = "野外·冒险·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/running-wild.jpg";

    private static final String DESC = "Bear Grylls全新打造的野外生存的真人秀。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/running-wild01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "贝爷每集将会伙同一位名人，在野外生活48小时。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "名人们将在卡茨基尔山进行空中杂技跳伞，在犹他州用吊绳垂降悬崖，并且在苏格兰高地对抗狂风和暴雨。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "1、第一集", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921842&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、第二集", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921843&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、第三集", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921844&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、第四集", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921845&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、第五集", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921846&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、第六集", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921847&page=6"));

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
