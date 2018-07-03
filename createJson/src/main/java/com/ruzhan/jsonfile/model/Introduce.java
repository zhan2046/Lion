package com.ruzhan.jsonfile.model;

/**
 * Created by ruzhan123 on 2018/7/3.
 */
public class Introduce {

    public static final int TEXT = 1000;
    public static final int IMAGE = 1001;

    public int type;
    public String text;
    public String image;

    public Introduce(int type, String text, String image) {
        this.type = type;
        this.text = text;
        this.image = image;
    }
}
