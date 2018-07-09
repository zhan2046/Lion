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
public class NikolaTesla {

    private static final int ID = 1603;
    private static final String PLAY_COUNT = "2";

    private static final String TITLE = "尼古拉·特斯拉";
    private static final String TAG = "科教·自然·神秘纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/nikola-tesla.jpg";

    private static final String DESC = "尼古拉·特斯拉，塞尔维亚裔美籍发明家，物理学家，机械工程师，电机工程师和未来学家。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/nikola-tesla01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "被认为是电力商业化的重要推动者，并因主要设计了现代交流电力系统而最为人知。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "在迈克尔·法拉第发现的电磁场理论的基础上，特斯拉在电磁场领域有着多项革命性的发明。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "他的多项相关的专利以及电磁学的理论研究工作是现代的无线通信和无线电的基石。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/nikola-tesla02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "在赢得著名的19世纪80年代的“电流战争”及在1894年成功进行短波无线通信试验之后，特斯拉被认为是当时美国最伟大的电机工程师之一。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "他的许多发现被认为是具有开创性的，是电机工程学的先驱。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "1891年，特斯拉在成功试验了把电力以无线能量传输的形式送到了目标用电器之后，致力于商业化的洲际电力无线输送，并且以此设想建造了半成品 - 沃登克里弗塔。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/nikola-tesla03.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "于20世纪30年代，特斯拉这时接近生命的尾声阶段。特斯拉一度变得深居简出，足不出户，独居于纽约市的Wyndham New Yorker Hotel3327房间之中，偶尔才会向新闻界发表一些不同寻常的声明。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "因为他举止怪异，特斯拉被普遍认为是“疯狂科学家”的原型。他对于金钱和法律事务之不在乎亦是其一生之致命伤。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "数家电子公司（今日美国电子业龙头的前身）联合派出一群能言善道的律师，夺走了他大部分的专利。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "1943年1月7日，特斯拉在穷困潦倒中过世。去世之后，特斯拉的成就并不太为当时的人所知，但是在20世纪90年代，他的公众名望出人意料地上演了王者归来。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/nikola-tesla04.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "撇开他在电磁学和工程上的成就，阴谋论作家Robert Lomas认为特斯拉对机器人、弹道学、信息学、核子物理学和理论物理学上等各种领域有贡献。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "许多他的成就已伴随着一些争议被应用，去支持着许多的非主流科学，如幽浮理论。Robert Lomas视他为“创造出二十世纪的人”。", ""));


        videoList.add(new Video(String.valueOf(ID + 11),
                "闪电的主人—尼古拉.特斯拉", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=290898&cid=460979&page=1"));

        videoList.add(new Video(String.valueOf(ID + 12),
                "【CCTV】科学“超人”尼古拉·特斯拉", IMAGE, PLAY_COUNT, 2, "电影",
                "http://player.bilibili.com/player.html?aid=10118671&cid=16719622&page=1"));


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
