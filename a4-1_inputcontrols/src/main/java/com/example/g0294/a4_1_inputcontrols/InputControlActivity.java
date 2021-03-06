package com.example.g0294.a4_1_inputcontrols;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InputControlActivity extends Activity {
  private Button btn_textView, btn_editText, btn_imageView, btn_button, btn_checkBox,
      btn_radioButton, btn_datetimePicker, btn_progressBar, btn_seekBar, btn_toast;

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
    btn_button = (Button) findViewById(R.id.btn_button);
    btn_button.setOnClickListener(listener);
    btn_toast = (Button) findViewById(R.id.btn_toast);
    btn_toast.setOnClickListener(listener);
    btn_checkBox = (Button) findViewById(R.id.btn_checkBox);
    btn_checkBox.setOnClickListener(listener);
    btn_radioButton = (Button) findViewById(R.id.btn_radioButton);
    btn_radioButton.setOnClickListener(listener);
    btn_datetimePicker = (Button) findViewById(R.id.btn_datetimePicker);
    btn_datetimePicker.setOnClickListener(listener);
    btn_progressBar = (Button) findViewById(R.id.btn_progressBar);
    btn_progressBar.setOnClickListener(listener);
    btn_seekBar = (Button) findViewById(R.id.btn_seekBar);
    btn_seekBar.setOnClickListener(listener);
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
        case R.id.btn_button:
          intent.setClass(getApplicationContext(), ButtonActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_toast:
          intent.setClass(getApplicationContext(), ToastActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_checkBox:
          intent.setClass(getApplicationContext(), CheckBoxActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_radioButton:
          intent.setClass(getApplicationContext(), RadioButtonActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_datetimePicker:
          intent.setClass(getApplicationContext(), DateTimePickerActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_progressBar:
          intent.setClass(getApplicationContext(), ProgressbarActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_seekBar:
          intent.setClass(getApplicationContext(), SeekRatingBarActivity.class);
          startActivity(intent);
          break;
      }
    }
  }
}
