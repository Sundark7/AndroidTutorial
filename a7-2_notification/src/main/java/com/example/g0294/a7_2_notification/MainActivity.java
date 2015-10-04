package com.example.g0294.a7_2_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findViewById(R.id.btn_basicNotify).setOnClickListener(new BtnListener());
        this.findViewById(R.id.btn_mutiNotify).setOnClickListener(new BtnListener());
        this.findViewById(R.id.btn_soundNotify).setOnClickListener(new BtnListener());
    }

    class BtnListener implements View.OnClickListener {
        int notifyID = 1; //通知識別碼
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); //取得通知服務
        Notification.Builder notification = new Notification.Builder(getApplicationContext());

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_basicNotify:
                    notification.setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("標題")
                            .setContentText("內容")
                            .setContentInfo("額外資訊");
                    notificationManager.notify(notifyID, notification.build());
                    break;
                case R.id.btn_mutiNotify:
                    notifyID++;
                    notification.setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("標題")
                            .setContentText("內容" + notifyID)
                            .setContentInfo("額外資訊");
                    notificationManager.notify(notifyID, notification.build());
                    break;
                case R.id.btn_soundNotify:
                    notification.setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("音效")
                            .setContentText("這是個音效內容")
                            .setContentInfo("額外資訊")
                            .setDefaults(Notification.DEFAULT_SOUND);
                    notificationManager.notify(notifyID, notification.build());
                    break;
                default:
                    break;
            }

        }
    }
}
