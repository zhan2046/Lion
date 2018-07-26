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
public class DaftPunk {

    private static final int ID = 3903;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "Daft Punk Unchained";
    private static final String TAG = "社会·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/daft-punk.jpg";

    private static final String DESC = "Daft Punk，一个创立于法国巴黎的电子音乐团体，他们用开放的音乐态度，打破浩室、迪斯科和放克音乐的传统分野，开发变化多端的旋律、声响与歌唱，创造出幽默而不失深度，极富想象力的作品。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/daft-punk01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "以一首「Get Lucky」红遍全球的法国电音天团「傻瓜庞克」，成军20年来却极少公开露面，尔后更彻底以机器人形象现身活动。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/daft-punk02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "法国导演赫威马丁戴皮耶的纪录片《傻瓜庞克：谁是傻瓜》，邀请到肯伊威斯特、「菲董」菲瑞威廉斯等大牌巨星，", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "横跨法英美三国的音乐製作人、乐评及音乐录影带导演现身说法，探索傻瓜庞克的创作历程，如何将向来由英美领导的流行音乐带向新纪元。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/daft-punk03.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "傻朋克著名于他们的表演皆经过精心的策划，并将视觉的效果及元素融入进音乐中、作品亦皆有如故事般的铺陈。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "自2001年以来，傻瓜朋克大多以机器人的扮相出现在公众视野，而他们的头盔以及手套就是其机器人扮相中很重要的标志。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "两人为了保持乐团的神秘感，基本都不会接受采访或是在电视节目里出现。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "【纪录片】被解放的蠢朋克 【2015】【法国】", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=5623215&cid=9133202&page=1"));

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
