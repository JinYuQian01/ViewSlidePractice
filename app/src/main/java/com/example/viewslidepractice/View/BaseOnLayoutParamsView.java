package com.example.viewslidepractice.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class BaseOnLayoutParamsView extends View {

    private int lastX;
    private int lastY;

    public BaseOnLayoutParamsView(Context context) {
        super(context);
    }

    public BaseOnLayoutParamsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseOnLayoutParamsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BaseOnLayoutParamsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 通过改变布局参数实现View的滑动
     * @param event 点击事件
     * @return
     */
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

                LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin=getLeft()+offsetX;
                layoutParams.topMargin=getTop()+offsetY;
                setLayoutParams(layoutParams);
                break;
            default:
                break;
        }
        return  true;
    }
}
