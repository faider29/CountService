package com.example.faide.servicerecelvarnotification;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mStartService;
    private Button mStopService;
    private Button mSendBroadcast;
    private SimpleReceiver mSimpleReceiver;
    private IntentFilter mIntentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartService = findViewById(R.id.btn_start_service);
        mStopService = findViewById(R.id.btn_stop_service);
        mSendBroadcast = findViewById(R.id.btn_send_broadcast);

        mStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CountService.class);
                startService(intent);
            }
        });
        mStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CountService.class);
                stopService(intent);
            }
        });
        mSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent(SimpleReceiver.SIMPLE_ACTION));

            }
        });
        mSimpleReceiver = new SimpleReceiver((TextView) findViewById(R.id.tv_time));
        mIntentFilter = new IntentFilter(SimpleReceiver.SIMPLE_ACTION);
    }

    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(mSimpleReceiver,mIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mSimpleReceiver);
    }
}
