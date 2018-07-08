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
public class PunPun {

    private static final int ID = 1203;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "生活如此简单，为什么让我们变得很复杂";
    private static final String TAG = "TED";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/punpun.jpg";

    private static final String DESC = "一个来自泰国东北部的农民，他与我们分享了他对简单、幸福的生活的理解。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/punpun01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "他成立了一个可持续性生活的Pun Pun中心，而且还在不断努力寻找更简单的方法满足人们的基本需求。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "你那么努力，为什么还活得那么难？一个值得读完的故事，让许多人看完都沉默了….", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "生活如此简单，为什么让我们变得很复杂", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=4456510&cid=7221659&page=1"));


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
