package com.example.admin.bouncingball;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MainActivity extends Activity {

    AnimatedView aw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //aw.start=false;
                aw.xVelocity = 0;
                aw.yVelocity = 0;
                break;
            case MotionEvent.ACTION_UP:
                aw.start = true;
                break;
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event){
        switch(KeyCode){
            case KeyEvent.KEYCODE_A:
                aw.xVelocity = 0;
                aw.yVelocity = 0;
                break;
            case KeyEvent.KEYCODE_W:
                aw.start = true;
                break;
        }
        return true;
    }
}
//        start_btn.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                aw.start=true;
//            }
//        });

//        stop_btn.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                aw.start=false;
//            }
//        });

