package com.example.viewslidepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.AnimationUtils;

import com.example.viewslidepractice.View.BaseOnAnimatorView;

public class Animator_Activity extends AppCompatActivity {
    private BaseOnAnimatorView baseOnAnimatorView;
    private BaseOnAnimatorView baseOnAnimatorView_f;
    private BaseOnAnimatorView baseOnAnimatorView_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        baseOnAnimatorView = new BaseOnAnimatorView(this);
        baseOnAnimatorView_f = new BaseOnAnimatorView(this);
        baseOnAnimatorView_s = new BaseOnAnimatorView(this);

        baseOnAnimatorView =findViewById(R.id.ani_view);
        baseOnAnimatorView_f = findViewById(R.id.ani_view_sec);
        baseOnAnimatorView_s = findViewById(R.id.ani_view_third);

        //设置动画，利用ObjectAnimator.ofFloat方法不仅可以移动View视图，还可以将响应区域移动过去
        ObjectAnimator translationX
                = ObjectAnimator.ofFloat(this.baseOnAnimatorView, "translationX", 0.0f, 200.0f, 0f);
        ObjectAnimator scaleX
                = ObjectAnimator.ofFloat(this.baseOnAnimatorView_f, "scaleX", 1.0f, 2.0f);
        ObjectAnimator rotationX
                = ObjectAnimator.ofFloat(this.baseOnAnimatorView_s, "rotationX", 0.0f, 90.0f, 0.0F);

        /**
         * 创建一个组合动画
         */
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(10000);
        animatorSet.play(translationX)
                .with(scaleX)
                .after(rotationX);
        animatorSet.start();
    }
}