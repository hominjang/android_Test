package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private MypagerAdapter mypagerAdapter;
    FirstFragment firstFragment;
    SecondFragment secondFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager2) findViewById(R.id.pager);
        createFragment();
        createViewpager();

    }

    //fragment 생성
    public void createFragment() {
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

    }

    //viewpager 및 어댑터 생성
    public void createViewpager() {
        mypagerAdapter = new MypagerAdapter(this.getSupportFragmentManager(), getLifecycle());
        mypagerAdapter.addFragment(firstFragment);
        mypagerAdapter.addFragment(secondFragment);
        viewPager.setAdapter(mypagerAdapter);
        viewPager.setUserInputEnabled(true);//터치 스크롤 막음
    }


}