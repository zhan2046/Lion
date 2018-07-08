package com.ruzhan.jsonfile.helper;

import com.google.gson.Gson;
import com.ruzhan.jsonfile.CreateJsonMain;
import com.ruzhan.jsonfile.data.AncientAliens;
import com.ruzhan.jsonfile.data.CredoMutwa;
import com.ruzhan.jsonfile.data.Human;
import com.ruzhan.jsonfile.data.KeJi;
import com.ruzhan.jsonfile.data.OnTheRoad;
import com.ruzhan.jsonfile.data.PunPun;
import com.ruzhan.jsonfile.data.TheLieWeLive;
import com.ruzhan.jsonfile.data.TheLionSleepsNoMore;
import com.ruzhan.jsonfile.data.TheOrionConspiracy;
import com.ruzhan.jsonfile.data.TheSecret;
import com.ruzhan.jsonfile.model.HttpResult;
import com.ruzhan.jsonfile.model.Movie;
import com.ruzhan.jsonfile.model.MovieDetail;
import com.ruzhan.jsonfile.utils.JsonFileIOUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ruzhan123 on 2018/7/3.
 */
public final class MovieHelper {

    private MovieHelper() {

    }

    public static void movieDetailListToJsonFile(List<MovieDetail> list,
                                                 String rootPath, Gson gson) {
        for (MovieDetail movieDetail : list) {
            String name = movieDetail.movieId.concat(CreateJsonMain.FILE_TYPE);
            String filePath = rootPath.concat("\\").concat(name);
            HttpResult<MovieDetail> httpResult = new HttpResult<>(CreateJsonMain.CODE_SUCCESS,
                    "", movieDetail);
            String fileJson = gson.toJson(httpResult);
            boolean isKeyPageSuccess = JsonFileIOUtils.writeFileFromString(filePath, fileJson);
            System.out.println("isKeyPageSuccess:" + isKeyPageSuccess + ", movieDetailListToJsonFile write !!!");
        }
    }

    public static void movieListToJsonFile(Map<String, List<Movie>> map, String rootPath, Gson gson) {
        Set<Map.Entry<String, List<Movie>>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, List<Movie>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Movie>> entry = iterator.next();
            String keyPage = entry.getKey();
            List<Movie> valueMovieList = entry.getValue();
            String filePath = rootPath.concat("\\").concat(keyPage).concat(CreateJsonMain.FILE_TYPE);
            HttpResult<List<Movie>> httpResult = new HttpResult<>(CreateJsonMain.CODE_SUCCESS,
                    "", valueMovieList);
            String fileJson = gson.toJson(httpResult);
            boolean isKeyPageSuccess = JsonFileIOUtils.writeFileFromString(filePath, fileJson);
            System.out.println("isKeyPageSuccess:" + isKeyPageSuccess + ", keyPage:" + keyPage);
        }
    }

    public static Map<String, List<Movie>> getMovieMap(List<Movie> list) {
        Map<String, List<Movie>> map = new HashMap<>();
        int page = 1;
        int pageCount = 20;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Movie> valueList = map.get(String.valueOf(page));
            if (valueList == null) {
                valueList = new ArrayList<>();
            }
            Movie movie = list.get(i);
            valueList.add(movie);
            map.put(String.valueOf(page), valueList);
            count++;

            if (count >= pageCount) {
                count = 0;
                page++;
            }
        }
        return map;
    }

    public static List<Movie> getMovieList() {
        List<Movie> list = new ArrayList<>();
        list.add(TheLionSleepsNoMore.movie);
        list.add(Human.movie);
        list.add(TheSecret.movie);
        list.add(AncientAliens.movie);
        list.add(CredoMutwa.movie);
        list.add(TheOrionConspiracy.movie);
        list.add(KeJi.movie);
        list.add(TheLieWeLive.movie);
        list.add(PunPun.movie);
        list.add(OnTheRoad.movie);
        return list;
    }

    public static List<MovieDetail> getMovieDetailList() {
        List<MovieDetail> list = new ArrayList<>();
        list.add(TheLionSleepsNoMore.movieDetail);
        list.add(Human.movieDetail);
        list.add(TheSecret.movieDetail);
        list.add(AncientAliens.movieDetail);
        list.add(CredoMutwa.movieDetail);
        list.add(TheOrionConspiracy.movieDetail);
        list.add(KeJi.movieDetail);
        list.add(TheLieWeLive.movieDetail);
        list.add(PunPun.movieDetail);
        list.add(OnTheRoad.movieDetail);
        return list;
    }
}
