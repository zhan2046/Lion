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
public class RichAndUs {

    private static final int ID = 2303;
    private static final String PLAY_COUNT = "3";

    private static final String TITLE = "巨富与我们";
    private static final String TAG = "BBC·历史·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/eich-and-us.jpg";

    private static final String DESC = "一个有关超级土豪的纪录片。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/eich-and-us01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "记者Jacques Peretti走访各种土豪人士、经济学家、平民百姓，研究超级土豪是如何改变了英国。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "这部纪录片揭露出所谓的“下渗式经济”是如果令贫富变得更加悬殊的。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "英国政府为了政绩把本国打造成富人避税天堂，但30多年来所谓的富人涓滴效应并未惠及底层人民，反而随着金融衍生品和次贷危机使贫富差距加剧而形成沙漏社会。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "中产的消亡将进一步削弱资本主义制度。英国如此，世界亦然。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、第一集", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=1931988&cid=2989838&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、第二集", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=1931988&cid=3029801&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、第三集", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=1931988&cid=2989839&page=3"));

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
