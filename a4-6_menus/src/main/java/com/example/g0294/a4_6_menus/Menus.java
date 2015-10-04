package com.example.g0294.a4_6_menus;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Menus extends Activity {
    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;
    private MenuItem myActionMenuItem;
    private EditText myActionEditText;
    private TextView tvColor;
    private String TAG = "Menus";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menus, menu);
        // 取得my action Layout
        myActionMenuItem = menu.findItem(R.id.my_action);
        View actionView = myActionMenuItem.getActionView();
        OnEditorListener editorListener = new OnEditorListener();
        // Edit Text View of the my_action view
        if (actionView != null) {
            myActionEditText = (EditText) actionView.findViewById(R.id.myActionEditText);
            if (myActionEditText != null) {
                myActionEditText.setOnEditorActionListener(editorListener);
            }
        }
        // return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        tvColor = (TextView) findViewById(R.id.tvColor);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setLogo(R.mipmap.ic_launcher);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setTitle("New Title");
        }

        Button btn_secondActivity = (Button) findViewById(R.id.Go_Second);
        btn_secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Menus.this, v);
                popupMenu.inflate(R.menu.goactivity);
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.startSecond:
                                Intent intent = new Intent(Menus.this, SecondActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.showMessage:
                                Toast.makeText(Menus.this, "Popup Menu!", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });
            }
        });
        registerForContextMenu(tvColor);
    }

    private void toggleActionBar() {
        Log.d(TAG, "toggleActionBar ");
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            if (actionBar.isShowing()) {
                actionBar.hide();
            } else {
                actionBar.show();
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_COLOR_RED:
                tvColor.setText("The TextView is Red!");
                tvColor.setTextColor(Color.RED);
                break;
            case MENU_COLOR_GREEN:
                tvColor.setText("The TextView is Green!");
                tvColor.setTextColor(Color.GREEN);
                break;
            case MENU_COLOR_BLUE:
                tvColor.setText("The TextView is Blue!");
                tvColor.setTextColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.i(TAG, "Item ID: " + id);
        switch (id) {
            case R.id.action_search:
                Toast.makeText(this, "搜尋", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_record:
                Toast.makeText(this, "錄影", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_save:
                Toast.makeText(this, "存檔", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_label:
                Toast.makeText(this, "新增標籤", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_play:
                Toast.makeText(this, "播放", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "設定", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.tvColor:
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "Touch Event:" + event.getAction());
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            toggleActionBar();
        }
        return super.onTouchEvent(event);
    }

    class OnEditorListener implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (event != null) {
                // 當按下確認鍵時, 取得輸入字串，並顯示
                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    String textInput = v.getText().toString();
                    Toast.makeText(Menus.this, textInput, Toast.LENGTH_SHORT).show();
                }
            }
            return false;
        }

    }
}
