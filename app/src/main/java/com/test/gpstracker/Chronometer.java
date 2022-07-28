package com.test.gpstracker;

import android.content.Context;

public class Chronometer implements Runnable{

    public static final long MILLIS_TO_MIN  = 1000 * 60;
    public static final long MILLIS_TO_HOUR = 60 * MILLIS_TO_MIN;

    private Context mContext;
    private long mStartTime;

    private boolean isRunning;

    public Chronometer(Context mContext) {
        this.mContext = mContext;
    }

    public void startChrono(){
        mStartTime = System.currentTimeMillis();
        isRunning = true;
    }

    public void stopChrono(){
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning){
            long since = System.currentTimeMillis() - mStartTime;

            int millis = (int) since % 1000;
            int seconds = (int) ((since / 1000) % 60);
            int minutes = (int) ((since / MILLIS_TO_MIN) % 60);
            int hours = (int) ((since / MILLIS_TO_HOUR) % 24);

            ((MainActivity)mContext).updateTimerText(String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, millis ));

        }
    }
}
