package com.example.g0294.a8_1_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static TextView log;
    private static ScrollView logView;
    private Button startSer1;
    private Button stopSer1;
    private Button startSer2;
    private Button stopSer2;
    private Button bindSer1;
    private Button unBindSer1;
    private Button bindSer2;
    private Button unBindSer2;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    protected View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MyService.class);
            switch (v.getId()) {
                case R.id.startSer1:
                    updateLog("Start Service 1 pressed");
                    startService(intent);
                    break;
                case R.id.startSer2:
                    updateLog("Start Service 2 pressed");
                    startService(intent);
                    break;
                case R.id.stopSer1:
                    updateLog("Stop Service 1 pressed");
                    stopService(intent);
                    break;
                case R.id.stopSer2:
                    updateLog("Stop Service 2 pressed");
                    stopService(intent);
                    break;
                case R.id.bindSer1:
                    updateLog("Bind Service 1 pressed");
                    bindService(intent, connection, BIND_AUTO_CREATE);
                    break;
                case R.id.unBindSer1:
                    updateLog("UnBind Service 1 pressed");
                    unbindService(connection);
                    break;
                case R.id.bindSer2:
                    updateLog("Bind Service 2 pressed");
                    bindService(intent, connection, BIND_AUTO_CREATE);
                    break;
                case R.id.unBindSer2:
                    updateLog("UnBind Service 2 pressed");
                    unbindService(connection);
                    break;
                default:
                    break;
            }
        }
    };

    public static void updateLog(String text) {
        CharSequence ch = log.getText();
        log.setText(((ch == null || ch.length() == 0) ? text : ch.toString()
                + "\r\n" + text));
        logView.fullScroll(ScrollView.FOCUS_DOWN);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startSer1 = (Button) findViewById(R.id.startSer1);
        stopSer1 = (Button) findViewById(R.id.stopSer1);
        startSer2 = (Button) findViewById(R.id.startSer2);
        stopSer2 = (Button) findViewById(R.id.stopSer2);
        bindSer1 = (Button) findViewById(R.id.bindSer1);
        unBindSer1 = (Button) findViewById(R.id.unBindSer1);
        bindSer2 = (Button) findViewById(R.id.bindSer2);
        unBindSer2 = (Button) findViewById(R.id.unBindSer2);

        log = (TextView) findViewById(R.id.log);

        logView = (ScrollView) findViewById(R.id.logView);

        startSer1.setOnClickListener(btnListener);
        stopSer1.setOnClickListener(btnListener);
        startSer2.setOnClickListener(btnListener);
        stopSer2.setOnClickListener(btnListener);

        bindSer1.setOnClickListener(btnListener);
        unBindSer1.setOnClickListener(btnListener);
        bindSer2.setOnClickListener(btnListener);
        unBindSer2.setOnClickListener(btnListener);
    }
}
