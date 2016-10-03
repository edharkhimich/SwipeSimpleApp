package com.edgar.swipesimpleapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edgar.swipesimpleapp.model.Item;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FragmentOne extends Fragment {

    @Bind(R.id.recycler_view_fr1)
    RecyclerView recyclerView;

    private ArrayList<Item> list;
    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_layout, container, false);
        ButterKnife.bind(this, view);

        list = new ArrayList<Item>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(getActivity().getLayoutInflater(), contactListOn(list));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(getActivity());
    }

    private ArrayList<Item> contactListOn(ArrayList<Item> contactList) {
        contactList.add(new Item("Nicolas Jaar", "555-33-777"));
        contactList.add(new Item("Mike Posner", "777-11-667"));
        contactList.add(new Item("Mana Island", "999-00-111"));
        contactList.add(new Item("George Michael", "222-55-222"));
        contactList.add(new Item("Antonio Banderas", "754-21-987"));

        return contactList;
    }

    public RecyclerAdapter getAdapter() {
        return adapter;
    }
}
