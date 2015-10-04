package com.example.g0294.a8_1_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private String TAG = "MyService";
    private MyBinder myBinder = new MyBinder();

    public MyService() {
    }

    @Override
    public boolean onUnbind(Intent intent) {
        MainActivity.updateLog(TAG + " ----> onUnbind()");
        Log.d(TAG, "Run onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        MainActivity.updateLog(TAG + " ----> onRebind()");
        Log.d(TAG, "Run onRebind()");
        super.onRebind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        MainActivity.updateLog(TAG + " ----> onBind()");
        Log.d(TAG, "Run onBind()");
        return myBinder;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MainActivity.updateLog(TAG + " ----> onStartCommand()");
        Log.d(TAG, "Run onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity.updateLog(TAG + " ----> onDestroy()");
        Log.d(TAG, "Run onDestroy()");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MainActivity.updateLog(TAG + " ----> onCreate()");
        Log.d(TAG, "Run onCreate()");
    }

    class MyBinder extends Binder {
        public void startDownload() {
            MainActivity.updateLog(TAG + " ----> startDownload()");
            Log.d(TAG, "Run startDownload()");
        }
    }
}
