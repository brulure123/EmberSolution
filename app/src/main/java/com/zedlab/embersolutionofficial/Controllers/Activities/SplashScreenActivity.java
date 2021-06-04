package com.zedlab.embersolutionofficial.Controllers.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.zedlab.embersolutionofficial.R;

public class SplashScreenActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private static final long SPLASH_TIME_OUT = 5000;
    private SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        loadingProgressBar();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if(isFirstTime){
                    onBoardingScreen.edit().putBoolean("firstTime", false).apply();
                    startActivity( new Intent(getApplicationContext(), OnBoardingActivity.class));
                }else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private void loadingProgressBar(){
        progressBar = findViewById(R.id.activity_splash_screen_progress_bar);
        progressBar.setVisibility(View.VISIBLE);
    }
}