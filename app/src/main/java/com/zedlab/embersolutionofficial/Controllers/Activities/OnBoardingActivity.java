package com.zedlab.embersolutionofficial.Controllers.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zedlab.embersolutionofficial.Controllers.Adapters.SliderAdapter;
import com.zedlab.embersolutionofficial.R;

public class OnBoardingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] dots;
    private Button getStartedBtn;
    private Animation animation;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        initComponent();
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    private void initComponent() {
        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        getStartedBtn = findViewById(R.id.get_started);

        //Call adapter
        sliderAdapter = new SliderAdapter(getApplicationContext());
        viewPager.setAdapter(sliderAdapter);
    }

    private void addDots(int position){
        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i=0; i<dots.length; i++){
            dots[i] = new TextView(getApplicationContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPosition = position;
            getStartedBtnVisibility(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void getStartedBtnVisibility(int position) {
        switch (position){
            case 0:
            case 1:
            case 2:
                getStartedBtn.setVisibility(View.INVISIBLE);
                break;
            case 3:
                animation = AnimationUtils.loadAnimation(OnBoardingActivity.this, R.anim.bottom_anim);
                getStartedBtn.setAnimation(animation);
                getStartedBtn.setVisibility(View.VISIBLE);
        }
    }

    public void lunchMainActivity(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    public void skip(View view){
        lunchMainActivity(view);
    }

    public void next(View view){
        viewPager.setCurrentItem(currentPosition + 1);
    }
}