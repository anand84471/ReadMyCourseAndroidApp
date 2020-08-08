package com.readmycourse.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.readmycourse.android.R;


public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if(getIsInstructorAccount()){
                    intent=new Intent(SplashActivity.this, InstructorActivity.class);
                }
                else {
                    intent=new Intent(SplashActivity.this, StudnetActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },1500);
    }
    private boolean getIsInstructorAccount() {
        SharedPreferences pref =  getSharedPreferences("myPrefs",MODE_PRIVATE);
        return pref.getBoolean("isInstructorSelected",false);
    }

}
