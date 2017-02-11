package finnandian.a3rdyearproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Finn on 11/02/2017.
 */

public class WifiDirectBroadcastReceiver extends BroadcastReceiver{

    private WifiP2pManager mManager;
    private WifiP2pManager.Channel mChannel;
    private MainActivity mActivity;
    private List<WifiP2pDevice> mPeers;
    private List<WifiP2pConfig> mConfigs;

    public WifiDirectBroadcastReceiver (WifiP2pManager manager, WifiP2pManager.Channel channel, MainActivity activity){

        super();
        this.mManager = manager;
        this.mChannel = channel;
        this.mActivity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            // Determine if Wifi P2P mode is enabled or not, alert
            // the Activity.
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                mActivity.mTextView.setText("Wifi-Direct: Enabled");
            } else {
                mActivity.mTextView.setText("Wifi-Direct: Disabled");
            }
        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {

            //call WifiP2pManager.requestPeers() to get a list of current peers.
            mPeers = new ArrayList<WifiP2pDevice>();
            mConfigs = new ArrayList<WifiP2pConfig>();

            if(mManager != null){
                WifiP2pManager.PeerListListener peerListListener = new WifiP2pManager.PeerListListener(){

                    @Override
                    public void onPeersAvailable(WifiP2pDeviceList peerList){
                        mPeers.clear();
                        mPeers.addAll(peerList.getDeviceList());

                        mActivity.displayPeers(peerList);

                        mPeers.addAll(peerList.getDeviceList());

                        for(int i=0; i<peerList.getDeviceList().size(); i++){
                            WifiP2pConfig config = new WifiP2pConfig();
                            config.deviceAddress = mPeers.get(i).deviceAddress;
                            mConfigs.add(config);
                        }
                    }
                };

            }

        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {

            //Respond to new connection or disconections.

        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {

            //Responf to this devices wifi state changing.

        }
    }



}
