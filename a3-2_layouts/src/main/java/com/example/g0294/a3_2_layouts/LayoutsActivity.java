package com.example.g0294.a3_2_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LayoutsActivity extends AppCompatActivity {

  private Button btn_linear, btn_relative, btn_table;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_layouts);

    btn_linear = (Button) findViewById(R.id.linearLayout);
    btn_relative = (Button) findViewById(R.id.relativeLayout);
    btn_table = (Button) findViewById(R.id.tableLayout);

    ButtonListener buttonListener = new ButtonListener();
    btn_linear.setOnClickListener(buttonListener);
    btn_relative.setOnClickListener(buttonListener);
    btn_table.setOnClickListener(buttonListener);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_layouts, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    // noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  class ButtonListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
      Intent intent = new Intent();
      switch (v.getId()) {
        case R.id.linearLayout:
          intent.setClass(getApplicationContext(), LinearActivity.class);
          startActivity(intent);
          break;
        case R.id.relativeLayout:
          intent.setClass(getApplicationContext(), RelativeActivity.class);
          startActivity(intent);
          break;
        case R.id.tableLayout:
          intent.setClass(getApplicationContext(), TableActivity.class);
          startActivity(intent);
          break;
      }
    }
  }
}
