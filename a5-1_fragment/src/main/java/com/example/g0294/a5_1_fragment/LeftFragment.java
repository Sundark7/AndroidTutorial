package com.example.g0294.a5_1_fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

    private Button button;
    private EditText editText;

    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, null);
        editText = (EditText) view.findViewById(R.id.editText1);
        return view;
    }

    // Call Back接口
    public void getEditText(CallBack callBack) {
        String msg = editText.getText().toString();
        callBack.getResult(msg);
    }

    public interface CallBack {
        void getResult(String result);
    }
}
