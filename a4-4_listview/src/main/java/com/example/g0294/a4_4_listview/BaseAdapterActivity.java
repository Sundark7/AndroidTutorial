package com.example.g0294.a4_4_listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapterActivity extends Activity {
    protected String[] countries = {
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
    protected int[] images = {R.drawable.taiwan, R.drawable.japan, R.drawable.china, R.drawable.brazil, R.drawable.canada,
            R.drawable.france, R.drawable.korea, R.drawable.america, R.drawable.britain, R.drawable.germany, R.drawable.australia};
    private ListView arrayListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        arrayListView = (ListView) findViewById(R.id.arrayListView);

        //Simple Adapter
        // 資料初始化
        List<CountryItem> items = new ArrayList<>();
        for (int i = 0; i < countries.length; i++) {
            items.add(new CountryItem(countries[i], images[i]));
        }

        MyAdapter myAdapter = new MyAdapter(this, items);
        arrayListView.setAdapter(myAdapter);
    }
}
