package com.example.g0294.a4_1_inputcontrols;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditTextActivity extends Activity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text_layout);
        editText = (EditText) findViewById(R.id.edit_text);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Toast.makeText(EditTextActivity.this, String.valueOf(actionId), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        Button getValue = (Button) findViewById(R.id.btn_get_value);
        getValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditTextActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Button all = (Button) findViewById(R.id.btn_all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.selectAll();
            }
        });

        Button getSelect = (Button) findViewById(R.id.btn_get_select);
        getSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int start = editText.getSelectionStart();
                int end = editText.getSelectionEnd();
                CharSequence selectText = editText.getText().subSequence(start, end);
                Toast.makeText(EditTextActivity.this, selectText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
