package com.example.g0294.a6_3_contentprovider;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CustomContentProvider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_content_provider);
    }

    public void onClickAddName(View view) {
        ContentValues values = new ContentValues();
        values.put(MyContentProvider.name, ((EditText) findViewById(R.id.txtName))
                .getText().toString());
        Uri uri = getContentResolver().insert(MyContentProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), "New record inserted", Toast.LENGTH_LONG)
                .show();
    }

}
