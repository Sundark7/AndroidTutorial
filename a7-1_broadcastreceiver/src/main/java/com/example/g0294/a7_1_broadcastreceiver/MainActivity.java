package com.example.g0294.a7_1_broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DynamicBroadcastReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //自定義廣播
        this.findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent("com.example.g0294.staticbroadcast"));
            }
        });
        //註冊系統廣播
        this.findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myReceiver = new DynamicBroadcastReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                registerReceiver(myReceiver, intentFilter);
            }
        });
        this.findViewById(R.id.btn_SendBroadcastMsg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.MY_BROADCAST");
                intent.putExtra("msg", "Hello Receiver!");
                //Normal Broadcast Receiver
                //sendBroadcast(intent);
                //Ordered Broadcast Receiver
                sendOrderedBroadcast(intent, "custom.permission.MY_BROADCAST_PERMISSION");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除註冊
        if (myReceiver != null)
            unregisterReceiver(myReceiver);
    }

}
