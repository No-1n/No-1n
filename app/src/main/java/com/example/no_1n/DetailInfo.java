package com.example.no_1n;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.UtteranceProgressListener;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.speech.tts.TextToSpeech;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
/*
 * 수강 세부정보 페이지
 */

public class DetailInfo extends AppCompatActivity implements TextPlayer {

    private TextView explanation, teacher, time, people, deadline;

    private Button registerbtn;
    private Button returnbtn;

    private final Bundle params = new Bundle();
    private final BackgroundColorSpan colorSpan = new BackgroundColorSpan(Color.YELLOW);
    private TextToSpeech tts;
    private Button playBtn;
    private Button pauseBtn;
    private Button stopBtn;
    private EditText inputEditText;
    private TextView contentTextView;
    private PlayState playState = PlayState.STOP;
    private Spannable spannable;
    private int standbyIndex = 0;
    private int lastPlayIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);

        explanation = findViewById(R.id.classExplanation);
        teacher = findViewById(R.id.classTeacher);
        time = findViewById(R.id.classTime);
        people = findViewById(R.id.classPeople);
        deadline = findViewById(R.id.classDeadline);

        initTTS();

        explanation.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String context = explanation.getText().toString();

                if(playState.isStopping() && !tts.isSpeaking()){
                    startSpeak(context);
                }
            }
        });

        teacher.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String context = teacher.getText().toString();

                if(playState.isStopping() && !tts.isSpeaking()){
                    startSpeak(context);
                }
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                //String context = time.getText().toString();

                if(playState.isStopping() && !tts.isSpeaking()){
                    startSpeak("2021년 01월 01일부터 2021년 01월 23일까지, 매주 수요일");
                }
            }
        });

        people.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String context = people.getText().toString();

                if(playState.isStopping() && !tts.isSpeaking()){
                    startSpeak(context);
                }
            }
        });

        deadline.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                //String context = deadline.getText().toString();

                if(playState.isStopping() && !tts.isSpeaking()){
                    startSpeak("2020년 12월 28일 금요일");
                }
            }
        });




        registerbtn = findViewById(R.id.registerButton);
        returnbtn = findViewById(R.id.returnButton);

        //수강신청 버튼
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup_register = new AlertDialog.Builder(DetailInfo.this);
                popup_register.setMessage("신청하시겠습니까?");

                //"예" 클릭 시 "신청 완료 되었습니다" 창 뜸
                popup_register.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder popup_check = new AlertDialog.Builder(DetailInfo.this);
                        popup_check.setMessage("신청 완료 되었습니다.");

                        popup_check.setNeutralButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //"확인" 클릭 시 창 닫힘
                            }
                        });
                        popup_check.show();
                    }
                });

                //"아니오" 클릭 시 창 닫힘
                popup_register.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                popup_register.show();
            }
        });

        //목록으로 돌아가기
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //여기 생성자 두번째 파라메터에 수강신청 페이지로
                Intent intent = new Intent(getApplicationContext(), Application.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void startPlay() {

    }

    @Override
    public void pausePlay() {

    }

    @Override
    public void stopPlay() {

    }

    private void initTTS() {
        params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, null);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    tts.setLanguage(Locale.KOREAN);
                }
                else{
                    showState("tts 객체 초기화 오류");
                }
            }
        });

        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId) {

            }

            @Override
            public void onDone(String utteranceId) {
                clearAll();
            }

            @Override
            public void onError(String utteranceId) {

            }
        });
    }

    private void showState(final String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startSpeak(final String text){
        tts.speak(text, TextToSpeech.QUEUE_ADD, params, text);
    }

    private void clearAll(){
        playState = PlayState.STOP;
    }
}