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
public class HiddenLife {

    private static final int ID = 5003;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "人体奥妙之细胞的暗战";
    private static final String TAG = "人文·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/hidden-life.jpg";

    private static final String DESC = "由BBC制作关于人体内部细胞消灭病毒的过程。我们是怎么生病的？生病的时候人体免疫系统是怎么运作的？";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/hidden-life01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "每时每刻，你的身体中正进行着一场大战。这场起源于几十亿年前的战斗现今仍然在我们每个的体内发生。这是关于病毒入侵的故事——细胞的生死之战。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/hidden-life02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "这部影片从细胞的内部世界揭示了人体细胞系统的精细机制：从狂热的、扮演着针对进出细胞的每个物体的安全防御系统的细胞膜、", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "贯穿细胞的输送物质颗粒的细胞架、以及保持整个细胞世界运转的线粒体，到保存着DNA的细胞核和成千上万种各自拥有不同的蛋白质的合成。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "而病毒正是旨在劫持这套系统以为其所用：制造更多的病毒。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "BBC 人体的奥妙-细胞内部隐藏的生命暗战", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=2353261&page=1"));


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
