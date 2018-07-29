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
public class TheHunt {

    private static final int ID = 4103;
    private static final String PLAY_COUNT = "7";

    private static final String TITLE = "BBC One - The Hunt";
    private static final String TAG = "自然·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-hunt.jpg";

    private static final String DESC = "BBC地球部自然纪录片新高度，由冰冻星球制作团队历时3年，跨越30多个国家拍摄完成，拍摄到了很多令人窒息的罕见镜头，“自然纪录片之父”大卫·爱登堡旁白。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-hunt01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "首次披露南美水濑，座头鲸的猎食行为，更借用了电影、戏剧中的片段，力求给观众一个具有说服力的印象。 ", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-hunt02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "摄制组的足迹遍布雨林，冻土层，海洋，草原，极地，典型生态环境一网打尽，还记录了各路科学家以及环保人士对保护濒危动物所做出的努力。 ", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "由《地心引力》的作曲家Steven Price作曲。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "鸟瞰航拍水下特写等极致摄影技术，电影式的剪辑手法和地心引力配乐师作曲，其故事性和悬念性俨然是一部好莱坞大片。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "1、第一集", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=5607227&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、第二集", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=5607227&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、第三集", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=5607227&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、第四集", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=5607227&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、第五集", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=5607227&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、第六集", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=5607227&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、第七集", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=5607227&page=7"));

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
