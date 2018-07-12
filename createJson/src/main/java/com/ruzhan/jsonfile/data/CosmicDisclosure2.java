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
public class CosmicDisclosure2 {

    private static final int ID = 3303;
    private static final String PLAY_COUNT = "37";

    private static final String TITLE = "揭露宇宙 24-60集";
    private static final String TAG = "揭露·宇宙";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/cosmi-disclosure.jpg";

    private static final String DESC = "一部关于秘密太空计划（SSP）、宇宙历史、外星人讯息等有关内容的揭露节目。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/cosmi-disclosure01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "科里·古德拥有在SSP秘密太空计划（Secret Space Programs） 的“特别行动顾问”职位上服役20多年的经历。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "他熟悉外星生物，并且与外星人联合工作、交流多年。关于他不可思议的接触经历，我们可以从节目内容与细节中获知更多首次揭露的信息。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "24集（征服太阳系）", IMAGE, PLAY_COUNT, 1, "第二十四集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196167&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "25集（超越太阳系）", IMAGE, PLAY_COUNT, 2, "第二十五集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196168&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "26集（秘密太空计划的科技）", IMAGE, PLAY_COUNT, 3, "第二十六集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196248&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "27集（观众提问part 1）", IMAGE, PLAY_COUNT, 4, "第二十七集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196325&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "28集（来自人工智能的威胁）", IMAGE, PLAY_COUNT, 5, "第二十八集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196467&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "29集（警惕人工智能）", IMAGE, PLAY_COUNT, 6, "第二十九集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196588&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "30集（人工智能战争的新前线）", IMAGE, PLAY_COUNT, 7, "第三十集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196709&page=7"));

        videoList.add(new Video(String.valueOf(ID + 18),
                "31集（观众提问part 2）", IMAGE, PLAY_COUNT, 8, "第三十一集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196797&page=8"));

        videoList.add(new Video(String.valueOf(ID + 19),
                "32集（地底世界）", IMAGE, PLAY_COUNT, 9, "第三十二集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196909&page=9"));

        videoList.add(new Video(String.valueOf(ID + 20),
                "33集（古德的地心之旅）", IMAGE, PLAY_COUNT, 10, "第三十三集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197042&page=10"));

        videoList.add(new Video(String.valueOf(ID + 21),
                "34集（班图精神与蓝鸟人）", IMAGE, PLAY_COUNT, 11, "第三十四集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197152&page=11"));

        videoList.add(new Video(String.valueOf(ID + 22),
                "35集（地底揭秘）", IMAGE, PLAY_COUNT, 12, "第三十五集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197253&page=12"));

        videoList.add(new Video(String.valueOf(ID + 23),
                "36集（地底之旅）", IMAGE, PLAY_COUNT, 13, "第三十六集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197400&page=13"));

        videoList.add(new Video(String.valueOf(ID + 24),
                "37集（地底图书馆）", IMAGE, PLAY_COUNT, 14, "第三十七集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197513&page=14"));

        videoList.add(new Video(String.valueOf(ID + 25),
                "38集（地底之旅-进入记录大厅）", IMAGE, PLAY_COUNT, 15, "第三十八集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197588&page=15"));

        videoList.add(new Video(String.valueOf(ID + 26),
                "39集（地底之旅-向联盟汇报）", IMAGE, PLAY_COUNT, 16, "第三十九集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197692&page=16"));

        videoList.add(new Video(String.valueOf(ID + 27),
                "40集（班图精神与蓝鸟人信息part 2）", IMAGE, PLAY_COUNT, 17, "第四十集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197783&page=17"));

        videoList.add(new Video(String.valueOf(ID + 28),
                "41集（超级地球）", IMAGE, PLAY_COUNT, 18, "第四十一集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197868&page=18"));

        videoList.add(new Video(String.valueOf(ID + 29),
                "42集（月球创造者之谜）", IMAGE, PLAY_COUNT, 19, "第四十二集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197991&page=19"));

        videoList.add(new Video(String.valueOf(ID + 30),
                "43集（年龄回退与时间旅行）", IMAGE, PLAY_COUNT, 20, "第四十三集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198094&page=20"));

        videoList.add(new Video(String.valueOf(ID + 31),
                "44集（恶意混淆信息中心）", IMAGE, PLAY_COUNT, 21, "第四十四集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198194&page=21"));

        videoList.add(new Video(String.valueOf(ID + 32),
                "45集（上帝之音技术）", IMAGE, PLAY_COUNT, 22, "第四十五集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198306&page=22"));

        videoList.add(new Video(String.valueOf(ID + 33),
                "46集（黑暗舰队）", IMAGE, PLAY_COUNT, 23, "第四十六集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198405&page=23"));

        videoList.add(new Video(String.valueOf(ID + 34),
                "47集（观众提问part 3）", IMAGE, PLAY_COUNT, 24, "第四十七集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198474&page=24"));

        videoList.add(new Video(String.valueOf(ID + 35),
                "48集（地底最新报道）", IMAGE, PLAY_COUNT, 25, "第四十八集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198563&page=25"));

        videoList.add(new Video(String.valueOf(ID + 36),
                "49集（人格变形项目）", IMAGE, PLAY_COUNT, 26, "第四十九集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198650&page=26"));

        videoList.add(new Video(String.valueOf(ID + 37),
                "50集（地球联盟）", IMAGE, PLAY_COUNT, 27, "第五十集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198743&page=27"));

        videoList.add(new Video(String.valueOf(ID + 38),
                "51集（观众提问part 4）", IMAGE, PLAY_COUNT, 28, "第五十一集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198850&page=28"));

        videoList.add(new Video(String.valueOf(ID + 39),
                "52集（天体时间线）", IMAGE, PLAY_COUNT, 29, "第五十二集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198944&page=29"));

        videoList.add(new Video(String.valueOf(ID + 40),
                "53集（遥视与远程影响）", IMAGE, PLAY_COUNT, 30, "第五十三集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199007&page=30"));

        videoList.add(new Video(String.valueOf(ID + 41),
                "54集（古代艺术中的蓝鸟人和球体）", IMAGE, PLAY_COUNT, 31, "第五十四集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199103&page=31"));

        videoList.add(new Video(String.valueOf(ID + 42),
                "55集（扬升中的共生关系）", IMAGE, PLAY_COUNT, 32, "第五十五集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199200&page=32"));

        videoList.add(new Video(String.valueOf(ID + 43),
                "56集（灵性提升与科技的对抗）", IMAGE, PLAY_COUNT, 33, "第五十六集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199303&page=33"));

        videoList.add(new Video(String.valueOf(ID + 44),
                "57集（等离子生物与以太体）", IMAGE, PLAY_COUNT, 34, "第五十七集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199412&page=34"));

        videoList.add(new Video(String.valueOf(ID + 45),
                "58集（隐性威胁和公开披露）", IMAGE, PLAY_COUNT, 35, "第五十八集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199492&page=35"));

        videoList.add(new Video(String.valueOf(ID + 46),
                "59集（从金星到南极）", IMAGE, PLAY_COUNT, 36, "第五十九集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199671&page=36"));

        videoList.add(new Video(String.valueOf(ID + 47),
                "60集（周年特辑）", IMAGE, PLAY_COUNT, 37, "第六十集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199699&page=37"));

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
