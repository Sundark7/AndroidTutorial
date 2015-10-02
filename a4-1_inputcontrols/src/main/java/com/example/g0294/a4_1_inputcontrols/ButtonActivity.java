package com.example.g0294.a4_1_inputcontrols;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ButtonActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_layout);
        Button btn_listener = (Button) findViewById(R.id.btn_listener);

        btn_listener.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "嵌入Listener方式!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        ImageButton btn_imgButton = (ImageButton) findViewById(R.id.btn_imgButton);
        btn_imgButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(this,
                "Activity實作Listener方式!", Toast.LENGTH_SHORT);
        toast.show();
    }

    // 須為public方法
    public void btnClick(View view) {
        Toast toast = Toast.makeText(this,
                "Attribute指定OnClick方法!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
