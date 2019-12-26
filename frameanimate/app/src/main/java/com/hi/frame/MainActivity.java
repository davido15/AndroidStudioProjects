package com.hi.frame;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Handler;

import static com.hi.frame.R.drawable.bat_anim;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable batAnimation;
    private ImageView batImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        batImage = (ImageView) findViewById(R.id.imageView2);
       // batImage.setBackgroundResource(bat_anim);
       // batAnimation=(AnimationDrawable) batImage.getBackground();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       // batAnimation.start();

        batImage.postDelayed(new Runnable() {
            @Override
            public void run() {
//batAnimation.stop();
                Animation startanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein_animation);
                batImage.startAnimation(startanim);
            }
        },150);
        return super.onTouchEvent(event);

    }

}
