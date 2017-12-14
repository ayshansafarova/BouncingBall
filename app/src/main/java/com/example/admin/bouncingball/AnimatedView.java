package com.example.admin.bouncingball;

/**
 * Created by Admin on 08.12.2017.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import java.sql.Time;


public class AnimatedView extends AppCompatImageView{

    private Context mContext;
    boolean start=false;
    int x = -1;
    int y = -1;
    public int xVelocity = 16;
    public int yVelocity = 8;
    private Handler h;
    private final int FRAME_RATE = 30;

    public AnimatedView(Context context, AttributeSet attrs)  {
        super(context, attrs);
        mContext = context;
        h = new Handler();
    }
    private Runnable r = new Runnable() {

        @Override
        public void run() {
            invalidate();
        }
    };
    protected void onDraw(Canvas c) {

        start=true;

        BitmapDrawable ball = (BitmapDrawable) mContext.getResources().getDrawable(R.mipmap.bouncing_ball_round);
        if (x<0 && y <0) {
            x = this.getWidth()/2;
            y = this.getHeight()/2;
        } else {
            x += xVelocity;
            y += yVelocity;
            if ((x > this.getWidth() - ball.getBitmap().getWidth()) || (x < 0)) {
                xVelocity = xVelocity*-1;
            }
            if ((y > this.getHeight() - ball.getBitmap().getHeight()) || (y < 0)) {
                yVelocity = yVelocity*-1;
            }
        }
        c.drawBitmap(ball.getBitmap(), x, y, null);
        h.postDelayed(r, FRAME_RATE);
    }


}