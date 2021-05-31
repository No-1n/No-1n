package com.example.no_1n;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;

import MyCenterFragment.MyCenterFragment1;
import MyCenterFragment.MyCenterFragment2;
import MyCenterFragment.MyCenterFragment3;

public class MyCenter extends AppCompatActivity {

    private ConstraintLayout mycenter;

    private TabLayout tabLayout;
    private MyCenterFragment1 myCenterFragment1;
    private MyCenterFragment2 myCenterFragment2;
    private MyCenterFragment3 myCenterFragment3;

    private Button button3;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_center);

        mycenter = findViewById(R.id.mycenter);
        mycenter.setBackgroundColor(Color.parseColor("#FCFCF6"));

        addButton = findViewById(R.id.addButton);

        myCenterFragment1 = new MyCenterFragment1();
        myCenterFragment2 = new MyCenterFragment2();
        myCenterFragment3 = new MyCenterFragment3();

        tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("고양시 일산 종합 사회복지관"));
        tabLayout.addTab(tabLayout.newTab().setText("여주시 평생 학습센터"));
        tabLayout.addTab(tabLayout.newTab().setText("마포 종합 노인복지관"));


        getSupportFragmentManager().beginTransaction().add(R.id.container, myCenterFragment1).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selectedFragment = null;
                if(position == 0)
                    selectedFragment = myCenterFragment1;
                else if(position == 1)
                    selectedFragment = myCenterFragment2;
                else if(position == 2)
                    selectedFragment = myCenterFragment3;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment recelectedFragment = null;
                if(position == 0)
                    recelectedFragment = myCenterFragment1;
                else if(position == 1)
                    recelectedFragment = myCenterFragment2;
                else if(position == 2)
                    recelectedFragment = myCenterFragment3;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, recelectedFragment).commit();
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Application.class);
                startActivity(intent);
            }
        });

    }


}