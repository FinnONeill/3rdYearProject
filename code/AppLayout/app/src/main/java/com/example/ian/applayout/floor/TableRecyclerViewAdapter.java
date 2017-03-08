package com.example.ian.applayout.floor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ian.applayout.R;
import com.example.ian.applayout.floor.contentLists.OrderTables.DummyItemTables;

import java.util.List;

/**
 * Created by Ian on 06/03/2017.
 */

public class TableRecyclerViewAdapter extends RecyclerView.Adapter<TableRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItemTables> nValues;
    private Context context;

    public TableRecyclerViewAdapter(Context context, List<DummyItemTables> items) {
        this.context = context;
        nValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.nItem = nValues.get(position);
        holder.nIdView.setText(nValues.get(position).id);
        holder.nContentView.setText(nValues.get(position).content);

        holder.nView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MenuListActivity.class);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View nView;
        public final TextView nIdView;
        public final TextView nContentView;
        public DummyItemTables nItem;

        public ViewHolder(View view) {
            super(view);
            nView = view;
            nIdView = (TextView) view.findViewById(R.id.id);
            nContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nContentView.getText() + "'";
        }
    }
}