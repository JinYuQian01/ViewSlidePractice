package com.example.viewslidepractice.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class BaseOnScrollerView extends View {
    private Scroller xScroller;
    private Context mContext;
    public BaseOnScrollerView(Context context) {
        super(context);
        this.xScroller=new Scroller(context);
    }

    public BaseOnScrollerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseOnScrollerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BaseOnScrollerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (xScroller.computeScrollOffset()) {
            ((View)getParent()).scrollTo(xScroller.getCurrX(),
                    xScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX,int destY){
        int scrollX=getScrollX();
        int delta=destX-scrollX;
        xScroller.startScroll(scrollX,0,delta,200);
        invalidate();
    }
}
