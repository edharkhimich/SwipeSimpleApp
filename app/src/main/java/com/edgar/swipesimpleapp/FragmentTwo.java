package com.edgar.swipesimpleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edgar.swipesimpleapp.model.Country;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FragmentTwo extends Fragment {

    @Bind(R.id.recycler_view_fr2)
    RecyclerView recyclerView;

    private ArrayList<Country> countriesList;
    private CountriesAdapter countriesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_layout, container, false);
        ButterKnife.bind(this, view);

        countriesList = new ArrayList<Country>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        countriesAdapter = new CountriesAdapter(getActivity().getLayoutInflater(), countriesListOn(countriesList), getActivity());
        recyclerView.setAdapter(countriesAdapter);

        return view;
    }

    private ArrayList<Country> countriesListOn(ArrayList<Country> countriesList) {
        countriesList.add(new Country("United States", "324,578,000"));
        countriesList.add(new Country("India", "1,330,780,000"));
        countriesList.add(new Country("Indonesia", "260,581,000"));
        countriesList.add(new Country("Brazil", "206,716,000"));
        countriesList.add(new Country("Pakistan", "194,370,000"));
        countriesList.add(new Country("Nigeria", "186,988,000"));
        countriesList.add(new Country("Bangladesh", "161,154,000"));
        countriesList.add(new Country("Russia", "146,654,366"));
        countriesList.add(new Country("Mexico", "128,632,000"));
        countriesList.add(new Country("Japan", "127,110,047"));

        return countriesList;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(getActivity());
        super.onDestroyView();
    }

    public CountriesAdapter getAdapter() {
        return countriesAdapter;
    }
}
