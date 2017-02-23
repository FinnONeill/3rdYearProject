package com.example.finn.pos_app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000; //4 Seconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent logInItent = new Intent(Main.this, Login_Activity.class);
                startActivity(logInItent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
