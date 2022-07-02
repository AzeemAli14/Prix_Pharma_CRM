package com.prixpharma.crm.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.prixpharma.crm.R;
import com.wang.avi.AVLoadingIndicatorView;

public class SplashActivity extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        image = findViewById(R.id.imageView);
        Animation transition = AnimationUtils.loadAnimation(this, R.anim.transition);
        image.startAnimation(transition);

        AVLoadingIndicatorView avLoadingIndicatorView=new AVLoadingIndicatorView(SplashActivity.this);
        avLoadingIndicatorView.setIndicator("BallClipRotateMultipleIndicator");
        avLoadingIndicatorView.setIndicatorColor(R.color.colorPrimary);

        final Intent intent = new Intent(this, MainActivity.class);
        Thread thread = new Thread() {
            public void run () {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}