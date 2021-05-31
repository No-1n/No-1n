package com.example.no_1n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondMain extends AppCompatActivity {

    private Button myCenterButton; //클릭 시 mycenter로 이동
    private Button classRecommendationBtn; //클릭 시 classrecommendation으로 이동
    private Button classListBtn;
    private Button button15;
    private Button button16;
    private Button button17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        myCenterButton = findViewById(R.id.myCenterButton);
        classRecommendationBtn = findViewById(R.id.classRecommendationButton);
        classListBtn = findViewById(R.id.classListButton);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);

        //내 복지관 페이지로 이동
        myCenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyCenter.class);
                startActivity(intent);
            }
        });

        //추천 강좌 페이지로 이동
        classRecommendationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Recommendation.class);
                startActivity(intent);
            }
        });

        //강좌 모음 페이지로 이동
        classListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClassList.class);
                startActivity(intent);
            }
        });
        // 수업일정
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClassSchedule.class);
                startActivity(intent);
            }
        });
        // Home
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondMain.class);
                startActivity(intent);
            }
        });
        // 내 정보
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyInformation.class);
                startActivity(intent);
            }
        });
    }
}