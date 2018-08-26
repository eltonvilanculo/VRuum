package com.example.nameless.vruum;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {
LinearLayout linearLayout ;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(500);
        animationDrawable.setExitFadeDuration(500);
    }

    @Override
    protected void onResume() {
        super.onResume();
        animationDrawable.start();
    }
}
