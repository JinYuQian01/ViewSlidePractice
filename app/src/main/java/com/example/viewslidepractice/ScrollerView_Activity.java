package com.example.viewslidepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Scroller;

import com.example.viewslidepractice.View.BaseOnScrollerView;

public class ScrollerView_Activity extends AppCompatActivity {
    private Scroller mScroller;
    private BaseOnScrollerView baseOnScrollerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller_view);
        baseOnScrollerView = new BaseOnScrollerView(this);
        baseOnScrollerView.smoothScrollTo(-400,0);
    }
}