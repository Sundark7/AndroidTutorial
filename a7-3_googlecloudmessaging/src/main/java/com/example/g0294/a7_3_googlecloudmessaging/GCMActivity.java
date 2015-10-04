package com.example.g0294.a7_3_googlecloudmessaging;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.net.HttpURLConnection;
import java.net.URL;

public class GCMActivity extends Activity {
    public static final String PROPERTY_REG_ID = "original-gasket-91804";
    public static final String SENDER_ID = "1054935626908";
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private GoogleCloudMessaging gcm;
    private String regid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcm);
        if (checkPlayServices()) {
            gcm = GoogleCloudMessaging.getInstance(this);
            regid = getRegistrationId();

            if (regid.length() == 0) {
                registerInBackground();
            } else {
                Log.d("GCMActivity", regid);
                Toast.makeText(GCMActivity.this, "Already registered", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //檢查是否支援GooglePlayServices
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                finish();
            }
            return false;
        }
        return true;
    }

    //取得推播的ID
    private String getRegistrationId() {
        final SharedPreferences prefs = getSharedPreferences(GCMActivity.class.getSimpleName(), Context.MODE_PRIVATE);
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            return "";
        }
        return registrationId;
    }

    //註冊推播
    private void registerInBackground() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(GCMActivity.this);
                    }
                    regid = gcm.register(SENDER_ID);
                    sendRegisterId(regid);
                    storeRegistrationId(regid);
                    Log.d("GCMActivity", regid);
                    Toast.makeText(GCMActivity.this, "Successful registration", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            }

        }.execute(null, null, null);
    }

    //通知GCM推播ID使用
    private void storeRegistrationId(String regId) {
        SharedPreferences prefs = getSharedPreferences(GCMActivity.class.getSimpleName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_REG_ID, regId);
        editor.apply();
    }

    //傳送推播ID給伺服器
    private void sendRegisterId(String regId) {
        try {
            URL url = new URL("http://ycnas.myds.me/AppList/AppList.php?add=" + regId);
            HttpURLConnection Conn = (HttpURLConnection) url.openConnection();
            Conn.connect();
            Conn.getResponseCode();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
