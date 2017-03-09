package com.example.ian.applayout.floor;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ian.applayout.R;
import com.example.ian.applayout.floor.contentLists.OrderReceived;

/**
 * Created by Finn on 08/03/2017.
 */

public class ReceivedDetailFragment extends android.support.v4.app.Fragment{

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "rec_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private OrderReceived.ItemMenu mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ReceivedDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = OrderReceived.ITEM_MAP_RECEIVED.get(getArguments().getString(ARG_ITEM_ID));
            System.out.println("RDetailFrag Item Name: "+mItem.id);
            System.out.println("RDetailFrag Item Name: "+mItem.content);
            System.out.println("RDetailFrag Item Details: "+mItem.details);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.received_toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
                System.out.println("AppbarLayout == null");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.received_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.received_detail)).setText(mItem.details);
        }

        return rootView;
    }

}
