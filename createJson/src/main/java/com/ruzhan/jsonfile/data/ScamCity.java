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
public class ScamCity {

    private static final int ID = 2703;
    private static final String PLAY_COUNT = "10";

    private static final String TITLE = "旅游骗术大揭秘 第一季";
    private static final String TAG = "旅游·社会·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/scam-city.jpg";

    private static final String DESC = "走访热门旅游城市，利用偷拍镜头带观众认清骗桉真相，揭露专门向旅客「埋手」的骗局。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/scam-city01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "主持人Conor不惜以身犯险，单人匹马与骗徒正面接触，要从他们口中套取诈骗技俩，过程非常剌激。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "国家地理频道《行骗天下》系列主持人康诺伍德曼带领观众揭开全球十大热门旅游景点的高明诈骗术。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、布宜诺斯艾利斯", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=10624833&cid=17538658&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、东欧捷克布拉格", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=10624833&cid=17538653&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、巴西里约热内卢", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=10624833&cid=17538659&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、西班牙巴塞罗那", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=10624833&cid=17538660&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、南亚印度新德里", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=10624833&cid=17538654&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、东南亚泰国曼谷", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=10624833&cid=17538655&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、赌城拉斯维加斯", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=10624833&cid=17538656&page=7"));

        videoList.add(new Video(String.valueOf(ID + 18),
                "8、土耳其伊斯坦堡", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=10624833&cid=17538661&page=8"));

        videoList.add(new Video(String.valueOf(ID + 19),
                "9、欧洲意大利罗马", IMAGE, PLAY_COUNT, 9, "第九集",
                "http://player.bilibili.com/player.html?aid=10624833&cid=17538657&page=9"));

        videoList.add(new Video(String.valueOf(ID + 20),
                "10、摩洛哥马拉喀什", IMAGE, PLAY_COUNT, 10, "第十集",
                "http://player.bilibili.com/player.html?aid=10624833&cid=17538662&page=10"));

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
