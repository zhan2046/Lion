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
public class AncientAliens {

    private static final int ID = 403;
    private static final String PLAY_COUNT = "6";

    private static final String TITLE = "远古外星人系列 第一季";
    private static final String TAG = "科教·自然·神秘纪录片";

    private static final String IMAGE = "https://scdn.nflximg.net/images/1775/12151775.jpg";

    private static final String DESC = "远古外星人（英语：Ancient Aliens）是一个美国电视系列，由普罗米修斯娱乐制作，于2010年4月20日在历史频道首播，至2018年已播放第13季。该节目基于古代太空人假说，展现了包含过去人类与外星人接触的历史文献、考古证据和传说。此节目被批评为宣扬伪科学和野史。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));
        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "http://media.history.ca/uploadedimages/smart_forms/featured_items/ancientaliens_600x335_allshowstile.jpg"));
        introduceList.add(new Introduce(Introduce.TEXT,
                "这套节目在香港由TVB在J5播映，取名《古今天外》，2016年播放第一季、第二季，由张炳强旁白。2017年播放第三季、第四季，由招世亮旁白。2018年播放第五季，改由无线财经·资讯台播放。中国中央电视台魅力纪录栏目在2014年以《来自远古星星的你》片名播放，内容有大幅删减。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "战车，众神和太空·Chariots, Gods and Beyond", IMAGE, PLAY_COUNT, "1",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=1"));
        videoList.add(new Video(String.valueOf(ID + 12),
                "证据·The Evidence", IMAGE, PLAY_COUNT, "2",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=2"));
        videoList.add(new Video(String.valueOf(ID + 13),
                "天外来客·The Visitors", IMAGE, PLAY_COUNT, "3",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=3"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "使命·The Mission", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=4"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "亲密接触·Closer Encounters", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=5"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "回归·The Return", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=6"));


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
