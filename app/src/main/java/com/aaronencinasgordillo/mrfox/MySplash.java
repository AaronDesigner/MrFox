package com.aaronencinasgordillo.mrfox;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MySplash extends AppCompatActivity {
    public static final int segundos = 3;
    public static final int milisegundos = segundos * 1000;
    public static final int delay = 2;
    private ProgressBar progressBar;
    ImageView imageView;
    Animation rotate;
    TextView mytitle;
    Typeface tipography;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        imageView = (ImageView)findViewById(R.id.imgfox);
        //view = (View)findViewById(R.id.view);
        mytitle = (TextView)findViewById(R.id.txtMyTitle);
        tipography = Typeface.createFromAsset(getAssets(),"fonts/AmaticSC-Regular.ttf");
        mytitle.setTypeface(tipography);
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.pulse_anim);
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise);
        mytitle.startAnimation(shake);
        imageView.startAnimation(rotate);
        //imageView.startAnimation(shake);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(maximo_progreso());
        empezar_animacion();
        progressBar.getIndeterminateDrawable().setColorFilter(Color.rgb(130,38,87), PorterDuff.Mode.SRC_IN);
    }
    private void empezar_animacion() {
        new CountDownTimer(milisegundos,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(establecer_progreso(millisUntilFinished));
            }
            @Override
            public void onFinish() {
                Intent loading = new Intent(MySplash.this,MyLogin.class);
                startActivity(loading);
                finish();
            }
        }.start();
    }
    private int maximo_progreso() {
        return segundos -delay;
    }
    private int establecer_progreso(long miliseconds){
        return (int)((miliseconds - miliseconds)/1000);
    }
}
