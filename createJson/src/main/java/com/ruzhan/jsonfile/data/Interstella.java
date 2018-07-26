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
public class Interstella {

    private static final int ID = 3803;
    private static final String PLAY_COUNT = "2";

    private static final String TITLE = "Interstella 5555";
    private static final String TAG = "动作·冒险·动画片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/interstella.jpg";

    private static final String DESC = "影片讲述了来自另一个星系的四个音乐家被一个邪恶经理人绑架后的冒险经历，而最后他们终于成为了地球上最伟大的一支乐队。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/interstella01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "在宇宙的彼方有一颗美丽的行星Discovery，那里和平地生活着一群外貌与地球人无异，只是肤色为蓝色的人。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/interstella02.gif"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "在这个星球上，有一支摇滚乐队The Crescendolls很受欢迎，乐队有四名成员：低音吉他手Stella、吉他手Arpegius、键盘兼主唱Octave及鼓手Baryl。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/interstella03.gif"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "就在一次演出时，一艘宇宙飞船突然闯入，将这四人绑架并掳到地球，他们不但被洗脑，更被改饰成地球人，这原来全是一名邪恶的经纪人Darkwood伯爵的阴谋。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "他将四人包装成流行乐队，收为麾下，剥夺了他们意识和自由，他们在Darkwood伯爵的百般摆布下，超负荷地出席无数公开场合和表演，竟然只是为了征服全球乐坛排行榜。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "一直倾慕Stella的太空巡逻员Shep追至地球，为营救众人，Shep牺牲了性命。逃出魔掌的四人，通过以身涉险的调查，总算捣破了Darkwood伯爵在音乐界的惊人黑幕。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "最后，The Crescendolls四人终于返回故乡星球，但他们的音乐仍然在地球上流传，继续为地球人所崇拜和热爱。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、1080P，无歌词字幕", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=2215776&cid=9375303&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、960P，含歌词字幕", IMAGE, PLAY_COUNT, 2, "电影",
                "http://player.bilibili.com/player.html?aid=2215776&cid=3443376&page=2"));

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
