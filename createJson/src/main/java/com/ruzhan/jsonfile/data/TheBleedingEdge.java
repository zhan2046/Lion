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
public class TheBleedingEdge {

    private static final int ID = 5603;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "尖端医疗的真相:你安全吗";
    private static final String TAG = "社会·科技·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-bleeding-edge.jpg";

    private static final String DESC = "探讨美国利益导向，且价值高达数十亿美元的医疗器材产业，如何将风险天天加诸在病患身上。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-bleeding-edge01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "Investigative filmmakers Kirby Dick and Amy Ziering present a searing exposé of modern medical devices,", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-bleeding-edge02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                " a billion dollar industry whose technological advancements have lead to unparalleled innovations,", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "yet is rife with lax regulations, corporate cover-ups, and profit driven incentives that have lead to deadly risks for unsuspecting patients. ", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "Through an effective blend of archival footage and the testimony of contemporary experts, ", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                " the movie lays out the lineage of the industry in postwar America, while rooting it in the present day. Eric Kohn - IndieWire", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "NetFlix纪录片 尖端医疗的真相:你安全吗 The Bleeding Edge", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=28628871&page=1"));

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
