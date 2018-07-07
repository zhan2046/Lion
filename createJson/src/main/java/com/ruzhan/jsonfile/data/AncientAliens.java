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

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/ancientalien.jpg";

    private static final String DESC = "远古外星人是一个美国电视系列，由普罗米修斯娱乐制作，于2010年4月20日在历史频道首播，至2018年已播放第13季。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "主要讲述假设在古代有外星人探访，验证古代宇航员理论。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "远古洞穴壁画中奇异的生物，秘鲁的飞机跑道遗迹，和印第安文字中所描述的“神的飞行器”这些反常的考古文物只是一小部分被von Daniken引用作为远古外星宇航员早已被我们的祖先所熟知的例证。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/ancientalien01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "根据历史文献，考古，传说，探访过去人类与外星人接触的证据。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1，战车，众神和太空·Chariots, Gods and Beyond", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2，证据·The Evidence", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3，天外来客·The Visitors", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4，使命·The Mission", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5，亲密接触·Closer Encounters", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6，回归·The Return", IMAGE, PLAY_COUNT, 6, "第六集",
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
