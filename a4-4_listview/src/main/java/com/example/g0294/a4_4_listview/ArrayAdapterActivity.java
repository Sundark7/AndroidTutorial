package com.example.g0294.a4_4_listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterActivity extends Activity {
    private ListView arrayListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arrayadapter_layout);
        arrayListView = (ListView) findViewById(R.id.arrayListView);
        String[] country = {
                "台灣",
                "日本",
                "中國大陸",
                "巴西",
                "加拿大",
                "法國",
                "南韓",
                "美國",
                "英國",
                "德國",
                "澳大利亞"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_listview, R.id.country_name, country);
        arrayListView.setAdapter(adapter);
    }
}
