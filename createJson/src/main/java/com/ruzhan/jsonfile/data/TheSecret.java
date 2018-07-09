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
public class TheSecret {

    private static final int ID = 703;
    private static final String PLAY_COUNT = "4";

    private static final String TITLE = "秘密《吸引力法则》";
    private static final String TAG = "人文·历史·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-secret-logo.jpg";

    private static final String DESC = "吸引力法则是新思维运动的一种概念，认为人际关系可通过正面或负面想法，从而得到正面或负面的结果。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                "吸引定律又称“吸引力法则”，指思想集中在某一领域的时候，跟这个领域相关的人、事、物就会被他吸引而来。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-secret-img01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "有一种我们看不见的能量，一直引导着整个宇宙规律性的运转，正是因为它的作用地球才能够在46亿年的时间里保持着运转的状态。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "也正是因为它的作用，太阳系乃至整个宇宙中，数以亿计的星球，都能相安无事的停留在各自的轨道上安分地运行", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "这样一种能量引导着宇宙中的每一样事物，也引导着我们的生活，这种能量就是——吸引力。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、秘密", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=6491441&cid=10558125&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、秘密之作品", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=6491441&cid=10558125&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、秘密之超越秘密", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=6491441&cid=10558125&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、秘密之指南针", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=6491441&cid=10558125&page=4"));


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
