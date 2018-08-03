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
public class ThreeCountries {

    private static final int ID = 5103;
    private static final String PLAY_COUNT = "6";

    private static final String TITLE = "三国的世界";
    private static final String TAG = "历史·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/three-countries.jpg";

    private static final String DESC = "通过讲述“三国”和其中人物的命运故事，传递他们所承载的传续千年的精神力量和文化底蕴，并探寻那段历史中最有价值的精神本源以及它对后世的深刻影响。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/three-countries01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "《三国的世界》共分为六集，每集50分钟，分别为《良史演义共三国》《星落秋风五丈原》《横槊悲歌观沧海》《义薄云天垂九州》《一江南北真豪杰》《大江东去意未销》。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/three-countries02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "第一集的主要人物是《三国志》的作者陈寿和《三国演义》的作者罗贯中，以及为《三国志》作注的作者裴松之；第二集的主要人物是蜀相诸葛亮。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "第三集的主要人物是魏武帝曹操；第四集的主要人物是汉寿亭侯关羽。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "第五集是群像，以东吴的孙权、周瑜和鲁肃为主要人物；第六集聚焦三国文化的影响力为何如此普遍、持久。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "1、1. 大江东去意未销", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=27564550&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、2. 星落秋风五丈原", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=27564550&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、3. 横槊悲歌观沧海", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=27564550&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、4. 义薄云天垂九州", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=27564550&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、5. 一江南北真豪杰", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=27564550&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、6. 良史演义共三国", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=27564550&page=6"));


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
