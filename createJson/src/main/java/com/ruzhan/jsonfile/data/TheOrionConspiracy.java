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
public class TheOrionConspiracy {

    private static final int ID = 903;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "猎户座阴谋";
    private static final String TAG = "艺术·纪录·科幻片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-orion-conspiracy.jpg";

    private static final String DESC = "该影片表达的是在时间的考验下，我们也许将会受到自己所作的一切的惩罚，在痛苦中失去生命的本来。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-orion-conspiracy01.jpg"));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-orion-conspiracy02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "你知道么，这世界上存在一种造价不超过一台计算机，仅使用水和空气就可以供应一家用电的机器，你未曾听说过，因为这将颠覆那些财团、国家。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "你知道么，我们的文化，价值观，金融系统在奴役你，你要努力工作一生以买一套房子。媒体让我们购买不需要的产品，因为那会让你幸福。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "你知道么，这个世界，国家，民族间应该相亲相爱的，而我们整个人类的社会系统都在憎恨，嫉妒。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "也许我们一直生活在一个巨大无比的阴谋下，一无所知，追求幸福，而忘记了造物者的初衷。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "猎户座阴谋", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=16189807&cid=26423988&page=1"));

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
