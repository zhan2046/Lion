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
public class OnTheRoad {

    private static final int ID = 503;
    private static final String PLAY_COUNT = "11";

    private static final String TITLE = "侣行·《张梁记》";
    private static final String TAG = "人物·探险·旅游";

    private static final String IMAGE = "http://n.sinaimg.cn/sinacn/20170817/1b58-fykcypp8287391.jpg";

    private static final String DESC = "《侣行》（英语：ON THE ROAD）是中国视频网站联合张昕宇（绰号“270”）、梁红打造的一档网络自制户外真人秀节目，共制作3季。节目通过将张昕宇、梁红等人的旅行经历拍摄成视频制作而成。《侣行》第一季于2013年6月13日在正式开播，三个月即突破1亿次播放量。第二季于2013年年底开播，总播放量超过8000万。第三季于2015年6月25日在开播。2014年3月24日至31日，《侣行》剧场版登陆央视一套。2017年4月29日，2016年推出的《我们的侣行》。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));
        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "http://img3.utuku.china.com/650x0/ent/20170531/b6733a95-071f-4db9-9451-f5d366691070.jpg"));
        introduceList.add(new Introduce(Introduce.TEXT,
                "2016年5月24日，与汽车之家合作的《张梁记》在汽车之家“优创+”平台独家开播。2016年11月4日，张昕宇、梁红在“腾讯视频V视界大会”上宣布将与环宇传媒合作推出真人秀《我们的侣行》第一季，张昕宇、梁红将自驾飞机，跨越5大洲、3大洋、23国、航程8万公里，实现中国人首次五大洲环球飞行、中国飞机首次飞越南极点。2017年8月18日，全球首档卫星直播户外探索真人秀《侣行·卫星直播探世界》携手熊猫直播开播。", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "第一集：再出发 时隔八年重回5·12地震遗址", IMAGE, PLAY_COUNT, "1",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=1"));
        videoList.add(new Video(String.valueOf(ID + 12),
                "第二集：西部慢调之初涉高原", IMAGE, PLAY_COUNT, "2",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=2"));
        videoList.add(new Video(String.valueOf(ID + 13),
                "第三集：海拔5231米胜利会师", IMAGE, PLAY_COUNT, "3",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=3"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "第四集：深入无人区，夜宿羌塘", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=4"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "第五集：可可西里的守护者", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=5"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "第六集：可可西里祭英魂！", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=6"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "第七集：无人区惊现非法闯入者", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=7"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "第八集：梦圆罗布泊", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=8"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "9、番外篇—出发前的准备", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=9"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "10、番外篇二无人区越野技巧", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=10"));
        videoList.add(new Video(String.valueOf(ID + 14),
                "11、“路，一直在”——《张梁记》粉丝见面会", IMAGE, PLAY_COUNT, "4",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=11"));


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
