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
public class KeJi {

    private static final int ID = 1003;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "柯基族人大哥给这个世界的警告";
    private static final String TAG = "科教·自然·纪录片";

    private static final String IMAGE = "https://i2.kknews.cc/SIG=rf93pt/10220007op69s51n7os3.jpg";

    private static final String DESC = "哥伦比亚柯基族人的纪录片，非常珍贵，它讲述惟一一个还保留着前哥伦布时代灵性传统的印第安人部落。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://i1.kknews.cc/SIG=1tvmlbt/101r00053r21197799oq.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "懂得万物恒定之法的高基族人，不仅依然保留着古老传统，并且知道如何在这个工业世界上生存下去。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "柯基族人大哥给这个世界的警告", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=26016095&cid=44583119&page=1"));


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
