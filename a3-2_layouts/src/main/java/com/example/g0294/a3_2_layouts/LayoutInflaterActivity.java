package com.example.g0294.a3_2_layouts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LayoutInflaterActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.inflater_layout);

    LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
    LayoutInflater inflater = LayoutInflater.from(this);

    View v1 = inflater.inflate(R.layout.layout_include, null);
    // View v2 = inflater.inflate(R.layout.layout_include, rootView);

    TextView textView = new TextView(this);
    textView.setText("Custom TextView");
    textView.setTextColor(Color.BLACK);
    rootView.addView(textView);
  }
}
