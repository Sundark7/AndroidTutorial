package com.example.g0294.a4_1_inputcontrols;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends Activity {
  private Button btn_toast, btn_customToast;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.toast_layout);
    btn_toast = (Button) findViewById(R.id.btn_toast);
    btn_toast.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Normal Toast!", Toast.LENGTH_SHORT);
        toast.show();
      }
    });
    btn_customToast = (Button) findViewById(R.id.btn_customToast);

    btn_customToast.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        LayoutInflater inflater = getLayoutInflater();
        View customToast = inflater.inflate(R.layout.mytoast_layout, null);

        TextView text = (TextView) customToast.findViewById(R.id.tvContent);
        text.setText("This is a custom toast");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(customToast);
        toast.show();
      }
    });

  }
}
