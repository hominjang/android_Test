package com.example.part18;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class part18_2 extends AppCompatActivity {
    ViewPager2 viewPager2;

    private MypagerAdapter mypagerAdapter;
    FloatingActionButton floatingActionButton;
    TabLayout tabLayout;

    RelativeLayout relativeLayout;
    FirstFragment firstFragment;
    SecondFragment secondFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part182);

        relativeLayout = findViewById(R.id.relativeLayout);
        floatingActionButton = findViewById(R.id.floating_button);
        viewPager2 = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        createFragment();
        createViewpager();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(relativeLayout, "반갑습니당", Snackbar.LENGTH_LONG).
                        setAction("여기 눌러볼래?", new View.OnClickListener(){
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(part18_2.this, "와 이거까지 누르네", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

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
        viewPager2.setAdapter(mypagerAdapter);
        final List<String> tabElement = Arrays.asList("여기저기","저기여기");

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            // 인자들을 보면 첫번째는 tablayout
            // 두번째는 viewpagers
            // 세번째는 탭을 어캐 구성할지 결정하는것이 있다.

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(part18_2.this);
                textView.setText(tabElement.get(position));
                tab.setCustomView(textView);
            }
        }).attach();

        viewPager2.setUserInputEnabled(true);//터치 스크롤 막음
    }

}