package com.example.g0294.a5_1_fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentCallBackActivity extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_call_back);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.tvFromFragment);

        // 載入leftFragment
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        final LeftFragment leftFragment = new LeftFragment();
        transaction.add(R.id.left, leftFragment, "left");
        transaction.commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 點擊從接口回調，取得fragment中EditText的值
                leftFragment.getEditText(new LeftFragment.CallBack() {
                    @Override
                    public void getResult(String result) {
                        Toast.makeText(FragmentCallBackActivity.this, result, Toast.LENGTH_SHORT).show();
                        textView.setText(result);
                    }

                });
            }

        });
    }

}
