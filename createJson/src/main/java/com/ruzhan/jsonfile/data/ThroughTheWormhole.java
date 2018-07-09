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
public class ThroughTheWormhole {

    private static final int ID = 1503;
    private static final String PLAY_COUNT = "8";

    private static final String TITLE = "摩根费里曼之穿越虫洞";
    private static final String TAG = "科教·记录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/through-the-wormhole.jpg";

    private static final String DESC = "探讨科学的电视节目，由摩根·费里曼担任旁白及主持人。于美国时间2010年6月9日在科学频道首播。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/through-the-wormhole01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "《摩根费里曼之穿越虫洞》是一部由摩根弗里曼主持的科教纪录片。由百老汇演员摩根费里曼特别主持，从摩根费里曼介绍的话语中和作品中他经常出演科学家也能感受到他对天体物理的喜爱，并在节目中阐述世界是由数字组成的，从而成为了节目的“灵魂”。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "节目内容丰富，包括了天文、人文、科学等领域，节目组集结的多位科学家发表自己的意见并互相的反驳争论，这也是天体物理爱好者的另一项看点，给未来宇宙的探索增长了见识，并给令一些科幻迷们另一些想象的空间。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "每集节目将深入探讨一个重要的谜团，并介绍来自著名机构和研究中心的科学研究，和令人惊奇的专家理论，像是美国太空总署、牛津大学、欧洲核子研究组织（简称CERN）、外星生命探测研究所、普林斯顿大学、麻省理工学院和费米国家实验室等等。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "1、S01E01：存在造物主吗？", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=26085119&cid=44723548&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、S01E02：黑洞之迷", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=26085119&cid=44725193&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、S01E03：时间旅行可能吗？", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=26085119&cid=44725194&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、S01E04：太初之前，宇宙若何？", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=26085119&cid=44725389&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、S01E05：我们从何而来？", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=26085119&cid=44725698&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、S01E06：我们独居宇宙？", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=26085119&cid=44725947&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、S01E07：我们究竟由何组成？", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=26085119&cid=44726179&page=7"));

        videoList.add(new Video(String.valueOf(ID + 18),
                "8、S01E08：超越黑暗", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=26085119&cid=44726427&page=8"));

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
