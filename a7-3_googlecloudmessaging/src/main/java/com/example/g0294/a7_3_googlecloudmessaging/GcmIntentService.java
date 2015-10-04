package com.example.g0294.a7_3_googlecloudmessaging;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GcmIntentService extends IntentService {
    public static final int NOTIFICATION_ID = 1;

    public GcmIntentService() {
        super("GcmIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (!extras.isEmpty()) {
            try {
                //分析GCM推送的JSON資料
                JSONTokener jsonTokener = new JSONTokener(extras.toString().replaceAll("Bundle", ""));
                JSONArray jsons = (JSONArray) jsonTokener.nextValue();
                JSONObject jsonObject = (JSONObject) jsons.get(0);
                //取得message屬性的內容
                sendNotification(jsonObject.getString("message"));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    private void sendNotification(String msg) {
        //設定點選推播要啟動的Activity
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, GCMActivity.class), 0);
        //設定新通知
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setTicker("new message");
        mBuilder.setContentTitle(msg);
        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(contentIntent);
        //顯示通知
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}
