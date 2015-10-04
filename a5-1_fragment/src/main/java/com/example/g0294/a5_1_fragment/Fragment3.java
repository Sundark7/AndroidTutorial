package com.example.g0294.a5_1_fragment;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {

    private final String TAG = "Fragment3";

    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "-----Fragment3->>onCreate");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG, "-----Fragment3->>onAttach");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "-----Fragment3->>onCreateView");
        return inflater.inflate(R.layout.fragment3, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "-----Fragment3->>onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "-----Fragment3->>onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "-----Fragment3->>onResume");
    }

    @Override
    public void onPause() {
        Log.i(TAG, "-----Fragment3->>onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "-----Fragment3->>onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "-----Fragment3->>onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "-----Fragment3->>onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "-----Fragment3->>onDetach");
    }
}
