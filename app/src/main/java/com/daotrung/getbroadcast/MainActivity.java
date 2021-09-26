package com.daotrung.getbroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar ;

    private static final String MY_ACTION = "com.trungdao.ACTION";
    private static final String MY_NAME = "com.trungdao.TEXT1";
    private static final String MY_ADDRESS = "com.trungdao.TEXT2";
    private static final String MY_PHONE = "com.trungdao.TEXT3";
    TextView txt1 , txt2 ,txt3 ,txtTool ;

    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String text1 = intent.getStringExtra(MY_NAME);
            String text2 = intent.getStringExtra(MY_ADDRESS);
            String text3 = intent.getStringExtra(MY_PHONE);
            txt1.setText(text1);
            txt2.setText(text2);
            txt3.setText(text3);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt_get1);
        txt2 = findViewById(R.id.txt_get2);
        txt3 = findViewById(R.id.txt_get3);

        txtTool = findViewById(R.id.txt_toolbar);
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        toolbar.setTitle(txtTool.getText());
       Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(MY_ACTION);
        registerReceiver(mBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);

    }
}