package com.ruzhan.lion.rx;

import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;


public class Subscriber<T> implements Observer<T>, SingleObserver<T>,
    MaybeObserver<T>, CompletableObserver, org.reactivestreams.Subscriber<T> {

    private static final String TAG = "Subscriber";

    public static <T> Subscriber<? super T> create() {
        return new Subscriber<>();
    }

    Subscriber() {
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onSuccess(T t) {
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Integer.MAX_VALUE);
    }

    @Override
    public void onNext(T o) {
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, e.toString());
    }

    @Override
    public void onComplete() {
    }
}