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
public class TED2016 {

    private static final int ID = 3703;
    private static final String PLAY_COUNT = "10";

    private static final String TITLE = "2016年度十佳TED演讲";
    private static final String TAG = "TED·社会·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/ted03.jpg";

    private static final String DESC = "美国的一家私有非营利机构，该机构以它组织的TED大会著称。TED诞生于1984年";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/ted-desc.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "TED大会希望传达这样一个的信息，即优秀的思想可以改变人们对这个世界的看法，使人们反思自己的行为。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "TED大会只是TED社区的一部分，任何人，只要他认同某个TED演讲所传递的观点，都是TED社区的一员，他们都可以为实现某个伟大的理想而共同努力。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "TED演讲（TED Talks）的主题并不仅仅局限于技术、娱乐和设计。事实上，科学、教育、发展、文化、商业、艺术、环保等话题也经常出现。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "1、“天上掉馅饼”的邮件", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=8347845&cid=13739252&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、你有拖延症吗", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=8347845&cid=13739253&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、如何成为一个更好的交谈者", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=8347845&cid=13739254&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、做好奇宝宝，跟恶习永别", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=8347845&cid=13739255&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、你有拖延症吗续篇", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=8347845&cid=13739256&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、你真的可以识破孩子的谎言么？", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=8347845&cid=13739257&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、做勇敢的女孩", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=8347845&cid=13739258&page=7"));

        videoList.add(new Video(String.valueOf(ID + 18),
                "8、性格的迷思--你究竟是谁？", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=8347845&cid=13739259&page=8"));

        videoList.add(new Video(String.valueOf(ID + 19),
                "9、为什么我们总认为是对的？", IMAGE, PLAY_COUNT, 9, "第九集",
                "http://player.bilibili.com/player.html?aid=8347845&cid=13739260&page=9"));

        videoList.add(new Video(String.valueOf(ID + 20),
                "10、生命中不可或缺的余音", IMAGE, PLAY_COUNT, 10, "第十集",
                "http://player.bilibili.com/player.html?aid=8347845&cid=13739261&page=10"));


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
