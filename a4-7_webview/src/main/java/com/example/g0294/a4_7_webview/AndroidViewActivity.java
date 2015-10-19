package com.example.g0294.a4_7_webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class AndroidViewActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        WebView browser;
        browser=(WebView)findViewById(R.id.webView);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("http://ycnas.myds.me/androidweb.html");

    }
}
