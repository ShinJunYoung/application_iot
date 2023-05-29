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
//        view2 = findViewById(R.id.view2);
        scrollView1 = findViewById(R.id.scrollView1);
        textView1 = findViewById(R.id.textView1);

        //터치를 했을때 작동하는 메서드
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int action = event.getAction();

                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int screenWidth = displayMetrics.widthPixels;
                int screenHeight = displayMetrics.heightPixels;
                float touchX = event.getX(); // 터치 이벤트로 얻은 X 좌표
                float touchY = event.getY(); // 터치 이벤트로 얻은 Y 좌표

                float dpX = touchX  / screenWidth;
                float dpY = touchY / screenHeight;

                Log.d("dpx", "" + dpX);
                Log.d("dpy", "" + dpY);

                //displayMetrics = getResources().getDisplayMetrics();
                //float density = displayMetrics.density;

                //float dpX = event.getX() / density;
                //float dpY = event.getY() / density;

                if (action == event.ACTION_DOWN) {   //처음 눌렸을 때
                    printString("손가락 눌림 : " + dpX + ", " + dpY);
                } else if (action == event.ACTION_MOVE) {    //누르고 움직였을 때
                    printString("손가락 움직임 : " + dpX + ", " + dpY);
                } else if (action == event.ACTION_UP) {    //누른걸 뗐을 때
                    printString("손가락 뗌 : " + dpX + ", " + dpY);
                }
                return true;
            }
        });

//        view2.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                detector.onTouchEvent(event);
//                return true;
//            }
//        });
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            //화면이 눌렸을 때
            @Override
            public boolean onDown(MotionEvent e) {
                printString("onDown() 호출됨");
                return true;
            }

            //화면이 눌렸다 떼어지는 경우
            @Override
            public void onShowPress(MotionEvent e) {
                printString("onShowPress() 호출됨");
            }

            //화면이 한 손가락으로 눌렸다 떼어지는 경우
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                printString("onSingleTapUp() 호출됨");
                return true;
            }

            //화면이 눌린채 일정한 속도와 방향으로 움직였다 떼어지는 경우
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                printString("onScroll() 호출됨 => " + distanceX + ", " + distanceY);
                return false;
            }

            //화면을 손가락으로 오랫동안 눌렀을 경우
            @Override
            public void onLongPress(MotionEvent e) {
                printString("onLongPress() 호출됨");
            }

            //화면이 눌린채 손가락이 가속해서 움직였다 떼어지는 경우
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                printString("onFling() 호출됨 => " + velocityX + ", " + velocityY);
                return true;
            }
        });
    }

    private void printString(String s) {
        //좌표 출력
        textView1.append(s + "\n"); //한 줄씩 추가

        //자동으로 마지막 줄로 스크롤 내림
        scrollView1.fullScroll(View.FOCUS_DOWN);
    }
}

