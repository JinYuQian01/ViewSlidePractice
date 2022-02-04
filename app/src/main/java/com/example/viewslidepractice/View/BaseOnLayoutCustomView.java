package com.example.viewslidepractice.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class BaseOnLayoutCustomView extends View {
    private int lastX;
    private int lastY;

    public BaseOnLayoutCustomView(Context context) {
        super(context);
    }

    public BaseOnLayoutCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseOnLayoutCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BaseOnLayoutCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int x=(int) event.getX();
        int y=(int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX=x;
                lastY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算移动的距离，用于修正View移动后的位置
                int offsetX=x-lastX;
                int offsetY=y-lastY;

                //放置View
                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                /**
                 * 方法二
                 * 基于offsetLeftAndRight&&offsetTopAndBottom方法进行坐标偏移修正
                 */
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
                break;
            default:
                break;
        }
        return  true;
    }
}
