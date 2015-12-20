package com.example.shanmg02.headersample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements PageListener {

    private ViewPager viewPager;
    private LinearLayout header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        header =(LinearLayout) findViewById(R.id.linearLayout);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return BlankFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return 10;
            }
        });
    }

    @Override
    public void onScrolled(int i) {
        System.out.println(i);
        System.out.println(header.getTop());
        System.out.println(viewPager.getTop());

    }
}
