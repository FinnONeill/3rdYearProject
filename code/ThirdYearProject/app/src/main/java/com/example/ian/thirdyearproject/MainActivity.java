package com.example.ian.thirdyearproject;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static String TAG = "MainActivity";

    private WifiP2pManager mManager;
    private Channel mChannel;
    private BroadcastReceiver mReceiver;

    private boolean isWifiP2pEnabled = false;
    private  boolean retryChannel = false;
    private final IntentFilter mIntentFilter = new IntentFilter();

    private TextView backgroundText;
    private ListView peerList;
    private ArrayList<String> peerListItems = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private String deviceAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);


        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        final Button theConnectButton = (Button)(findViewById(R.id.theConnectButton));
        theConnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Clicked Connect Button", Toast.LENGTH_SHORT).show();
                search(theConnectButton);
                peerListItems.clear();
            }
        });

        backgroundText = (TextView) findViewById(R.id.backgroundText);
/*
        peerList = (ListView) findViewById(R.id.peerListView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, peerListItems);
        peerList.setAdapter(adapter);
        peerList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        peerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //peerList.setItemChecked(position, true);
                view.setBackgroundColor(Color.LTGRAY);
                setBackgroundText(Integer.toString(position));
            }
        });*/
    }

    public void setIsWifiP2pEnabled(boolean isWifiP2pEnabled){
        this.isWifiP2pEnabled = isWifiP2pEnabled;
    }

    /* register the broadcast receiver with the intent values to be matched */
    @Override
    protected void onResume() {
        super.onResume();
        mReceiver = new WiFiDirectBroadcastReceiver(mManager, mChannel, this);
        registerReceiver(mReceiver, mIntentFilter);
    }
    /* unregister the broadcast receiver */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    public void setBackgroundText(String text){
        backgroundText.setText(text);
    }

    public void addItems(String newItem){
        peerListItems.add(newItem);
        adapter.notifyDataSetChanged();
    }

    public void setDeviceAddress(String address){
        deviceAddress = address;
    }

    public void resetItems(){
        peerListItems.clear();
    }

    public void search(View view){

        mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess(){
                Toast.makeText(getApplicationContext(), "It's successfully searching!", Toast.LENGTH_SHORT).show();
                isWifiP2pEnabled = true;
            }

            @Override
            public void onFailure(int reasonCode){
                Toast.makeText(getApplicationContext(), "Searching failed!", Toast.LENGTH_SHORT).show();
                isWifiP2pEnabled = false;
            }
        });
    }



    public void connect(String deviceAddress) {
        //obtain a peer from the WifiP2pDeviceList
        //WifiP2pDevice device = deviceToConnect;

        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = deviceAddress;
        config.wps.setup = WpsInfo.PBC;

        mManager.connect(mChannel, config, new ActionListener() {

            @Override
            public void onSuccess() {
                //success logic
                Toast.makeText(getApplicationContext(), "Connecting...", Toast.LENGTH_SHORT).show();
                /*mManager.requestGroupInfo(mChannel, new WifiP2pManager.GroupInfoListener() {
                    @Override
                    public void onGroupInfoAvailable(WifiP2pGroup group) {
                        String groupPassword = group.getPassphrase();
                    }
                });*/
            }

            @Override
            public void onFailure(int reason) {
                //failure logic
                Toast.makeText(MainActivity.this, "Connect failed. Retry.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void disconnect(){
        mManager.removeGroup(mChannel, new ActionListener() {

            @Override
            public void onFailure(int reasonCode) {
                Log.d(TAG, "Disconnect failed. Reason :" + reasonCode);
            }

            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "Removed from group",
                        Toast.LENGTH_SHORT).show();
            }

        });
    }



    public void onConnectionInfoAvailable(final WifiP2pInfo info) throws UnknownHostException {

        // InetAddress from WifiP2pInfo struct.
        InetAddress groupOwnerAddress = InetAddress.getByName(info.groupOwnerAddress.getHostAddress());

        // After the group negotiation, we can determine the group owner
        // (server).
        if (info.groupFormed && info.isGroupOwner) {
            // Do whatever tasks are specific to the group owner.
            // One common case is creating a group owner thread and accepting
            // incoming connections.
        } else if (info.groupFormed) {
            // The other device acts as the peer (client). In this case,
            // you'll want to create a peer thread that connects
            // to the group owner.
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}