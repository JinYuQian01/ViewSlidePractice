package com.example.viewslidepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

public class Layout_Method_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_method);
        //MotionEvent motionEvent = new MotionEvent(getBaseContext());
        LinearLayout linearLayout = new LinearLayout(this);
    }
}