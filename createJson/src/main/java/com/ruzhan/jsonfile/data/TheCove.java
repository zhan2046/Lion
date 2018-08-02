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
public class TheCove {

    private static final int ID = 4603;
    private static final String PLAY_COUNT = "1";

    private static final String TITLE = "海豚湾 The Cove";
    private static final String TAG = "自然·历史·纪录片";

    private static final String IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-cove.jpg";

    private static final String DESC = "本片荣获2010年第82届奥斯卡金像奖最佳纪录长片奖。";

    public static final Movie movie = new Movie();
    public static final MovieDetail movieDetail = new MovieDetail();

    private static final List<Introduce> introduceList = new ArrayList<>();
    private static final List<Video> videoList = new ArrayList<>();

    static {
        introduceList.add(new Introduce(Introduce.TEXT,
                DESC, ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-cove01.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "日本和歌山县太地，是一个景色优美的小渔村，然而这里却常年上演着惨无人道的一幕。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "每年，数以万计的海豚经过这片海域，他们的旅程却在太地戛然而止。", ""));

        introduceList.add(new Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-cove02.jpg"));

        introduceList.add(new Introduce(Introduce.TEXT,
                "渔民们将海豚驱赶到靠近岸边的一个地方，来自世界各地的海豚训练师挑选合适的对象，剩下的大批海豚则被渔民毫无理由地赶尽杀绝。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "这些屠杀，这些罪行，因为种种利益而被政府和相关组织所隐瞒。 ", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "理查德•贝瑞（Richard O’Barry）年轻时曾是一名海豚训练师，他所参与拍摄电影《海豚的故事》备受欢迎。但是，一头海豚的死让理查德的心灵受到强烈的震撼。", ""));

        introduceList.add(new Introduce(Introduce.TEXT,
                "从此，他致力于拯救海豚的活动。不顾当地政府和村民百般阻挠，他和他的摄影团队想方设法潜入太地的海豚屠杀场，只为将罪行公之于众，拯救人类可爱的朋友…… ", ""));

        videoList.add(new Video(String.valueOf(ID + 11),
                "海豚湾【中英字幕】", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=14889162&page=1"));

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
