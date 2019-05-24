package com.ruzhan.lion.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RequestStatus<T> {

    public static final int REFRESH = 1000;
    public static final int LOAD_MORE = 1001;

    public static final int START_PAGE = 1;
    public static final int PAGE_SIZE = 60;

    @IntDef({REFRESH, LOAD_MORE})
    @Retention(RetentionPolicy.SOURCE)
    @interface RefreshStatus {
    }

    @RefreshStatus
    public int refreshStatus;

    public boolean isNetworkRequest;

    public int page;

    public T data;

    public void setPage(@RefreshStatus int refreshStatus) {
        page = refreshStatus == RequestStatus.REFRESH ? START_PAGE : ++page;
    }
}
