package com.example.no_1n;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Centerpick extends AppCompatActivity{
    Spinner sp_parent, sp_child;
    private Button my_btn;

    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent;

    ArrayList<String> arrayList_seoul, arrayList_gyeonggi, arrayList_gangwon, arrayList_jeju;
    ArrayAdapter<String> arrayAdapter_child;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_centerpick);
        my_btn = findViewById(R.id.my_btn);
        my_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondMain.class);
                startActivity(intent);
            }
        });
        sp_parent=(Spinner)findViewById(R.id.sp_parent);
        sp_child=(Spinner)findViewById(R.id.sp_child);

        arrayList_parent=new ArrayList<>();
        arrayList_parent.add("서울특별시");
        arrayList_parent.add("경기도");
        arrayList_parent.add("강원도");
        arrayList_parent.add("제주특별자치도");

        arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item, arrayList_parent);

        sp_parent.setAdapter(arrayAdapter_parent);

        arrayList_seoul = new ArrayList<>();
        arrayList_seoul.add("중구");
        arrayList_seoul.add("종로구");
        arrayList_seoul.add("용산구");
        arrayList_seoul.add("강북구");
        arrayList_seoul.add("성동구");


        arrayList_gyeonggi = new ArrayList<>();
        arrayList_gyeonggi.add("하남시");
        arrayList_gyeonggi.add("구리시");
        arrayList_gyeonggi.add("용인시");
        arrayList_gyeonggi.add("과천시");


        arrayList_gangwon = new ArrayList<>();
        arrayList_gangwon.add("속초시");
        arrayList_gangwon.add("강릉시");
        arrayList_gangwon.add("평창군");

        arrayList_jeju = new ArrayList<>();
        arrayList_jeju.add("제주시");
        arrayList_jeju.add("서귀포시");


        sp_parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_seoul);
                }
                if(position==1)
                {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_gyeonggi);
                }
                if(position==2)
                {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_gangwon);
                }
                if(position==3)
                {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_jeju);
                }
                sp_child.setAdapter(arrayAdapter_child);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}