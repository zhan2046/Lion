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
public class Weapon {

    private static final int ID = 4503;
    private static final String PLAY_COUNT = "7";

    private static final String TITLE = "人类武器竞赛史";
    private static final String TAG = "社会·历史·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/weapon.jpg";

    private static final String DESC = "纪录片《人类武器竞赛史》。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/weapon01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "20世纪以来，随着科学技术的不断发展，各类新式武器层出不穷。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "它们给世界带来了新的威慑，同时也改变了现代战争的发展进程。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/weapon02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "而为了应对由新武器带来的挑战，各国纷纷开始打造自己的武器系统。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "试图通过研发更强大的武器，以巩固国防力量并提升国际影响力，而围绕着各种武器展开的竞赛也由此展开。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "在纪录片《人类武器竞赛史》中，我们将走进20世纪具有代表性的几种武器装备。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "回顾它们在人类战争史上的发展进程，分析它们对人类战争的影响，并展望它们在未来的发展趋势。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、战斗机", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=17687954&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、坦克", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=17687954&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、雷达与隐身技术", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=17687954&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、核武器", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=17687954&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、战略轰炸机", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=17687954&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、航空母舰", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=17687954&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、核潜艇", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=17687954&page=7"));

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
