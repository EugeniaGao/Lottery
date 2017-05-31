package com.jing.www.lotterydemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/5/31.
 */

public class LotteryView extends LinearLayout{


    private Paint mPaint;
    //0.指定半径和抽奖券的边沿的半圆距离
    private float mRadious =6;
    private float mGap =5;
    private int mCircleNumX;
    private int mCircleNumY;


    public LotteryView(Context context) {
        super(context);
    }

    public LotteryView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        //1.画笔初始化
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);

    }

    public LotteryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //2.指定绘制的数量
        mCircleNumX=(int)((w-mGap)/(mRadious*2+mGap));
        mCircleNumY=(int)((h-mGap)/(mRadious*2+mGap));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //3.指定每一个圆心的位置并画圆和填充中间矩形
        for (int i = 0; i <mCircleNumX ; i++) {
        float radiousX=mGap+mRadious+((mRadious*2+mGap)*i);
        float radiousY=mGap+mRadious+((mRadious*2+mGap)*i);
            //绘制上面
            canvas.drawCircle(radiousX,0,mRadious,mPaint);
            //绘制左面
            canvas.drawCircle(0,radiousY,mRadious,mPaint);
            //绘制右面
            canvas.drawCircle(getWidth(),radiousY,mRadious,mPaint);
            //绘制下面
            canvas.drawCircle(radiousX,getHeight(),mRadious,mPaint);

        }
    }
}
