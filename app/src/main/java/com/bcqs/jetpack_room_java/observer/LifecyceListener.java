package com.bcqs.jetpack_room_java.observer;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LifecyceListener implements LifecycleObserver {



    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void doOnCreate(){
        Log.d("wg","doOnCreate()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void doOnStart(){
        Log.d("wg","doOnStart()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void doOnResume(){
        Log.d("wg","doOnResume()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void doOnStop(){
        Log.d("wg","doOnStop()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void doOnDestroy(){
        Log.d("wg","doOnDestroy()");
    }


}
