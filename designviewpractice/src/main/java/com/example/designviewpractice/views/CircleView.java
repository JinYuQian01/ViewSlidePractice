package com.example.designviewpractice.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.util.MeasureUnit;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.designviewpractice.R;

public class CircleView extends View {
    private int mColor;
    Paint paint;
    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray tA=context.obtainStyledAttributes(attrs,R.styleable.CircleView);//这里获得属性里面的对象
        mColor=tA.getColor(R.styleable.CircleView_circle_color,Color.RED);//这里根据类型获得具体值
        tA.recycle();//一定要回收对象
        init();
    }

    /**
     * 重写onMeasure方法解决wrap_content==match_content的效果问题
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode== MeasureSpec.AT_MOST && heightSpecMode== MeasureSpec.AT_MOST) {
            setMeasuredDimension(200,200);
        }else if (widthMeasureSpec == MeasureSpec.AT_MOST){
            setMeasuredDimension(200,heightSpecSize);
        }else if (heightMeasureSpec == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSpecSize,200);
        }
    }

    /**
     * 初始化画笔
     */
    private void init() {
        paint=new Paint();
        paint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int paddingLeft=getPaddingLeft();
        final int paddingRight=getPaddingRight();
        final int paddingTop=getPaddingTop();
        final int paddingBottom=getPaddingBottom();

        int width=getWidth()-paddingLeft-paddingRight;
        int height=getHeight()-paddingTop-paddingBottom;
        int radius=Math.min(width,height)/2;
        canvas.drawCircle(paddingLeft+width/2,paddingTop+height/2,radius,paint);
    }
}
