package com.example.faide.servicerecelvarnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class SimpleReceiver extends BroadcastReceiver {

    private WeakReference<TextView> mTextViewWeakReference;
    private TextView mTextView;

    public SimpleReceiver(TextView textView){
        mTextViewWeakReference = new WeakReference<>(textView);

    }
    public static final String SIMPLE_ACTION = "com.example.faide.servicerecelvarnotification.SIMPLE_ACTION";
    private long time;
    private Intent launchActivityIntent;


    @Override
    public void onReceive(Context context, Intent intent) {

        time = intent.getLongExtra(CountService.TIME, 0L);
        Toast.makeText(context, "current time is "+ time, Toast.LENGTH_SHORT).show();

        mTextView = mTextViewWeakReference.get();
        StringBuilder builder = new StringBuilder(mTextView.getText().toString());
        builder.append(time).append("\n");
        mTextView.setText(builder.toString());

/*        launchActivityIntent = new Intent(context, TeampActivity.class);
        launchActivityIntent.putExtra(CountService.TIME,time);

        context.startActivity(launchActivityIntent);*/
    }
}
