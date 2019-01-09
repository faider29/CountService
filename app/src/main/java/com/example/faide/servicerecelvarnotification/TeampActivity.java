package com.example.faide.servicerecelvarnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TeampActivity extends AppCompatActivity {

    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamp);

       long longExtra = getIntent().getLongExtra(CountService.TIME,0);
        tvTime = findViewById(R.id.tv_time);
        tvTime.setText("Time is "+ longExtra);

    }
}
