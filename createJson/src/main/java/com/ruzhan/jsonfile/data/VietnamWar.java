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
public class VietnamWar {

    private static final int ID = 5903;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "越南战争";
    private static final String TAG = "历史·战争·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/vietnam-war.jpg";

    private static final String DESC = "越南战争纪录片";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/vietnam-war01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "采访了来自各方的近80名亲历者，既有参战与反战的美国人，也有南越与北越的军民。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/vietnam-war02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "本片历经十年制作，跨遍全球搜集资料，其中有许多少见和重新数字化的影像档案，", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "还有20世纪最为出名的摄影照片和家庭影视，以及历史新闻片段和政府内部的秘密录音。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "越南战争.3跨越冥河", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=20406207&page=1"));

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
