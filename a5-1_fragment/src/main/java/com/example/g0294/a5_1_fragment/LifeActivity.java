package com.example.g0294.a5_1_fragment;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LifeActivity extends Activity implements View.OnClickListener {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        manager = getFragmentManager();
        button1 = (Button) this.findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) this.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) this.findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) this.findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.button1:
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.right, fragment1, "fragment1");
                transaction.addToBackStack("fragment1");// 把Fragment1加到Activity back stack中。
                break;

            case R.id.button2:
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.right, fragment2, "fragment2");
                transaction.addToBackStack("fragment2");
                break;
            case R.id.button3:
                Fragment3 fragment3 = new Fragment3();
                transaction.replace(R.id.right, fragment3, "fragment3");
                transaction.addToBackStack("fragment3");
                break;
            case R.id.button4:
                Fragment4 fragment4 = new Fragment4();
                transaction.replace(R.id.right, fragment4, "fragment4");
                transaction.addToBackStack("fragment4");
                break;
        }
        transaction.commit();
    }
}
