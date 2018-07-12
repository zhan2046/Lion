package com.ruzhan.lion.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ruzhan123 on 2018/7/12.
 */
public class RequestStatus<T> {

    public static final int LOADING = 0;
    public static final int LOADED = 1;

    public static final int REFRESH = 2;
    public static final int LOAD_MORE = 3;

    public static final int START_PAGE = 1;
    public static final int PAGE_SIZE = 20;

    @IntDef({LOADING, LOADED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStatus {
    }

    @IntDef({REFRESH, LOAD_MORE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RefreshStatus {
    }

    @LoadStatus
    public int loadStatus;
    @RefreshStatus
    public int refreshStatus;

    public int page;

    public T data;

    public void setPage(@LoadStatus int refreshStatus) {
        page = refreshStatus == RequestStatus.REFRESH ? START_PAGE : ++page;
    }
}
