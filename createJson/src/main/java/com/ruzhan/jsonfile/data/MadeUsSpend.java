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
public class MadeUsSpend {

    private static final int ID = 2203;
    private static final String PLAY_COUNT = "3";

    private static final String TITLE = "BBC 谁在引导我们消费";
    private static final String TAG = "BBC·历史·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/made-us-spend.png";

    private static final String DESC = "我们为什么要买东西？谁让这个世界变得无节制消费？他们如何做到这一点？调查记者雅克•佩雷蒂审视了无节制消费潮流背后的机制，得出了答案。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/made-us-spend01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "原来，使这个世界变得无节制消费的元凶，并不是人们普遍认为的广告员和市场推广员，而是这诸多因素背后那些首先改变产品然后改变我们的人们。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "纪录片表明，长久以来，制造商都梦想着在消费者大脑中植入“升级”观念，从而让无限消费成为现实。他们首先瞄准未被开发的儿童市场，学习应用向儿童销售的方法，从而增加向成年人的销售。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "但是，那头最肥的能够带来现金的奶牛却来自恐惧——通过挖掘消费者的恐惧，制造商发现了一个对健康和安全产品有巨大需求的世界。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "1、第一集", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=22833165&cid=37901869&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、第二集", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=22833165&cid=37905650&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、第三集", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=22833165&cid=37907697&page=3"));


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
