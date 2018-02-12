package com.sujit.enva2016;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Rajkumar on 01-10-2016.
 */
public class LogoClass extends Activity {

    Thread logoThread;
    Animation anim;
    ImageView splashIcon;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.logo_activity);

        splashIcon = (ImageView) findViewById(R.id.splashIcon);
        anim = AnimationUtils.loadAnimation(this,R.anim.fadein);
        splashIcon.startAnimation(anim);

    }

    @Override
    protected void onStart() {
        super.onStart();

        logoThread = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(4000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {

                    Intent  i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
            }
        };
        logoThread.start();
    }


}
