package com.example.veski.homework5;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by veski on 2.10.2016 г..
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private List<ListItem> listData;
    private LayoutInflater inflater;

    public ListAdapter(List<ListItem> listData, Context ctx) {
        this.inflater = LayoutInflater.from(ctx);
        this.listData = listData;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.id.setText(Integer.toString(item.get_id()));
        holder.name.setText(item.get_some_name());
        holder.info.setText(item.get_some_info());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView name;
        private TextView info;


        public ListHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.textView);
            name = (TextView) itemView.findViewById(R.id.textView1);
            info = (TextView) itemView.findViewById(R.id.textView2);
        }
    }


}

