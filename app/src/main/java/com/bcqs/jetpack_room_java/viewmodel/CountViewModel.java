package com.bcqs.jetpack_room_java.viewmodel;

import java.util.Timer;
import java.util.TimerTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {

    private Timer mTimer;
    private int currentCount;

    private MutableLiveData<Integer> currentData = new MutableLiveData<>();


    public LiveData<Integer> getCurrentCount() {
        return currentData;
    }

    public void setCurrentCount(int current) {
        currentCount = current;
        currentData.postValue(currentCount);
    }

    public void startTiming() {
        if (mTimer == null) {
            mTimer = new Timer();
            currentCount = 0;
            currentData.setValue(currentCount);
            mTimer.schedule(timerTask, 1000, 1000);
        }
    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            currentCount +=1;
            currentData.postValue(currentCount);
        }
    };

    @Override
    protected void onCleared() {
        super.onCleared();
        mTimer.cancel();
    }
}
