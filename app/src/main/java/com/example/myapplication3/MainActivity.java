////// package com.example.myapplication3;
//////
//////import androidx.appcompat.app.ActionBar;
//////import androidx.appcompat.app.AppCompatActivity;
//////import android.os.Bundle;
//////import android.util.Log;
//////import android.view.MotionEvent;
//////import android.view.View;
//////
//////
//////public class MainActivity extends AppCompatActivity {
//////    //객체 선언
//////    View view1;
//////
//////    @Override
//////    protected void onCreate(Bundle savedInstanceState) {
//////        super.onCreate(savedInstanceState);
//////        setContentView(R.layout.activity_main);
//////
//////        ActionBar actionBar = getSupportActionBar();
//////        actionBar.hide();
//////
//////        //객체 초기화
//////        view1 = findViewById(R.id.view1);
//////        view1.setOnTouchListener(new View.OnTouchListener() {
//////            @Override
//////            public boolean onTouch(View v, MotionEvent event) {
//////                float touchX = event.getX(); // 터치 이벤트로 얻은 X 좌표
//////                float touchY = event.getY(); // 터치 이벤트로 얻은 Y 좌표
//////
//////                // 상대적인 위치 계산
//////                float relativeX = touchX / v.getWidth() * 100;
//////                float relativeY = touchY / v.getHeight() * 100;
//////
//////                Log.d("dpx", "" + relativeX);
//////                Log.d("dpy", "" + relativeY);
//////
//////                return true;
//////            }
//////        });
//////    }
//////}
////
////package com.example.myapplication3;
////
////import androidx.appcompat.app.ActionBar;
////import androidx.appcompat.app.AppCompatActivity;
////import android.graphics.Bitmap;
////import android.graphics.Canvas;
////import android.graphics.Color;
////import android.graphics.Paint;
////import android.graphics.drawable.BitmapDrawable;
////import android.os.Bundle;
////import android.util.Log;
////import android.view.MotionEvent;
////import android.view.View;
////import android.widget.ImageView;
////
////public class MainActivity extends AppCompatActivity {
////    ImageView view1;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        ActionBar actionBar = getSupportActionBar();
////        actionBar.hide();
////
////        view1 = findViewById(R.id.view1);
////        view1.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                float touchX = event.getX(); // 터치 이벤트로 얻은 X 좌표
////                float touchY = event.getY(); // 터치 이벤트로 얻은 Y 좌표
////
////                // 상대적인 위치 계산
////                float relativeX = touchX / v.getWidth() * 100;
////                float relativeY = touchY / v.getHeight() * 100;
////
////                Log.d("dpx", "" + relativeX);
////                Log.d("dpy", "" + relativeY);
////
////                drawPoint(view1, relativeX, relativeY);
////
////                return true;
////            }
////        });
////    }
////
////    public void drawPoint(ImageView imageView, float relativeX, float relativeY) {
////        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
////        Bitmap mutableBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
////
////        Canvas canvas = new Canvas(mutableBitmap);
////        Paint paint = new Paint();
////        paint.setColor(Color.RED);
////        paint.setStyle(Paint.Style.FILL);
////        float dotRadius = 10.0f;
////
////        // 상대적인 위치를 기준으로 점을 그립니다.
////        float x = (relativeX / 100) * canvas.getWidth();
////        float y = (relativeY / 100) * canvas.getHeight();
////
////        canvas.drawCircle(x, y, dotRadius, paint);
////
////        imageView.setImageBitmap(mutableBitmap);
////    }
////}
////
//
//package com.example.myapplication3;
//
//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.AppCompatActivity;
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.drawable.BitmapDrawable;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//
//public class MainActivity extends AppCompatActivity {
//    ImageView view1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
//
//        view1 = findViewById(R.id.view1);
//        drawPoint(view1, 21, 35); // 미리 정해진 위치에 점 생성
//    }
//
//    public void drawPoint(ImageView imageView, float relativeX, float relativeY) {
//        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
//        Bitmap mutableBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
//
//        Canvas canvas = new Canvas(mutableBitmap);
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.FILL);
//        float dotRadius = 10.0f;
//
//        // 상대적인 위치를 기준으로 점을 그립니다.
//        float x = (relativeX / 100) * canvas.getWidth();
//        float y = (relativeY / 100) * canvas.getHeight();
//
//        canvas.drawCircle(x, y, dotRadius, paint);
//
//        imageView.setImageBitmap(mutableBitmap);
//    }
//}

package com.example.myapplication3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView view1;
    List<Point> pointList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        view1 = findViewById(R.id.view1);

        pointList = new ArrayList<>();
        pointList.add(new Point(56, 86)); // 점 추가
        pointList.add(new Point(44, 86)); // 점 추가
        pointList.add(new Point(31, 86)); // 점 추가
        pointList.add(new Point(15, 86)); // 점 추가

        for (int i = 0; i < pointList.size(); i++) {
            Point startPoint = pointList.get(i);
            Point endPoint = (i + 1 < pointList.size()) ? pointList.get(i + 1) : pointList.get(0);
            drawLine(view1, startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
    }

    public void drawLine(ImageView imageView, float startX, float startY, float endX, float endY) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        Bitmap mutableBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);

        Canvas canvas = new Canvas(mutableBitmap);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5.0f);

        // 상대적인 위치를 기준으로 선을 그립니다.
        float startXPos = (startX / 100) * canvas.getWidth();
        float startYPos = (startY / 100) * canvas.getHeight();
        float endXPos = (endX / 100) * canvas.getWidth();
        float endYPos = (endY / 100) * canvas.getHeight();

        canvas.drawLine(startXPos, startYPos, endXPos, endYPos, paint);

        imageView.setImageBitmap(mutableBitmap);
    }
}

