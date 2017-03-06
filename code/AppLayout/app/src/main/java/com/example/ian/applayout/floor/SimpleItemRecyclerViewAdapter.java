package com.example.ian.applayout.floor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ian.applayout.Item;
import com.example.ian.applayout.MenuGetter;
import com.example.ian.applayout.R;
import com.example.ian.applayout.floor.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Item> mValues;
    private Context context;

    public SimpleItemRecyclerViewAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        mValues = new ArrayList<Item>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.setItem(mValues.get(position));
        holder.getIdView().setText(mValues.get(position).getId());
        holder.getContentView().setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!DrawerActivity.mTwoPane){
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.getItem().getId());
                    context.startActivity(intent);
                }else {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.getItem().getId());
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    ((DrawerActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragment).commit();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        public void setItem(Item item){
            mItem = item;
        }

        public Item getItem(){
            return mItem;
        }

        public TextView getIdView(){return mIdView;};

        public TextView getContentView(){return mContentView;}

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}