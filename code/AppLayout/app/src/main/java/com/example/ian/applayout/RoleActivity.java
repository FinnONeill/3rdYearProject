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
 * RoleActivity is to represent different areas of a bar and restaurant,
 * so in future versions the process can be streamlined to only send orders
 * to relevant areas of the restaurant.
 */

public class RoleActivity extends AppCompatActivity {
    public static String TAG = "RoleActivity";
    private String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        //Access userInfo from cache.
        SharedPreferences settings = getSharedPreferences("LogInInfo",0);
        username = settings.getString("email","could not find email");
        password = settings.getString("password","could not find password");

        //Check for new orders every X seconds.
        /*
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                new RecieveOrders(username,password).execute();
            }
        };
        timer.schedule(timerTask, 0, 10000);
        */
        Button theFloorButton = (Button) (findViewById(R.id.theFloorButton));
        theFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(RoleActivity.this, DrawerActivity.class);
                startActivity(nextActivity);
            }
        });

        Button theBarButton = (Button) (findViewById(R.id.theBarButton));
        theBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SendOrder(RoleActivity.this,username,password,"182","x3 Ice Cream","10.99").execute();
                Intent nextActivity = new Intent(RoleActivity.this, DrawerActivity.class);
                startActivity(nextActivity);
            }
        });

        Button theKitchenButton = (Button) (findViewById(R.id.theKitchenButton));
        theKitchenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RecieveOrders(username,password).execute();
                Intent nextActivity = new Intent(RoleActivity.this, DrawerActivity.class);
                startActivity(nextActivity);
            }
        });
    }

}

