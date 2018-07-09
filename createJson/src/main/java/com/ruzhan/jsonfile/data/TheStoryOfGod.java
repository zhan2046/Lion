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
public class TheStoryOfGod {

    private static final int ID = 1703;
    private static final String PLAY_COUNT = "6";

    private static final String TITLE = "摩根费里曼之神的万物论";
    private static final String TAG = "纪录片·历史·冒险";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-story-of-dod.jpg";

    private static final String DESC = "国家地理频道《The Story of God with Morgan Freeman》";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-story-of-dod01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "这些永恒及普世的谜团，影响了世上所有拥有信仰的人。摩根在节目中走访许多地方，亲自感受一些重要的宗教体验。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "从耶路撒冷的哭墙、印度的菩提树，到美国的超级教会。他也自告奋勇，充当实验室白老鼠，检视尖端神经科学和宇宙学，跟传统宗教之间的关系。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "他也跟考古学家一起探索人类祖先佚失的古老宗教，如土耳其有万年历史的哥贝克力山丘废墟。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "人和神的关系是人类史上最重要的问题，本节目探讨了信仰对我们生活造成的影响。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "1、第一集：超越死亡", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568901&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、第二集：末日启示", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568902&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、第三集：神为何人", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568897&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、第四集：创世之说", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568898&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、第五集：邪恶之源", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568899&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、第六集：神迹之力", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568900&page=6"));

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
