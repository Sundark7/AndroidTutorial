package com.example.g0294.a6_1_filesystem;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class StorageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        BtnOnClickListener btnOnClickListener = new BtnOnClickListener();

        Button saveToInternalStorage = (Button) findViewById(R.id.saveInternalStorage);
        saveToInternalStorage.setOnClickListener(btnOnClickListener);

        Button readFromInternalStorage = (Button) findViewById(R.id.getInternalStorage);
        readFromInternalStorage.setOnClickListener(btnOnClickListener);

        Button saveToExternalStorage = (Button) findViewById(R.id.saveExternalStorage);
        saveToExternalStorage.setOnClickListener(btnOnClickListener);

        Button readFromExternalStorage = (Button) findViewById(R.id.getExternalStorage);
        readFromExternalStorage.setOnClickListener(btnOnClickListener);

        // 檢查外部空間是否可用或唯讀
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveToExternalStorage.setEnabled(false);
        }

    }

    private boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState);
    }

    private boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(extStorageState);
    }

    // 寫檔
    private void writeToFile(File fout, String data) {
        FileOutputStream osw = null;
        try {
            osw = new FileOutputStream(fout);
            osw.write(data.getBytes());
            osw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null)
                    osw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 讀檔
    private String readFromFile(File fin) {
        StringBuilder data = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fin), "utf-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data.toString();
    }

    class BtnOnClickListener implements View.OnClickListener {

        File dir;
        File outFile;
        String filename = "SampleFile.txt";

        @Override
        public void onClick(View v) {
            EditText inputText = (EditText) findViewById(R.id.myInputText);
            TextView responseText = (TextView) findViewById(R.id.responseText);
            String content;

            switch (v.getId()) {
                case R.id.saveInternalStorage:

                    dir = getApplication().getFilesDir(); // 取得內部儲存體檔案目錄
                    outFile = new File(dir, filename); // 在該目錄底下開啟或建立filename
                    writeToFile(outFile, inputText.getText().toString());
                    inputText.setText("");
                    responseText.setText("SampleFile.txt 儲存到內部儲存空間...");
                    break;

                case R.id.getInternalStorage:

                    dir = getApplication().getFilesDir(); // 取得內部儲存體檔案目錄
                    outFile = new File(dir, filename); // 在該目錄底下開啟或建立filename
                    content = readFromFile(outFile);
                    inputText.setText(content);
                    responseText.setText("從內部儲存空間讀取SampleFile.txt內容...");
                    break;

                case R.id.saveExternalStorage:

                    dir = getApplication().getExternalFilesDir(null); // 取得外部儲存體檔案目錄，null返回的目錄型態，DIRECTORY_MUSIC....
                    outFile = new File(dir, filename);
                    writeToFile(outFile, inputText.getText().toString());
                    inputText.setText("");
                    responseText.setText("SampleFile.txt 儲存到外部儲存空間...");
                    break;

                case R.id.getExternalStorage:
                    dir = getApplication().getExternalFilesDir(null); // 取得外部儲存體檔案目錄，null返回的目錄型態，DIRECTORY_MUSIC....
                    outFile = new File(dir, filename);
                    content = readFromFile(outFile);
                    inputText.setText(content);
                    responseText.setText("從外部儲存空間讀取SampleFile.txt內容...");
                    break;
            }
        }
    }
}
