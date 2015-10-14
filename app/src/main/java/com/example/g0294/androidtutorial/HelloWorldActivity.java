package com.example.g0294.androidtutorial;

import android.app.Activity;
import android.os.Bundle;

public class HelloWorldActivity extends Activity {

    /**  覆寫onCreate方法  * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* 呼叫父類別onCreate方法的敘述 */
        super.onCreate(savedInstanceState);
        /* 指定使用的畫面Layout */
        setContentView(R.layout.activity_hello_world);
    }

}
