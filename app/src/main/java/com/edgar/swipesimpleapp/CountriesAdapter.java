package com.edgar.swipesimpleapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edgar.swipesimpleapp.model.Country;
import com.edgar.swipesimpleapp.model.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>{

    private LayoutInflater inflater;
    private List<Country> origin;
    private List<Country> searchR;
    Context context;

    public CountriesAdapter(LayoutInflater inflater, List<Country> origin, Context context) {
        this.inflater = inflater;
        this.origin = origin;
        this.searchR = new ArrayList<>();
        this.searchR.addAll(origin);
        this.context = context;
    }

    @Override
    public CountriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_countries, parent, false);
        return new CountriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountriesViewHolder holder, int position) {
        Country country = searchR.get(position);
        holder.countriesTv.setText(country.getCountry());
        holder.countriesTv2.setText(context.getString(R.string.population) + country.getPopulation());
    }

    @Override
    public int getItemCount() {
        return searchR.size();
    }

    static class CountriesViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.countriesTv)
        TextView countriesTv;

        @Bind(R.id.countriesTv2)
        TextView countriesTv2;


        public CountriesViewHolder (View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }

    void filter(String searchLine) {
        Log.d("FILTER", "query " + searchLine);
        if (searchLine.isEmpty()) {
            searchR = new ArrayList<>();
            searchR.addAll(origin);
            notifyDataSetChanged();
            return;
        }
        searchR.clear();
        for (Country coun : origin) {
            if (coun.getCountry().toLowerCase().contains(searchLine.toLowerCase())) {
                searchR.add(coun);
            }
        }
        notifyDataSetChanged();

    }
}
