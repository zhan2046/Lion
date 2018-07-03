package com.ruzhan.jsonfile.model;

import java.util.List;

/**
 * Created by ruzhan123 on 2018/7/3.
 */
public class MovieDetail {

    public String id;
    public String movieId;
    public String title;
    public String tag;
    public String desc;
    public String image;

    public List<Introduce> introduces;
    public List<Video> videos;
}
