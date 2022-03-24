package com.bcqs.jetpack_room_java.viewmodel;

import java.util.Timer;
import java.util.TimerTask;

import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {

    private Timer mTimer;
    private int currentCount;

    private OnTimerChangedListener onTimerChangedListener;


    public int getCurrentCount(){
        return currentCount;
    }

    public void setCurrentCount(int current){
        currentCount = current;
    }

    public void startTiming() {
        if (mTimer == null) {
            mTimer = new Timer();
            currentCount = 0;
            mTimer.schedule(timerTask, 1000,1000);
        }
    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            currentCount++;
            if (onTimerChangedListener != null) {
                onTimerChangedListener.onChanged(currentCount);
            }
        }
    };

    @Override
    protected void onCleared() {
        super.onCleared();
        mTimer.cancel();
    }


    public void setOnTimerChangedListener(OnTimerChangedListener onTimerChangedListener) {
        this.onTimerChangedListener = onTimerChangedListener;
    }

    public interface OnTimerChangedListener {
        void onChanged(int count);
    }
}
