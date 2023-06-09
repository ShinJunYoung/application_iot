// package com.example.myapplication3;
//
//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.View;
//
//
//public class MainActivity extends AppCompatActivity {
//    //객체 선언
//    View view1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
//
//        //객체 초기화
//        view1 = findViewById(R.id.view1);
//        view1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                float touchX = event.getX(); // 터치 이벤트로 얻은 X 좌표
//                float touchY = event.getY(); // 터치 이벤트로 얻은 Y 좌표
//
//                // 상대적인 위치 계산
//                float relativeX = touchX / v.getWidth() * 100;
//                float relativeY = touchY / v.getHeight() * 100;
//
//                Log.d("dpx", "" + relativeX);
//                Log.d("dpy", "" + relativeY);
//
//                return true;
//            }
//        });
//    }
//}

package com.example.myapplication3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        view1 = findViewById(R.id.view1);
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float touchX = event.getX(); // 터치 이벤트로 얻은 X 좌표
                float touchY = event.getY(); // 터치 이벤트로 얻은 Y 좌표

                // 상대적인 위치 계산
                float relativeX = touchX / v.getWidth() * 100;
                float relativeY = touchY / v.getHeight() * 100;

                Log.d("dpx", "" + relativeX);
                Log.d("dpy", "" + relativeY);

                drawPoint(view1, relativeX, relativeY);

                return true;
            }
        });
    }

    public void drawPoint(ImageView imageView, float relativeX, float relativeY) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        Bitmap mutableBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);

        Canvas canvas = new Canvas(mutableBitmap);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        float dotRadius = 10.0f;

        // 상대적인 위치를 기준으로 점을 그립니다.
        float x = (relativeX / 100) * canvas.getWidth();
        float y = (relativeY / 100) * canvas.getHeight();

        canvas.drawCircle(x, y, dotRadius, paint);

        imageView.setImageBitmap(mutableBitmap);
    }
}

