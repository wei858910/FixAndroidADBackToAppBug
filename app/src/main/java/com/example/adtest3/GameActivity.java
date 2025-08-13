package com.example.adtest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findViewById(R.id.btn_open_ad_activity).setOnClickListener(v -> {
            startActivity(new android.content.Intent(this, ADActivity.class));
        });
    }
}