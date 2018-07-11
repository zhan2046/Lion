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
public class Monsanto {

    private static final int ID = 3203;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "转基因赌局：用生命下注";
    private static final String TAG = "揭露·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/thrive.jpg";

    private static final String DESC = "这部新纪录片对美国孟山都公司的名誉发起了另一轮剧烈冲击。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/thrive01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "美国孟山都公司是全球最大的化工公司之一，也是全球90%转基因作物的种子技术的提供者。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "这部名为“孟山都公司眼中的世界”的法国纪录片由独立导演Marie-Monique Robin执导，影片为观众展现出一家长期危害环境 、制造卫生健康丑闻的公司的可怕嘴脸。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "转基因赌局：用生命下注", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=10941918&cid=18113835&page=1"));

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
