package com.ruzhan.jsonfile.model;

/**
 * Created by ruzhan123 on 2018/7/3.
 */
public class Video {

    public String id;
    public String title;
    public String image;
    public String playCount;
    public String playNumber;
    public String playWebUrl;

    public Video(String id, String title, String image, String playCount,
                 String playNumber, String playWebUrl) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.playCount = playCount;
        this.playNumber = playNumber;
        this.playWebUrl = playWebUrl;
    }
}
