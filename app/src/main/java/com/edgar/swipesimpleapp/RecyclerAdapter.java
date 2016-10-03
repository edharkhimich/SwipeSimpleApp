package com.edgar.swipesimpleapp;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.edgar.swipesimpleapp.model.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemsViewHolder> {

    private LayoutInflater inflater;
    private List<Item> originItems;
    private List<Item> searchItems;

    public RecyclerAdapter(LayoutInflater inflater, List<Item> originItems) {
        this.inflater = inflater;
        this.originItems = originItems;
        this.searchItems = new ArrayList<>();
        this.searchItems.addAll(originItems);
    }

    @Override
    public RecyclerAdapter.ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        Item item = searchItems.get(position);
        holder.lineTv.setText(item.getName());
        holder.lineTv2.setText(item.getMobile());
    }

    @Override
    public int getItemCount() {
        return searchItems.size();
    }

    static class ItemsViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.lineTv)
        TextView lineTv;

        @Bind(R.id.lineTv2)
        TextView lineTv2;

        public ItemsViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }

    void filter(String searchLine) {
        if (searchLine.isEmpty()) {
            searchItems = new ArrayList<>();
            searchItems.addAll(originItems);
            notifyDataSetChanged();
            return;
        }
        searchItems.clear();
        for (Item item : originItems) {
            if (item.getName().toLowerCase().contains(searchLine.toLowerCase())) {
                searchItems.add(item);
            }
        }
        notifyDataSetChanged();

    }
}
