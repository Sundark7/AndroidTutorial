package com.example.g0294.a4_1_inputcontrols;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ButtonActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_layout);
    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(this,
                "Activity實作Listener方式!", Toast.LENGTH_SHORT);
        toast.show();
    }

    // 須為public方法，方法參數為View
    public void btnClick(View view) {
        Toast toast = Toast.makeText(this,
                "Activity實作Listener方式!", Toast.LENGTH_LONG);
        toast.show();
    }
}
