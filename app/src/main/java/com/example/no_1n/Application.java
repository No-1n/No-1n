package com.example.no_1n;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class Application extends TabActivity {

    Button button15;
    Button button16;
    Button button17;
    Button btn_toast1;
    Button btn_toast2;
    Button btn_toast3;
    Button btn_toast4;
    Button button5;
    Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailInfo.class);
                startActivity(intent);
            }
        });

        btn_toast1 = findViewById(R.id.btn_toast1);

        btn_toast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"추가되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_toast2 = findViewById(R.id.btn_toast2);

        btn_toast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"추가되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_toast3 = findViewById(R.id.btn_toast3);

        btn_toast3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"추가되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_toast4 = findViewById(R.id.btn_toast4);

        btn_toast4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"추가되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        button8 = findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"신청되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecA = tabHost.newTabSpec("Pop").setIndicator("정보화");
        tabSpecA.setContent(R.id.tabPop1);
        tabHost.addTab(tabSpecA);

        TabHost.TabSpec tabSpecB = tabHost.newTabSpec("Pop").setIndicator("음악");
        tabSpecB.setContent(R.id.tabPop2);
        tabHost.addTab(tabSpecB);

        TabHost.TabSpec tabSpecC = tabHost.newTabSpec("Pop").setIndicator("인문교양");
        tabSpecC.setContent(R.id.tabPop3);
        tabHost.addTab(tabSpecC);

        TabHost.TabSpec tabSpecD = tabHost.newTabSpec("Pop").setIndicator("건강증진");
        tabSpecD.setContent(R.id.tabPop4);
        tabHost.addTab(tabSpecD);

        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
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