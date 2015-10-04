package com.example.g0294.a6_3_querycontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.TextView;

public class QueryMyProvider extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    TextView resultView = null;
    CursorLoader cursorLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_my_provider);
        resultView = (TextView) findViewById(R.id.res);
    }

    public void onClickDisplayNames(View view) {
        getSupportLoaderManager().initLoader(1, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        cursorLoader = new CursorLoader(this, Uri.parse("content://com.example.g0294.MyContentProvider/cte"), null, null, null, null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        data.moveToFirst();
        StringBuilder res = new StringBuilder();
        while (!data.isAfterLast()) {
            res.append("\n" + data.getString(data.getColumnIndex("id")) + "-" + data.getString(data.getColumnIndex("name")));
            data.moveToNext();
        }
        resultView.setText(res);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
