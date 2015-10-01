package com.example.g0294.a4_1_inputcontrols;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InputControlActivity extends Activity {
    private Button btn_textView, btn_editText, btn_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputcontrol_layout);
        SelectActivity listener = new SelectActivity();
        btn_textView = (Button) findViewById(R.id.btn_textView);
        btn_textView.setOnClickListener(listener);
        btn_editText = (Button) findViewById(R.id.btn_editText);
        btn_editText.setOnClickListener(listener);
        btn_imageView = (Button) findViewById(R.id.btn_imageView);
        btn_imageView.setOnClickListener(listener);
    }

    class SelectActivity implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.btn_textView:
                    intent.setClass(getApplicationContext(), TextViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_editText:
                    intent.setClass(getApplicationContext(), EditTextActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_imageView:
                    intent.setClass(getApplicationContext(), ImageViewActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
