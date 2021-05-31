package com.example.no_1n;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import ClassListFragment.ClassListFragment1;
import ClassListFragment.ClassListFragment2;
import ClassListFragment.ClassListFragment3;
import ClassListFragment.ClassListFragment4;

public class ClassList extends AppCompatActivity {

    private TabLayout tabLayout;
    private ClassListFragment1 classListFragment1;
    private ClassListFragment2 classListFragment2;
    private ClassListFragment3 classListFragment3;
    private ClassListFragment4 classListFragment4;

    private Button detailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);

        classListFragment1 = new ClassListFragment1();
        classListFragment2 = new ClassListFragment2();
        classListFragment3 = new ClassListFragment3();
        classListFragment4 = new ClassListFragment4();

        tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("전체"));
        tabLayout.addTab(tabLayout.newTab().setText("음악"));
        tabLayout.addTab(tabLayout.newTab().setText("인문교양"));
        tabLayout.addTab(tabLayout.newTab().setText("건강증진"));

        getSupportFragmentManager().beginTransaction().add(R.id.container, classListFragment1).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selectedFragment = null;
                if(position == 0)
                    selectedFragment = classListFragment1;
                else if(position == 1)
                    selectedFragment = classListFragment2;
                else if(position == 2)
                    selectedFragment = classListFragment3;
                else if(position == 3)
                    selectedFragment = classListFragment4;
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
                    recelectedFragment = classListFragment1;
                else if(position == 1)
                    recelectedFragment = classListFragment2;
                else if(position == 2)
                    recelectedFragment = classListFragment3;
                else if(position == 3)
                    recelectedFragment = classListFragment4;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, recelectedFragment).commit();
            }
        });

        //세부정보 버튼
        detailBtn = findViewById(R.id.detailButton);
        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailInfo.class);
                startActivity(intent);
            }
        });

    }

}