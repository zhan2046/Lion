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
public class Human {

    private static final int ID = 603;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "《HUMAN》";
    private static final String TAG = "社会·纪录片";

    private static final String IMAGE = "http://humanmag.ru/wp-content/uploads/2015/12/visuel-human.png";

    private static final String DESC = "每个人背后都有一个足以撼动心灵的故事。法国知名的摄影师Yann Arthus-Bertrand就用了3年的时间，走访全球60个国家，让2,020位不同肤色、种族、性别的人，在镜头前诉说自己的故事。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "http://www.resourcesforlife.com/wp/wp-content/uploads/2015/12/20151210th1234-documentary-film-human-960x540.jpg"));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://cdn.cronachemaceratesi.it/wp-content/uploads/2016/03/Human-Yann-Arthus-Bertrand-1-400x240.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "由乌克兰的自由战士、马里的农民，到美国的死囚，各人的故事集结成一部纪录片《HUMAN》。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "【纪录片】Human.2015.人类", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=7534518&cid=12337139&page=1"));

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
