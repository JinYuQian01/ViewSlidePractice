package com.example.viewslidepractice.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class BaseOnScrollerView extends View {
    private Scroller xScroller;
    private Context mContext;

    public BaseOnScrollerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        xScroller=new Scroller(getContext());
    }

    public BaseOnScrollerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context,attrs);
    }

    public BaseOnScrollerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context,attrs);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        //xScroller=new Scroller(getContext());
        if (xScroller.computeScrollOffset()) {
            ((View)getParent()).scrollTo(xScroller.getCurrX(),
                    xScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX,int destY){
        //xScroller=new Scroller(getContext());
        int scrollX=getScrollX();
        int delta=destX-scrollX;
        xScroller.startScroll(scrollX,0,delta,200);
        invalidate();
    }
}
