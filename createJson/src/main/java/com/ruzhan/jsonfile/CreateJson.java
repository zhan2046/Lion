package com.ruzhan.jsonfile;

import java.io.File;

public class CreateJson {

    private static final String MOVIE_LIST = "E:\\project\\Lion\\api\\movie\\list";

    public static void main(String[] args) throws Exception {
        System.out.println("test json file");

        File file = new File(MOVIE_LIST);
        boolean isExist = file.exists();
        System.out.println("MOVIE_LIST isExist:" + isExist);
        if (!isExist) {
            file.createNewFile();
        }


    }
}
