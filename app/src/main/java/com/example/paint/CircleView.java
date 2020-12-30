package com.example.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class CircleView extends View {
    private  Paint paint;
    private  int x,y;
    private  int r=50;
    private  String imgg;
    private  Context context;


    public CircleView(Context context) {
        this(context,null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniPaint();
    }
    private void iniPaint() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x = r;
        y = r;
        canvas.drawCircle(x,y,r,paint);
        paint.setColor(Color.BLUE);
        paint.setTextSize(30);
        paint.setStrokeWidth(4);
        canvas.drawText("这是美好的一天",20,20,paint);


        Bitmap drawable = BitmapFactory.decodeResource(getResources(),R.mipmap.a);
        canvas.drawBitmap(drawable,0,0,paint);
        imgg=drawable.toString()+"jpg";
        Log.e("TAG111",imgg);
    }


}
