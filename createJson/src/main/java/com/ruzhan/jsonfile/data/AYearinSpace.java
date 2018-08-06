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
public class AYearinSpace {

    private static final int ID = 5703;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "NASA宇航员太空生活340天全纪录";
    private static final String TAG = "社会·科技·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/a-year-in-space.jpg";

    private static final String DESC = "在国际太空站逗留近1年的美国太空人凯利和俄罗斯太空人科尔尼延科。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/a-year-in-space01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "3月2号联同另一俄太空人沃尔科夫，乘坐「联盟TMA-18M」号太空船安全返抵地球，凯利更以340天，创下美国太空人单次逗留太空时间最长纪录，为未来火星载人任务铺路。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/a-year-in-space02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "PBS于美国当地时间3月2号播出纪录片《A Year in Space》,全程记录Scott Kelly在太空的生活，", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "，大叔或逗比或欢乐，也拍下无数地球的绝美照片。纪录片结尾更是播出三位宇航员回到地球出舱的珍贵画面。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "NASA宇航员太空生活340天全纪录 A Year in Space", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=28405764&page=1"));

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
