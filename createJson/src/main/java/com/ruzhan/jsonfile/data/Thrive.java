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
public class Thrive {

    private static final int ID = 3103;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "Thrive《兴盛》";
    private static final String TAG = "探索·自然·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/thrive.jpg";

    private static final String DESC = "通过追踪经济发展而揭开世界运作方式，并涵盖影响我们生命的各种力量面纱的，非常规型纪录电影。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/thrive01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "把科学领域的突破与觉察、行动编织在一起，《兴盛》提供给我们真正的解决方法。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "使我们能够用史无前例地、无畏地战略来改造我们的生活和我们的未来。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "Thrive《兴盛》", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=23294894&cid=38799799&page=1"));

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
