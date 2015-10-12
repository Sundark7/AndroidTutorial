package com.example.g0294.a4_1_inputcontrols;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TextViewActivity extends Activity {
    private TextView textView, tvAge;
    protected String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_view_layout);
        textView = (TextView) findViewById(R.id.tv_marquee);
        tvAge = (TextView)findViewById(R.id.tvAge);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setFocusable(true);
                textView.setFocusableInTouchMode(true);
            }
        });
        str = getResources().getString(R.string.your_age);
        tvAge.setText(String.format(str, "王曉明", 1990, (2015-1990)));
    }
}
