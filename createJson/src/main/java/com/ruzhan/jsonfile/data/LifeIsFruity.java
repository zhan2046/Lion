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
public class LifeIsFruity {

    private static final int ID = 4403;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "积存时间的生活";
    private static final String TAG = "纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/life-is-fruity.jpg";

    private static final String DESC = "一部极其感人的纪录电影《Life Is Fruity》，日本导演伏原健之拍摄。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/life-is-fruity01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "由日本影后树木希林担任旁白，日本现代陶渊明津端夫妇生活纪录片。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "藉由津端修一夫妇丰富的生活阅历，一幢深居林间的小屋，探索那些深藏于时间长河中的真正瑰宝。 ", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/life-is-fruity02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "一幢深居林间的小屋，位于日本高藏寺新城的一隅。那是建筑师津端修一、按著其师安东尼雷蒙德自豪的木造住宅所建成的。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "一年四季景緻万千，庭园栽植的上百种蔬果，经由其妻英子的巧手都成了道道佳餚。不论烹饪、裁缝、耕作，没有一样能难得倒她。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "他们的家居处处充满体贴与用心，印证建筑大师科比意的名言「房子该是生活的藏宝盒」。 ", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "【日本纪录片】人生果实【中文字幕】【2017年】", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=18384690&page=1"));

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
