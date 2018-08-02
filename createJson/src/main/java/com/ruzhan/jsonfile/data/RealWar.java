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
public class RealWar {

    private static final int ID = 4903;
    private static final String PLAY_COUNT = "4";

    private static final String TITLE = "真正的权力的游戏:百年战争";
    private static final String TAG = "历史·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/real-war.jpg";

    private static final String DESC = "乔治·R·R·马丁老爷子坦言《冰与火之歌》的创作灵感来自欧洲历史，本片讲述英格兰和法兰西王国之间的百年战争。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/real-war01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "[BBC] 真正的权力的游戏：百年战争 / The.Real.War.Of.Thrones.The.True.History.of.Europe，共4集。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/real-war02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "本记录片讲述英格兰和法兰西王国之间的百年战争。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、百年战争 第一集", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=21579565&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、百年战争 第二集", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=21579565&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、百年战争 第三集", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=21579565&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、百年战争 第四集", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=21579565&page=4"));


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
