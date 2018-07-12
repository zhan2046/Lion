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
public class AliensMoon {

    private static final int ID = 3403;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "Aliens on the Moon";
    private static final String TAG = "揭露·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/aliens-moon.jpg";

    private static final String DESC = "本片揭露有关我们的邻居月球，在月球上曾经有外星人居住，并作为一个星际中转区。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/aliens-moon01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "一个半小时的视频为您展示所有令人震惊的证据:巨大的卫星天线,核电站,巨大的UFO,外星人的太空堡垒,采矿区。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "而NASA把这些证据在一一销毁,上世纪70年代是否还有其它阿波罗号在秘密探月?他们去干什么?", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "Aliens on the Moon", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=2878263&cid=4497344&page=1"));

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
