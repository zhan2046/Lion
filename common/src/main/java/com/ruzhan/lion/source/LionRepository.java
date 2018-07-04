package com.ruzhan.lion.source;

import com.ruzhan.lion.api.LionApi;
import com.ruzhan.lion.api.LionClient;
import com.ruzhan.lion.model.HttpResult;
import com.ruzhan.lion.model.Movie;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ruzhan123 on 2018/7/4.
 */
public class LionRepository {

    private static LionRepository INSTANCE;

    private LionApi api;

    public LionRepository() {
        api = LionClient.get();
    }

    public static LionRepository get() {
        if (INSTANCE == null) {
            synchronized (LionRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LionRepository();
                }
            }
        }
        return INSTANCE;
    }

    public Single<HttpResult<List<Movie>>> getMovieList(String pageFileName) {
        return api.getMovieList(pageFileName).subscribeOn(Schedulers.io());
    }
}
