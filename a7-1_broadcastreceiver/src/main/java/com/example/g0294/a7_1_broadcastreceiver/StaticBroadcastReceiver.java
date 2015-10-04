package com.example.g0294.a7_1_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class StaticBroadcastReceiver extends BroadcastReceiver {
    public static final String Receiver = "com.example.g0294.staticbroadcast";
    public static final String BootCompleted = "android.intent.action.BOOT_COMPLETED";

    public StaticBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        if (intent.getAction().equals(Receiver)) {
            Log.i("BroadcastReceiver", "Static Broadcast Start!");
            Toast.makeText(context, "Static Broadcast Start!", Toast.LENGTH_LONG).show();
        }
        if (intent.getAction().equals(BootCompleted)) {
            Log.i("BroadcastReceiver", "BOOT Broadcast Start!");
            Toast.makeText(context, "Boot Completed Broadcast!", Toast.LENGTH_LONG).show();
        }
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
