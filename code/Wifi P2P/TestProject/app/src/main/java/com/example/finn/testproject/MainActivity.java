package com.example.finn.testproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Wifi P2P Test";
    private WifiP2pManager mManager;
    private WifiP2pManager.Channel mChannel;
    private BroadcastReceiver mReceiver;
    private PeerList pList;

    private IntentFilter mIntentFilter;

    private boolean isWifiP2pEnabled = false;

    private Button discoverButton;
    private ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);
        deletePersistentGroups();
        mReceiver = new WifiDirectBroadcastReceiver(mManager, mChannel, this);
        pList = new PeerList(mManager, mChannel, this);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        discoverButton = (Button) (findViewById(R.id.discover_btn));
        discoverButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                search();
            }
        });
    }

    public boolean setIsWifiP2pEnabled(boolean isWifiP2pEnabled){
        return this.isWifiP2pEnabled = isWifiP2pEnabled;
    }

    /* register the broadcast receiver with the intent values to be matched */
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    /* unregister the broadcast receiver */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    public boolean search(){
        if(isWifiP2pEnabled){
            mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
                @Override
                public void onSuccess() {
                    Toast.makeText(MainActivity.this, "Discovery Initiated", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(int reason) {
                    if(reason == 0){
                        Toast.makeText(MainActivity.this, "Discovery Failed : P2P_UNSUPPORTED", Toast.LENGTH_SHORT).show();
                    }else if(reason == 1){
                        Toast.makeText(MainActivity.this, "Discovery Failed : ERROR", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Discovery Failed : BUSY", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
        return isWifiP2pEnabled;
    }

    private void deletePersistentGroups(){
        try {
            Method[] methods = WifiP2pManager.class.getMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equals("deletePersistentGroup")) {
                    // Delete any persistent group
                    for (int netid = 0; netid < 32; netid++) {
                        methods[i].invoke(mManager, mChannel, netid, null);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
