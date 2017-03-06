package com.example.finn.testproject;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Finn on 01/03/2017.
 */

public class PeerList implements WifiP2pManager.PeerListListener {

    private List<WifiP2pDevice> peers = new ArrayList<WifiP2pDevice>();
    private WifiP2pDevice device;
    private boolean ranOnce = false;

    private WifiP2pManager mManager;
    private WifiP2pManager.Channel mChannel;
    private  MainActivity mActivity;

    public PeerList(WifiP2pManager mManager, WifiP2pManager.Channel mChannel, MainActivity mActivity){
        this.mManager = mManager;
        this.mChannel = mChannel;
        this.mActivity = mActivity;
    }

    @Override
    public void onPeersAvailable(WifiP2pDeviceList peerList) {
        if(ranOnce){
            ranOnce = false;
            return;
        }
        ranOnce = true;

        Collection<WifiP2pDevice> deviceList = peerList.getDeviceList();

        if (deviceList.size() == 0) {
            System.out.println("No devices found...");
            return;
        }

        System.out.println("onPeersAvailable()!!!");


        for(WifiP2pDevice s : deviceList){
            System.out.println("Device Name: "+s.deviceName + "\nStatus: "+getDeviceStatus(s.status)+"\nGroup Owner: "+s.isGroupOwner());
        }
        Toast.makeText(mActivity.getApplicationContext(), "P2P is not enabled", Toast.LENGTH_SHORT).show();
        initiateConnection(deviceList.iterator().next());
    }

    public void initiateConnection(WifiP2pDevice device){
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;

        System.out.println("Connecting...");
        mManager.connect(mChannel, config, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
                System.out.println("Connected!!!");
            }

            @Override
            public void onFailure(int reason) {
                System.out.println("Connection Failed");
            }
        });
    }

    /**
     * @return this device
     */
    public WifiP2pDevice getDevice() {
        return device;
    }

    private static String getDeviceStatus(int deviceStatus) {

        //Log.d(MainActivity.TAG, "Peer status :" + deviceStatus);
        switch (deviceStatus) {
            case WifiP2pDevice.AVAILABLE:
                return "Available";
            case WifiP2pDevice.INVITED:
                return "Invited";
            case WifiP2pDevice.CONNECTED:
                return "Connected";
            case WifiP2pDevice.FAILED:
                return "Failed";
            case WifiP2pDevice.UNAVAILABLE:
                return "Unavailable";
            default:
                return "Unknown";

        }
    }

    public void updateThisDevice(WifiP2pDevice device){
        this.device = device;
        System.out.println("My Device Name: "+device.deviceName+"\nStatus: "+getDeviceStatus(device.status)+"\nGroup Owner: "+device.isGroupOwner());

    }

    public interface DeviceActionListener {

        void showDetails(WifiP2pDevice device);

        void cancelDisconnect();

        void connect(WifiP2pConfig config);

        void disconnect();

    }
}
