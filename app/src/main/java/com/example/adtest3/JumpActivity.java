package com.example.adtest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class JumpActivity extends AppCompatActivity {

    // 静态标志位，确保只创建一次主Activity
    private static boolean s_hasCreateMainActivity = false;

    private static final String TAG = "JumpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);

        Log.d(TAG, "this.isTaskRoot() = " + this.isTaskRoot());

        if(!s_hasCreateMainActivity)
        {
            s_hasCreateMainActivity = true;
            Log.d(TAG, "new Intent(this, GameActivity.class)");


            Intent intent = new Intent(this, GameActivity.class);
            if(intent != null)
            {
                Log.d(TAG, "intent != null");

                Log.d(TAG, getIntent().toString());
                intent.putExtras(getIntent());

                String packageName = getApplicationContext().getPackageName();
                Log.d(TAG, "packageName = " + packageName);

                ComponentName componentName = new ComponentName(packageName, GameActivity.class.getName());
                Log.d(TAG, "componentName = " + componentName);

                intent.setComponent(componentName);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                // 启动主Activity
                startActivity(intent);
            }
        }

        Log.d(TAG, "finish()");

        // JumpActivity的使命已完成，自行销毁
        // 这样返回栈中就不会保留这个中间Activity
        finish();
    }
}