package com.example.g0294.a4_4_listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btn_arrayAdapter, btn_simpleAdapter, btn_baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        btn_arrayAdapter = (Button) findViewById(R.id.btn_arrayAdapter);
        btn_simpleAdapter = (Button) findViewById(R.id.btn_simpleAdapter);
        btn_baseAdapter = (Button) findViewById(R.id.btn_baseAdapter);
        btn_arrayAdapter.setOnClickListener(this);
        btn_simpleAdapter.setOnClickListener(this);
        btn_baseAdapter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_arrayAdapter:
                intent.setClass(this, ArrayAdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_simpleAdapter:
                intent.setClass(this, SimpleAdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_baseAdapter:
                intent.setClass(this, BaseAdapterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
