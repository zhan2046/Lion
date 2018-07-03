package com.ruzhan.jsonfile.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruzhan123 on 2018/7/3.
 */
public class Movie {

    private static final int MOVIE_INIT_ID = 1000;

    public String id;
    public String title;
    public String tag;
    public String desc;
    public String picUrl;

    public static List<Movie> getMovieList() {
        // movie list
        List<Movie> list = new ArrayList<>();

        // id plus
        int idPlus = MOVIE_INIT_ID;

        // HumanRace, Get Off Your Knees (The Lion Sleeps No More)
        idPlus++;
        list.add(getTheLionSleepsNoMore("" + idPlus));

        return list;
    }

    public static Movie getTheLionSleepsNoMore(String id) {
        Movie movie = new Movie();
        movie.id = id;
        movie.title = "大卫•艾克《雄狮醒来》";
        movie.tag = "演讲·公开课";
        movie.desc = "大卫·沃恩·艾克（英语：David Vaughan Icke ，1952年4月29日-），" +
                "英国作家、公共演说家、前足球员与体育职业解说员。他提出一种关于全球政治的阴谋论，并将它详细地写了出来。";
        movie.picUrl = "http://neilhague.com/wp-content/uploads/2016/03/Christ-Lion2-631x450.jpg";
        return movie;
    }
}
