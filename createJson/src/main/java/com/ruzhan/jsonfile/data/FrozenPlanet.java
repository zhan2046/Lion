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
public class FrozenPlanet {

    private static final int ID = 4003;
    private static final String PLAY_COUNT = "8";

    private static final String TITLE = "冰冻星球";
    private static final String TAG = "自然·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/frozen-planet.jpg";

    private static final String DESC = "英国BBC电视台耗时5年制作的纪录片《冰冻星球》于近期推出。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/frozen-planet01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "这部耗资巨大的纪录片用镜头真实的展现了正在逐渐溶解的地球两极，以及生活在这里的各种生物，片中种种景象让人叹为观止。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/frozen-planet02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "《冰冻星球》为英国广播公司与探索频道及英国公开大学联合制作的自然纪录片，由大卫·爱登堡旁白。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "2011年10月26日起于英国广播公司第一台及高清频道首播，共7集。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "本片主要展示栖息于北极和南极的动植物及其生境，而第7集则探讨全球暖化对极地以至全球的影响，由大卫·爱登堡联同科学家亲身于极地考察及解说。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "1、BBC.Frozen.Planet.EP01.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=26338600&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、BBC.Frozen.Planet.EP02.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=26338600&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、BBC.Frozen.Planet.EP03.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=26338600&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、BBC.Frozen.Planet.EP04.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=26338600&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、BBC.Frozen.Planet.EP05.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=26338600&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、BBC.Frozen.Planet.EP06.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=26338600&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、BBC.Frozen.Planet.EP07.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=26338600&page=7"));

        videoList.add(new Video(String.valueOf(ID + 18),
                "8、BBC.Frozen.Planet.EP08.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=26338600&page=8"));

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
