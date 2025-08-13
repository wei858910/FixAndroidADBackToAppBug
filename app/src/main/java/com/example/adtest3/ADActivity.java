package com.example.adtest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ADActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adactivity);
        findViewById(R.id.btn_close_ad_activity).setOnClickListener(v -> {
            finish();
        });
    }
}