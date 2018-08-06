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
public class TheFarthest {

    private static final int ID = 5803;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "最远的地方 The Farthest";
    private static final String TAG = "社会·科技·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-farthest.jpg";

    private static final String DESC = "口碑不错的宇宙纪录片 The Farthest 2017，重现了“旅行者”计划探宇宙的故事，带你去到宇宙尽头。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-farthest01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "1977年，美国发射了旅行者1号和2号，进入太阳系边界，收集木星、土星、天王星、海王星的信息。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-farthest02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "除了采访参与计划的科学家，也去访问了那些代表人类把来自地球的问候刻录在唱片上的人们。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "片中大量来自宇宙深处的照片，令人不得不感叹科学的伟大和迷人之处。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "最远的地方 The Farthest (2017)", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=28495352&page=1"));

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
