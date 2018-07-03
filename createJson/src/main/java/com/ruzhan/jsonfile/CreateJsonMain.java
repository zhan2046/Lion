package com.ruzhan.jsonfile;

import com.google.gson.Gson;
import com.ruzhan.jsonfile.helper.MovieHelper;
import com.ruzhan.jsonfile.model.Movie;
import com.ruzhan.jsonfile.model.MovieDetail;

import java.util.List;
import java.util.Map;

public class CreateJsonMain {

    private static final String MOVIE_LIST = "E:\\project\\Lion\\json\\api\\movie";
    private static final String MOVIE_DETAIL = "E:\\project\\Lion\\json\\api\\movie\\detail";

    private static Gson gson = new Gson();

    public static void main(String[] args) {
        System.out.println("init json file...");
        System.out.println("=================================");

        System.out.println("1, create movie list json files");
        List<Movie> movieList = MovieHelper.getMovieList();
        Map<String, List<Movie>> movieMap = MovieHelper.getMovieMap(movieList);
        System.out.println("movieMap size:" + movieMap.size());
        MovieHelper.movieListToJsonFile(movieMap, MOVIE_LIST, gson);
        System.out.println("1, create movie list json files finish ... !!!");
        System.out.println("=================================");

        System.out.println("2, create movie detail json files");
        List<MovieDetail> detailList = MovieHelper.getMovieDetailList();
        MovieHelper.movieDetailListToJsonFile(detailList, MOVIE_DETAIL, gson);
        System.out.println("2, create movie detail json files finish ... !!!");
        System.out.println("=================================");


        System.out.println("json file create finish ... !!!");
    }
}
