package com.ruzhan.jsonfile.model;

/**
 * Created by ruzhan123 on 2018/7/3.
 */
public class Video {

    public String id;
    public String title;
    public String image;
    public String playCount;
    public int playNumber;
    public String playNumberDesc;
    public String playWebUrl;

    public String videoUrl;

    public Video(String id, String title, String image, String playCount, int playNumber,
                 String playNumberDesc, String playWebUrl) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.playCount = playCount;
        this.playNumber = playNumber;
        this.playNumberDesc = playNumberDesc;
        this.playWebUrl = playWebUrl;
    }

    public Video(String id, String title, String image, String playCount, int playNumber,
                 String playNumberDesc, String playWebUrl, String videoUrl) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.playCount = playCount;
        this.playNumber = playNumber;
        this.playNumberDesc = playNumberDesc;
        this.playWebUrl = playWebUrl;
        this.videoUrl = videoUrl;
    }
}
