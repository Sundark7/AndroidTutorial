package com.example.g0294.a4_5_components;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btn_autoComplete, btn_gridView, btn_spinner, btn_expandableListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        btn_autoComplete = (Button) findViewById(R.id.btn_autoComplete);
        btn_autoComplete.setOnClickListener(this);
        btn_gridView = (Button) findViewById(R.id.btn_gridView);
        btn_gridView.setOnClickListener(this);
        btn_spinner = (Button) findViewById(R.id.btn_spinner);
        btn_spinner.setOnClickListener(this);
        btn_expandableListview = (Button) findViewById(R.id.btn_expandableListview);
        btn_expandableListview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_autoComplete:
                intent.setClass(this, AutoCompleteActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_gridView:
                intent.setClass(this, GridViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_spinner:
                intent.setClass(this, SpinnerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_expandableListview:
                intent.setClass(this, ExpandableListViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
