package com.pp.chouti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.view.animation.AnimationUtils.loadAnimation;

public class MainActivity extends AppCompatActivity {

    private ImageView eventIcon;
    private RelativeLayout eventLayout;
    private boolean eventState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEventDrawer();
    }

    /**
     * 显示的活动小抽屉
     */
    private void initEventDrawer() {
        eventIcon = (ImageView) findViewById(R.id.iv_main_event_close);
        eventLayout = (RelativeLayout) findViewById(R.id.rl_main_event);
        eventState = false;
        final Animation open = loadAnimation(this, R.anim.dialog_in);
        final Animation close = AnimationUtils.loadAnimation(this, R.anim.dialog_out);
        close.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                System.out.println("close animation start");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                eventLayout.setVisibility(View.INVISIBLE);
            }
        });
        open.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });


        eventIcon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("点击了eventIcon  ,并且eventState=" + eventState);
                eventState = !eventState;
                if (eventState) {
                    eventLayout.setVisibility(View.VISIBLE);
                    eventLayout.startAnimation(open);
                } else {
                    eventLayout.startAnimation(close);
                }
            }
        });
    }
}
