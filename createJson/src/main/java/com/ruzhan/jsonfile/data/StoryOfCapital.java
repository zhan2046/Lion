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
public class StoryOfCapital {

    private static final int ID = 5403;
    private static final String PLAY_COUNT = "60";

    private static final String TITLE = "资本的故事";
    private static final String TAG = "社会·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/story-of-capital.jpg";

    private static final String DESC = "以四百多年来世界经济的发展历程为背景，以当下的视角剖析资本在市场经济中的作用和地位，为中国经济下一步的深化改革和发展提供借鉴。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/story-of-capital01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "由中央电视台财经频道和康美药业股份有限公司联合制作的系列微纪录片《资本的故事》于近期开始在中央电视台财经频道播出。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/story-of-capital02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "《资本的故事》是中央电视台专业财经短片的一次有益尝试，它以“播出季”的方式滚动制作和播出。第一播出季为20集，每集八分钟。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "讲述了从股票的诞生到次贷危机四百年间的20个精彩的资本故事。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "1、第1季第1集：股份的力量", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=19258366&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "2、第1季第2集：泡沫的诱惑", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=19258366&page=2"));

        videoList.add(new Video(String.valueOf(ID + 13),
                "3、第1季第3集：南海骗局", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=19258366&page=3"));

        videoList.add(new Video(String.valueOf(ID + 14),
                "4、第1季第4集：汉密尔顿的旋转门", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=19258366&page=4"));

        videoList.add(new Video(String.valueOf(ID + 15),
                "5、第1季第5集：梧桐树下的承诺", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=19258366&page=5"));

        videoList.add(new Video(String.valueOf(ID + 16),
                "6、第1季第6集：给风险定价", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=19258366&page=6"));

        videoList.add(new Video(String.valueOf(ID + 17),
                "7、第1季第7集：注水的股票", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=19258366&page=7"));

        videoList.add(new Video(String.valueOf(ID + 18),
                "8、第1季第8集：巨人的诞生", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=19258366&page=8"));

        videoList.add(new Video(String.valueOf(ID + 19),
                "9、第1季第9集：镀金的美元", IMAGE, PLAY_COUNT, 9, "第九集",
                "http://player.bilibili.com/player.html?aid=19258366&page=9"));

        videoList.add(new Video(String.valueOf(ID + 20),
                "10、第1季第10集：风险的价值", IMAGE, PLAY_COUNT, 10, "第十集",
                "http://player.bilibili.com/player.html?aid=19258366&page=10"));

        videoList.add(new Video(String.valueOf(ID + 21),
                "11、第1季第11集：日本泡沫", IMAGE, PLAY_COUNT, 11, "第十一集",
                "http://player.bilibili.com/player.html?aid=19258366&page=11"));

        videoList.add(new Video(String.valueOf(ID + 22),
                "12、第1季第12集：八百伴倒闭", IMAGE, PLAY_COUNT, 12, "第十二集",
                "http://player.bilibili.com/player.html?aid=19258366&page=12"));

        videoList.add(new Video(String.valueOf(ID + 23),
                "13、第1季第13集：门口的野蛮人", IMAGE, PLAY_COUNT, 13, "第十三集",
                "http://player.bilibili.com/player.html?aid=19258366&page=13"));

        videoList.add(new Video(String.valueOf(ID + 24),
                "14、资本的故事第1季第14集：英镑狙击战", IMAGE, PLAY_COUNT, 14, "第十四集",
                "http://player.bilibili.com/player.html?aid=19258366&page=14"));

        videoList.add(new Video(String.valueOf(ID + 25),
                "15、资本的故事第1季第15集：破碎的梦之队", IMAGE, PLAY_COUNT, 15, "第十五集",
                "http://player.bilibili.com/player.html?aid=19258366&page=15"));

        videoList.add(new Video(String.valueOf(ID + 26),
                "16、资本的故事第1季第16集：创新的温床", IMAGE, PLAY_COUNT, 16, "第十六集",
                "http://player.bilibili.com/player.html?aid=19258366&page=16"));

        videoList.add(new Video(String.valueOf(ID + 27),
                "17、资本的故事第1季第17集：峭壁边缘的华尔街", IMAGE, PLAY_COUNT, 17, "第十七集",
                "http://player.bilibili.com/player.html?aid=19258366&page=17"));

        videoList.add(new Video(String.valueOf(ID + 28),
                "18、资本的故事第1季第18集：华尔街的3A游戏", IMAGE, PLAY_COUNT, 18, "第十八集",
                "http://player.bilibili.com/player.html?aid=19258366&page=18"));

        videoList.add(new Video(String.valueOf(ID + 29),
                "19、资本的故事第1季第19集：麦道夫骗局", IMAGE, PLAY_COUNT, 19, "第十九集",
                "http://player.bilibili.com/player.html?aid=19258366&page=19"));

        videoList.add(new Video(String.valueOf(ID + 30),
                "20、资本的故事第1季第20集：神的午餐", IMAGE, PLAY_COUNT, 20, "第二十集",
                "http://player.bilibili.com/player.html?aid=19258366&page=20"));

        videoList.add(new Video(String.valueOf(ID + 31),
                "21、资本的故事第2季第1集：针线街的老妇人", IMAGE, PLAY_COUNT, 21, "第二十一集",
                "http://player.bilibili.com/player.html?aid=19258366&page=21"));

        videoList.add(new Video(String.valueOf(ID + 32),
                "22、资本的故事第2季第2集：纸币的狂欢", IMAGE, PLAY_COUNT, 22, "第二十二集",
                "http://player.bilibili.com/player.html?aid=19258366&page=22"));

        videoList.add(new Video(String.valueOf(ID + 33),
                "23、资本的故事第2季第3集：金色的道钉", IMAGE, PLAY_COUNT, 23, "第二十三集",
                "http://player.bilibili.com/player.html?aid=19258366&page=23"));

        videoList.add(new Video(String.valueOf(ID + 34),
                "24、资本的故事第2季第4集：黄金阴谋", IMAGE, PLAY_COUNT, 24, "第二十四集",
                "http://player.bilibili.com/player.html?aid=19258366&page=24"));

        videoList.add(new Video(String.valueOf(ID + 35),
                "25、资本的故事第2季第5集：垄断者", IMAGE, PLAY_COUNT, 25, "第二十五集",
                "http://player.bilibili.com/player.html?aid=19258366&page=25"));

        videoList.add(new Video(String.valueOf(ID + 36),
                "26、资本的故事第2季第6集：瓶装的财富", IMAGE, PLAY_COUNT, 26, "第二十六集",
                "http://player.bilibili.com/player.html?aid=19258366&page=26"));

        videoList.add(new Video(String.valueOf(ID + 37),
                "27、资本的故事第2季第7集：超级工厂", IMAGE, PLAY_COUNT, 27, "第二十七集",
                "http://player.bilibili.com/player.html?aid=19258366&page=27"));

        videoList.add(new Video(String.valueOf(ID + 38),
                "28、资本的故事第2季第8集：火柴的熄灭", IMAGE, PLAY_COUNT, 28, "第二十八集",
                "http://player.bilibili.com/player.html?aid=19258366&page=28"));

        videoList.add(new Video(String.valueOf(ID + 39),
                "29、资本的故事第2季第9集：米奇鼠的新家园", IMAGE, PLAY_COUNT, 29, "第二十九集",
                "http://player.bilibili.com/player.html?aid=19258366&page=29"));

        videoList.add(new Video(String.valueOf(ID + 40),
                "30、资本的故事第2季第10集：口袋里的银行", IMAGE, PLAY_COUNT, 30, "第三十集",
                "http://player.bilibili.com/player.html?aid=19258366&page=30"));

        videoList.add(new Video(String.valueOf(ID + 41),
                "31、资本的故事第2季第11集：拯救宝马", IMAGE, PLAY_COUNT, 31, "第三十一集",
                "http://player.bilibili.com/player.html?aid=19258366&page=31"));

        videoList.add(new Video(String.valueOf(ID + 42),
                "32、资本的故事第2季第12集：二十四小时的承诺", IMAGE, PLAY_COUNT, 32, "第三十二集",
                "http://player.bilibili.com/player.html?aid=19258366&page=32"));

        videoList.add(new Video(String.valueOf(ID + 43),
                "33、资本的故事第2季第13集：苹果红了", IMAGE, PLAY_COUNT, 33, "第三十三集",
                "http://player.bilibili.com/player.html?aid=19258366&page=33"));

        videoList.add(new Video(String.valueOf(ID + 44),
                "34、资本的故事第2季第14集：方寸间的胜利", IMAGE, PLAY_COUNT, 34, "第三十四集",
                "http://player.bilibili.com/player.html?aid=19258366&page=34"));

        videoList.add(new Video(String.valueOf(ID + 45),
                "35、资本的故事第2季第15集：惊天的赌局", IMAGE, PLAY_COUNT, 35, "第三十五集",
                "http://player.bilibili.com/player.html?aid=19258366&page=35"));

        videoList.add(new Video(String.valueOf(ID + 46),
                "36、资本的故事第2季第16集：云端的竞争", IMAGE, PLAY_COUNT, 36, "第三十六集",
                "http://player.bilibili.com/player.html?aid=19258366&page=36"));

        videoList.add(new Video(String.valueOf(ID + 47),
                "37、资本的故事第2季第17集：世通的资本游戏", IMAGE, PLAY_COUNT, 37, "第三十七集",
                "http://player.bilibili.com/player.html?aid=19258366&page=37"));

        videoList.add(new Video(String.valueOf(ID + 48),
                "38、资本的故事第2季第18集：世纪大并购", IMAGE, PLAY_COUNT, 38, "第三十八集",
                "http://player.bilibili.com/player.html?aid=19258366&page=38"));

        videoList.add(new Video(String.valueOf(ID + 49),
                "39、资本的故事第2季第19集：星空之战", IMAGE, PLAY_COUNT, 39, "第三十九集",
                "http://player.bilibili.com/player.html?aid=19258366&page=39"));

        videoList.add(new Video(String.valueOf(ID + 50),
                "40、资本的故事第2季第20集：雅虎保卫战", IMAGE, PLAY_COUNT, 40, "第四十集",
                "http://player.bilibili.com/player.html?aid=19258366&page=40"));

        videoList.add(new Video(String.valueOf(ID + 51),
                "41、第三季 第一集 华尔街的缔造者", IMAGE, PLAY_COUNT, 41, "第四十一集",
                "http://player.bilibili.com/player.html?aid=19258366&page=41"));

        videoList.add(new Video(String.valueOf(ID + 52),
                "42、第三季 第二集 金融城的新主人", IMAGE, PLAY_COUNT, 42, "第四十二集",
                "http://player.bilibili.com/player.html?aid=19258366&page=42"));

        videoList.add(new Video(String.valueOf(ID + 53),
                "43、第三季 第三集 票号鼻祖", IMAGE, PLAY_COUNT, 43, "第四十三集",
                "http://player.bilibili.com/player.html?aid=19258366&page=43"));

        videoList.add(new Video(String.valueOf(ID + 54),
                "44、第三季 第四集 股市的测量者", IMAGE, PLAY_COUNT, 44, "第四十四集",
                "http://player.bilibili.com/player.html?aid=19258366&page=44"));

        videoList.add(new Video(String.valueOf(ID + 55),
                "45、第三季 第五集 强盗资本家", IMAGE, PLAY_COUNT, 45, "第四十五集",
                "http://player.bilibili.com/player.html?aid=19258366&page=45"));

        videoList.add(new Video(String.valueOf(ID + 56),
                "46、第三季 第六集 华尔街的拿破仑", IMAGE, PLAY_COUNT, 46, "第四十六集",
                "http://player.bilibili.com/player.html?aid=19258366&page=46"));

        videoList.add(new Video(String.valueOf(ID + 57),
                "47、第三季 第七集 嫁接资本的天才", IMAGE, PLAY_COUNT, 47, "第四十七集",
                "http://player.bilibili.com/player.html?aid=19258366&page=47"));

        videoList.add(new Video(String.valueOf(ID + 58),
                "48、第三季 第八集 穷人的银行家", IMAGE, PLAY_COUNT, 48, "第四十八集",
                "http://player.bilibili.com/player.html?aid=19258366&page=48"));

        videoList.add(new Video(String.valueOf(ID + 59),
                "49、第三季 第九集 小生意 大银行", IMAGE, PLAY_COUNT, 49, "第四十九集",
                "http://player.bilibili.com/player.html?aid=19258366&page=49"));

        videoList.add(new Video(String.valueOf(ID + 60),
                "50、第三季 第十集 看得见的手", IMAGE, PLAY_COUNT, 50, "第五十集",
                "http://player.bilibili.com/player.html?aid=19258366&page=50"));

        videoList.add(new Video(String.valueOf(ID + 61),
                "51、第三季 第十一集 股神的领路人", IMAGE, PLAY_COUNT, 51, "第五十一集",
                "http://player.bilibili.com/player.html?aid=19258366&page=51"));

        videoList.add(new Video(String.valueOf(ID + 62),
                "52、第三季 第十二集 最有钱的抠老头", IMAGE, PLAY_COUNT, 52, "第五十二集",
                "http://player.bilibili.com/player.html?aid=19258366&page=52"));

        videoList.add(new Video(String.valueOf(ID + 63),
                "53、第三季 第十三集 欧债设计师", IMAGE, PLAY_COUNT, 53, "第五十三集",
                "http://player.bilibili.com/player.html?aid=19258366&page=53"));

        videoList.add(new Video(String.valueOf(ID + 64),
                "54、第三季 第十四集 奥马哈的神", IMAGE, PLAY_COUNT, 54, "第五十四集",
                "http://player.bilibili.com/player.html?aid=19258366&page=54"));

        videoList.add(new Video(String.valueOf(ID + 65),
                "55、第三季 第十五集 资本之鳄", IMAGE, PLAY_COUNT, 55, "第五十五集",
                "http://player.bilibili.com/player.html?aid=19258366&page=55"));

        videoList.add(new Video(String.valueOf(ID + 66),
                "56、第三季 第十六集 金融艺术家", IMAGE, PLAY_COUNT, 56, "第五十六集",
                "http://player.bilibili.com/player.html?aid=19258366&page=56"));

        videoList.add(new Video(String.valueOf(ID + 67),
                "57、第三季 第十七集 金融期货之父", IMAGE, PLAY_COUNT, 57, "第五十七集",
                "http://player.bilibili.com/player.html?aid=19258366&page=57"));

        videoList.add(new Video(String.valueOf(ID + 68),
                "58、第三季 第十八集 企业掠夺者", IMAGE, PLAY_COUNT, 58, "第五十八集",
                "http://player.bilibili.com/player.html?aid=19258366&page=58"));

        videoList.add(new Video(String.valueOf(ID + 69),
                "59、第三季 第十九集 垃圾债券之王", IMAGE, PLAY_COUNT, 59, "第五十九集",
                "http://player.bilibili.com/player.html?aid=19258366&page=59"));

        videoList.add(new Video(String.valueOf(ID + 70),
                "60、第三季 第二十集 硅谷的资本慧眼", IMAGE, PLAY_COUNT, 60, "第六十集",
                "http://player.bilibili.com/player.html?aid=19258366&page=60"));


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
