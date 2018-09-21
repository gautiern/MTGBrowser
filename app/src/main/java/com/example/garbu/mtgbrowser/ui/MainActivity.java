package com.example.garbu.mtgbrowser.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.garbu.mtgbrowser.R;
import com.example.garbu.mtgbrowser.SetsViewModel;
import com.example.garbu.mtgbrowser.adapters.SetListAdapter;
import com.example.garbu.mtgbrowser.db.MTGDB;
import com.example.garbu.mtgbrowser.model.Set;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SetListAdapter.SetListClickHandler{
    public static String SELECTED_SET_EXTRA = "selected_set";
    //private static final String setTypes = "core|expansion";
    private MTGDB mtgdb;
    //private List<Set> mSets = new ArrayList<>();
    private RecyclerView setsRV;
    private SetListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DB instance
        //mtgdb = MTGDB.getInstance(getApplicationContext());
        final SetsViewModel setsViewModel = ViewModelProviders.of(this).get(SetsViewModel.class);

        //setup RecyclerView
        setsRV = findViewById(R.id.set_list_rv);
        mLayoutManager = new LinearLayoutManager(this);
        setsRV.setLayoutManager(mLayoutManager);
        mAdapter = new SetListAdapter(this);
        setsRV.setAdapter(mAdapter);
        setsRV.setHasFixedSize(true);
        readDB(setsViewModel);

    }

    public void readDB(SetsViewModel setsViewModel){


        setsViewModel.getSets().observe(this, new Observer<List<Set>>() {
            @Override
            public void onChanged(@Nullable List<Set> sets) {
                mAdapter.setSets(sets);
            }
        });
    }


    @Override
    public void onClick(Set set) {

        //card list intent
        Intent intent = new Intent(this, CardListActivity.class);
        intent.putExtra(SELECTED_SET_EXTRA, set);
        startActivity(intent);

    }
}
