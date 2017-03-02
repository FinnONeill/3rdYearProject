package com.example.ian.thirdyearproject;

/**
 * Created by Ian on 15/02/2017.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.PeerListListener;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * A BroadcastReceiver that notifies of important Wi-Fi p2p events.
 */
public class WiFiDirectBroadcastReceiver extends BroadcastReceiver {

    private WifiP2pManager mManager;
    private Channel mChannel;
    private MainActivity mActivity;

    private List<WifiP2pDeviceList> peers = new ArrayList<WifiP2pDeviceList>();
    private WifiP2pManager.ConnectionInfoListener connectionListener;

    public WiFiDirectBroadcastReceiver(WifiP2pManager manager, Channel channel,
                                       MainActivity activity) {
        super();
        this.mManager = manager;
        this.mChannel = channel;
        this.mActivity = activity;
    }

    private PeerListListener myPeerListListener = new PeerListListener() {
        @Override
        public void onPeersAvailable(WifiP2pDeviceList peerList) {
            Collection<WifiP2pDevice> refreshedPeers = peerList.getDeviceList();

            //Toast.makeText(mActivity.getApplicationContext(), "Devices found...", Toast.LENGTH_SHORT).show();
            //Toast.makeText(mActivity.getApplicationContext(), peerList.toString(), Toast.LENGTH_LONG).show(); //Print all Device details as a toast.
            //mActivity.setBackgroundText(peerList.toString()+"\n Size: "+refreshedPeers.size());   //Print all Device details.
            //mActivity.setBackgroundText(refreshedPeers.iterator().next().deviceName);             //Print Device name.

            if (refreshedPeers.size() == 0) {
                Toast.makeText(mActivity.getApplicationContext(), "No devices found...", Toast.LENGTH_SHORT).show();
                return;
            }else {
                /*
                for(WifiP2pDevice s : refreshedPeers){
                    mActivity.addItems(s.deviceName);
                }*/
                /*
                for(int i=0; i<refreshedPeers.size(); i++){
                    mActivity.addItems(refreshedPeers.iterator().next().deviceName);
                    refreshedPeers.iterator().remove();
                }
                */
                mActivity.setBackgroundText("Device Name: "+refreshedPeers.iterator().next().deviceName+"\nDevice Address: "+ refreshedPeers.iterator().next().deviceAddress);
                mActivity.connect(refreshedPeers.iterator().next().deviceAddress);
            }
        }
    };

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {

            // Check to see if Wi-Fi is enabled and notify appropriate activity
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                // Wifi P2P is enabled
                //Toast.makeText(mActivity.getApplicationContext(), "P2P is enabled", Toast.LENGTH_SHORT).show();
                mActivity.setIsWifiP2pEnabled(true);
            } else {
                // Wi-Fi P2P is not enabled
                //Toast.makeText(mActivity.getApplicationContext(), "P2P is not enabled", Toast.LENGTH_SHORT).show();
                mActivity.setIsWifiP2pEnabled(false);
                //mActivity.resetData();
            }

        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
            // Call WifiP2pManager.requestPeers() to get a list of current peers

            // request available peers from the wifi p2p manager. This is an
            // asynchronous call and the calling activity is notified with a
            // callback on PeerListListener.onPeersAvailable()
            //Toast.makeText(mActivity.getApplicationContext(), "About to request peerList", Toast.LENGTH_SHORT).show();
            if (mManager != null) {
                //mManager.requestPeers(mChannel, myPeerListListener);
                mManager.requestPeers(mChannel, (PeerListListener) mActivity.getFragmentManager().findFragmentById(R.id.frag_list));
                //Toast.makeText(mActivity.getApplicationContext(), "Requesting peers!", Toast.LENGTH_SHORT).show();

            }

        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            // Respond to new connection or disconnections

            if (mManager == null) {
                return;
            }

            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO);

            if (networkInfo.isConnected()) {
                mActivity.setBackgroundText("Connected to another device");
                // We are connected with the other device, request connection
                // info to find group owner IP

                mManager.requestConnectionInfo(mChannel, connectionListener);
            }else{
                //mActivity.resetData();
            }

        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
            // Respond to this device's wifi state changing
            //WifiP2pDevice device = intent.getParcelableExtra(WifiP2pManager.EXTRA_WIFI_P2P_DEVICE);
        }
    }



}

