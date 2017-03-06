package com.example.ian.applayout;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ian.applayout.floor.DrawerActivity;

/**
 * Created by Ian on 26/02/2017.
 */

public class RoleActivity extends AppCompatActivity {
    public static String TAG = "RoleActivity";

    private Account user;
    private AsyncClient orderSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
        //user = new Account();

        Button theFloorButton = (Button) (findViewById(R.id.theFloorButton));
        theFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Floor button was clicked!");
                Intent nextActivity = new Intent(RoleActivity.this, DrawerActivity.class);

                SharedPreferences settings = getSharedPreferences("LogInInfo",0);
                System.out.println("Email: "+settings.getString("email","could not find email"));
                System.out.println("Passsword: "+settings.getString("password","could not find password"));

                new MenuGetter(settings.getString("email","could not find email"),settings.getString("password","could not find password")).execute();
                startActivity(nextActivity);

            }
        });

        Button theBarButton = (Button) (findViewById(R.id.theBarButton));
        theBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Bar button was clicked!");
                //orderSender.sendMessage("Bar First Order\nSecond Order");
                Intent nextActivity = new Intent(RoleActivity.this, DrawerActivity.class);
                startActivity(nextActivity);
            }
        });

        Button theKitchenButton = (Button) (findViewById(R.id.theKitchenButton));
        theKitchenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Kitchen button was clicked!");
                //orderSender.execute("Kitchen First Order\nSecond Order");
                //orderSender.sendMessage("Kitchen First Order\nSecond Order");
                new AsyncClient().execute("Kitchen First Order\nSecond Order");
                Intent nextActivity = new Intent(RoleActivity.this, DrawerActivity.class);
                startActivity(nextActivity);
            }
        });
    }

}

