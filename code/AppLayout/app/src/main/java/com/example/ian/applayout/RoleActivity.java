package com.example.ian.applayout;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ian.applayout.floor.DrawerActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Ian on 26/02/2017.
 */

public class RoleActivity extends AppCompatActivity {
    public static String TAG = "RoleActivity";

    private Account user;

    private String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
        //user = new Account();
        SharedPreferences settings = getSharedPreferences("LogInInfo",0);
        username = settings.getString("email","could not find email");
        password = settings.getString("password","could not find password");
        /*
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //your code
            }
        };
        timer.schedule(timerTask, 0, 10000);
        */
        Button theFloorButton = (Button) (findViewById(R.id.theFloorButton));
        theFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Floor button was clicked!");
                Intent nextActivity = new Intent(RoleActivity.this, DrawerActivity.class);
                new MenuGetter(username,password).execute();
                startActivity(nextActivity);
            }
        });

        Button theBarButton = (Button) (findViewById(R.id.theBarButton));
        theBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Bar button was clicked!");
                new SendOrder(username,password,"182","x3 Ice Cream","10.99").execute();
                Intent nextActivity = new Intent(RoleActivity.this, DrawerActivity.class);
                startActivity(nextActivity);
            }
        });

        Button theKitchenButton = (Button) (findViewById(R.id.theKitchenButton));
        theKitchenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Kitchen button was clicked!");
                new RecieveOrders(username,password).execute();
                Intent nextActivity = new Intent(RoleActivity.this, DrawerActivity.class);
                startActivity(nextActivity);
            }
        });
    }

}

