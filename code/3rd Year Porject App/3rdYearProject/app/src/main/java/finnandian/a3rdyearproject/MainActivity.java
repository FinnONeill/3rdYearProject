package finnandian.a3rdyearproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView mTextView;
    public ListView mListView;

    private Button searchBtn, playBtn;
    private WifiP2pManager mManager;
    private WifiP2pManager.Channel mChannel;
    private BroadcastReceiver mReciever;
    private IntentFilter mIntentFilter;
    private ArrayAdapter<String> wifiP2pArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIntentFilter = new IntentFilter();
        //  Indicates a change in the Wi-Fi P2P status.
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);

        // Indicates a change in the list of available peers.
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);

        // Indicates the state of Wi-Fi P2P connectivity has changed.
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);

        // Indicates this device's details have changed.
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        mTextView = (TextView)findViewById(R.id.heading);
        mListView = (ListView)findViewById(R.id.listView);

        wifiP2pArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        mListView.setAdapter(wifiP2pArrayAdapter);

        searchBtn = (Button)findViewById(R.id.searchButton);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(v);
            }
        });

        playBtn = (Button)findViewById(R.id.playButton);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(v);
            }
        });

        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);
        mReciever = new WifiDirectBroadcastReceiver(mManager, mChannel, this);
    }

    public void search(View view){

        mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess(){
                mTextView.setText("Wifi-Firect: Searching...");
            }

            @Override
            public void onFailure(int reasonCode){
                mTextView.setText("Error: Code " + reasonCode);
            }
        });
    }

    public void play(View view){
        Toast.makeText(getApplicationContext(), "This will start the messages once you are connected", Toast.LENGTH_LONG).show();
    }

    public void displayPeers(WifiP2pDeviceList peerList){

        wifiP2pArrayAdapter.clear();

        for(WifiP2pDevice peer : peerList.getDeviceList()){
            wifiP2pArrayAdapter.add(peer.deviceName + "\n" + peer.deviceAddress);
        }

    }

    /** register the BroadcastReceiver with the intent values to be matched */
    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(mReciever, mIntentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(mReciever);
    }

}
