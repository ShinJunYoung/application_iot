package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //객체 선언
    View view1, view2;
    ScrollView scrollView1;
    TextView textView1;
    GestureDetector detector; //무슨 제스쳐를 했는지 감지

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //객체 초기화
        view1 = findViewById(R.id.view1);
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float touchX = event.getX(); // 터치 이벤트로 얻은 X 좌표
                float touchY = event.getY(); // 터치 이벤트로 얻은 Y 좌표

                // 상대적인 위치 계산
                float relativeX = touchX / v.getWidth() * 10000;
                float relativeY = touchY / v.getHeight() * 10000;

                Log.d("dpx", "" + relativeX);
                Log.d("dpy", "" + relativeY);

                return true;
            }
        });


    }
}


