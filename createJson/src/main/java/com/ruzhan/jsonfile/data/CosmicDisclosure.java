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
public class CosmicDisclosure {

    private static final int ID = 2103;
    private static final String PLAY_COUNT = "23";

    private static final String TITLE = "揭露宇宙 1-23集";
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
                "1、给人类的信息", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=22982253&cid=38205008&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、首次接触", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=22982253&cid=38205009&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、月球司令部", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=22982253&cid=38205102&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、考察船上的生活", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=22982253&cid=38205248&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、我们是一体", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=22982253&cid=38205354&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、沉睡巨人", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=22982253&cid=38205509&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、火星基地", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=22982253&cid=38205581&page=7"));

        videoList.add(new Video(String.valueOf(ID + 18),
                "8、全球联盟", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=22982253&cid=38205734&page=8"));

        videoList.add(new Video(String.valueOf(ID + 19),
                "9、电子太阳", IMAGE, PLAY_COUNT, 9, "第九集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38147489&page=1"));

        videoList.add(new Video(String.valueOf(ID + 20),
                "10、松果体觉醒", IMAGE, PLAY_COUNT, 10, "第十集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38147508&page=2"));

        videoList.add(new Video(String.valueOf(ID + 21),
                "11、人类意识潜能", IMAGE, PLAY_COUNT, 11, "第十一集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38147560&page=3"));

        videoList.add(new Video(String.valueOf(ID + 22),
                "12、传送口-宇宙网", IMAGE, PLAY_COUNT, 12, "第十二集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38147722&page=4"));

        videoList.add(new Video(String.valueOf(ID + 23),
                "13、传送口-驾驭时间", IMAGE, PLAY_COUNT, 13, "第十三集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38147768&page=5"));

        videoList.add(new Video(String.valueOf(ID + 24),
                "14、传送口-平行地球", IMAGE, PLAY_COUNT, 14, "第十四集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38147906&page=6"));

        videoList.add(new Video(String.valueOf(ID + 25),
                "15、已经接触", IMAGE, PLAY_COUNT, 15, "第十五集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38147944&page=7"));

        videoList.add(new Video(String.valueOf(ID + 26),
                "16、地底人-深入边界", IMAGE, PLAY_COUNT, 16, "第十六集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38147990&page=8"));

        videoList.add(new Video(String.valueOf(ID + 27),
                "17、特别报道-冈萨雷斯之谜", IMAGE, PLAY_COUNT, 17, "第十七集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38148033&page=9"));

        videoList.add(new Video(String.valueOf(ID + 28),
                "18、开始分裂", IMAGE, PLAY_COUNT, 18, "第十八集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38148076&page=10"));

        videoList.add(new Video(String.valueOf(ID + 29),
                "19、遗落科技的袭击者", IMAGE, PLAY_COUNT, 19, "第十九集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38148109&page=11"));

        videoList.add(new Video(String.valueOf(ID + 30),
                "20、我们并不孤独", IMAGE, PLAY_COUNT, 20, "第二十集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38148150&page=12"));

        videoList.add(new Video(String.valueOf(ID + 31),
                "21、挖掘火星", IMAGE, PLAY_COUNT, 21, "第二十一集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38148177&page=13"));

        videoList.add(new Video(String.valueOf(ID + 32),
                "22、发现火星生命繁殖体", IMAGE, PLAY_COUNT, 22, "第二十二集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38148219&page=14"));

        videoList.add(new Video(String.valueOf(ID + 33),
                "23、殖民火星", IMAGE, PLAY_COUNT, 23, "第二十三集",
                "http://player.bilibili.com/player.html?aid=22951096&cid=38148300&page=15"));

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
